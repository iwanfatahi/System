package org.simbiosis.system.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.jboss.security.Base64Utils;
import org.simbiosis.system.bean.ISecurity;
import org.simbiosis.system.model.Salt;
import org.simbiosis.system.model.Session;

@Stateless
@Remote(ISecurity.class)
public class SecurityImpl implements ISecurity {

	@PersistenceContext(unitName = "SystemEjb", type = PersistenceContextType.TRANSACTION)
	EntityManager em;

	@Override
	public String getRandomHash(int length) {
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[length];
		random.nextBytes(bytes);
		return Base64Utils.tob64(bytes);
	}

	/**
	 * The byte[] returned by MessageDigest does not have a nice textual
	 * representation, so some form of encoding is usually performed.
	 *
	 * This implementation follows the example of David Flanagan's book
	 * "Java In A Nutshell", and converts a byte array into a String of hex
	 * characters.
	 *
	 * Another popular alternative is to use a "Base64" encoding.
	 */
	private String hexEncode(byte[] aInput) {
		StringBuilder result = new StringBuilder();
		char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		for (int idx = 0; idx < aInput.length; ++idx) {
			byte b = aInput[idx];
			result.append(digits[(b & 0xf0) >> 4]);
			result.append(digits[b & 0x0f]);
		}
		return result.toString();
	}

	@Override
	public String getUriRandomHash() {
		try {
			// Initialize SecureRandom
			// This is a lengthy operation, to be done only upon
			// initialization of the application
			SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");

			// generate a random number
			String randomNum = new Integer(prng.nextInt()).toString();

			// get its digest
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] result = sha.digest(randomNum.getBytes());

			return hexEncode(result);

		} catch (NoSuchAlgorithmException ex) {
			System.err.println(ex);
		}
		return "";
	}

	@Override
	public String getUriRandomHash(String prefix) {
		try {
			// Initialize SecureRandom
			// This is a lengthy operation, to be done only upon
			// initialization of the application
			SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");

			// generate a random number
			String randomNum = new Integer(prng.nextInt()).toString();
			String toHash = randomNum + "_" + prefix;

			// get its digest
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] result = sha.digest(toHash.getBytes());

			return hexEncode(result);

		} catch (NoSuchAlgorithmException ex) {
			System.err.println(ex);
		}
		return "";
	}

	@Override
	public String registerSalt() {
		Salt salt = new Salt(getRandomHash(8));
		em.persist(salt);
		return salt.getValue();
	}

	@Override
	public void unregisterSalt(String value) {
		Salt salt = em.find(Salt.class, value);
		salt.setValid(0);
	}

	@Override
	public int getSaltValid(String value) {
		Salt salt = em.find(Salt.class, value);
		return salt.getValid();
	}

	@Override
	public void saveSession(Session session) {
		if (session.getId() == 0) {
			em.persist(session);
		} else {
			em.merge(session);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Session getSession(String name) {
		Query qry = em.createNamedQuery("getSessionByName");
		qry.setParameter("name", name);
		List<Session> sessions = qry.getResultList();
		if (sessions.size() > 0) {
			return sessions.get(0);
		}
		return null;
	}

}
