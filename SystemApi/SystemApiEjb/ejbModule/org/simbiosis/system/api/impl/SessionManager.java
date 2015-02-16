package org.simbiosis.system.api.impl;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.xml.bind.DatatypeConverter;

import org.simbiosis.system.api.bean.ISessionManager;
import org.simbiosis.system.bean.ISecurity;
import org.simbiosis.system.bean.IUser;
import org.simbiosis.system.model.OperationLog;
import org.simbiosis.system.model.Session;
import org.simbiosis.system.model.User;

@Stateless
@Remote(ISessionManager.class)
public class SessionManager implements ISessionManager {

	@EJB(lookup = "java:global/System/SystemEjb/SecurityImpl")
	ISecurity iSecurity;
	@EJB(lookup = "java:global/System/SystemEjb/UserImpl")
	IUser iUser;
	@EJB
	SystemLog systemLog;

	@Override
	public String getSalt() {
		return iSecurity.registerSalt();
	}

	@Override
	public String login(String userName, String saltPasswordB64) {
		String datas[] = saltPasswordB64.split(":");
		String salt = datas[0];
		String passwordB64 = saltPasswordB64.substring(salt.length() + 1);
		// Periksa salt
		if (iSecurity.getSaltValid(salt) != 0) {
			byte[] bytePassword = DatatypeConverter
					.parseBase64Binary(passwordB64);
			// Ambil password
			String password = new String(bytePassword).substring(salt.length());
			// Cari user dan cocokkan passwordnya
			User user = iUser.getUserByName(userName);
			if (user != null && user.getPassword().equalsIgnoreCase(password)
					&& user.getActive() == 1) {
				Session session = new Session(iSecurity.getRandomHash(32), user);
				iSecurity.saveSession(session);
				// Hapus salt
				iSecurity.unregisterSalt(salt);
				// Masukkan ke log
				systemLog.sendOperationLog(new OperationLog(user.getId(),
						session.getName(), "LOGIN"));
				//
				return session.getName();
			}
			// Hapus salt
			iSecurity.unregisterSalt(salt);
		}
		return "";
	}

	@Override
	public void logout(String sessionName) {
		Session session = iSecurity.getSession(sessionName);
		if (session != null) {
			session.setEnd(new Date());
			session.setValid(0);
			iSecurity.saveSession(session);
			// Log
			systemLog.sendOperationLog(new OperationLog(session.getUser()
					.getId(), session.getName(), "LOGOUT"));
		}
	}

}
