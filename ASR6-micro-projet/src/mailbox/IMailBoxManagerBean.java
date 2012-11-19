package mailbox;

import java.util.Collection;
import java.util.Collections;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import directory.FinalUser;
import entity.Boxentity;
import entity.MailBoxentity;
import entity.Messageentity;
import entity.Userentity;

@Stateless(name = "uv6/mailbox")
public class IMailBoxManagerBean implements IMailBoxManager {

	@PersistenceContext(unitName = "pu1")
	private EntityManager em;

	@Override
	public Collection<Messageentity> listAUserNewMessages(int boxentityid) {
		// TODO Auto-generated method stub
		try {

			Query q = em
					.createQuery("select m from Messageentity m where m.boxentity= :id and m.alreadyread=false");
			q.setParameter("id", boxentityid);
			Collection<Messageentity> resultList = q.getResultList();
			return resultList;

		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Collection<Messageentity> listAUserAllMessages(int boxentityid) {
		// TODO Auto-generated method stub
		Box box = new Box();
		return box.listAllMessages(boxentityid);
	}

	@Override
	public Messageentity readAUserAMessage(int boxentityid, int messageid) {
		try {
			Query q = em
					.createQuery("select m from Messageentity m where m.messageid= :messageid and m.boxentity= :boxentityid");
			q.setParameter("messageid", messageid);
			q.setParameter("boxentityid", boxentityid);
           Messageentity message=(Messageentity)q.getSingleResult();
           message.isAlreadyRead();
           em.persist(message);
			return (Messageentity) q.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}

	}

	@Override
	public boolean deleteAUserAmessage(int boxentityid, int messageid) {
		try {
			Query q = em
					.createQuery("delete from Messageentity m where m.messageid= :messageid and m.boxentity= :boxentityid");
			q.setParameter("messageid", messageid);
			q.setParameter("boxentityid", boxentityid);
			q.executeUpdate();
			return true;

		} catch (NoResultException e) {
			return false;
		}

	}

	@Override
	public boolean deleteAUserReadMessages(int boxentityid) {
		// TODO Auto-generated method stub
		try {
			Query q = em
					.createQuery("delete from Messageentity m where m.messageid= :messageid and m.alreadyread=true");
			q.setParameter("boxentityid", boxentityid);
			q.executeUpdate();
			return true;

		} catch (NoResultException e) {
			return false;
		}

	}

	@Override
	public boolean sendAMessageToABox(int boxentityid, String receiverName,
			String sendingDate, String subject, String body, boolean alreadyRead) {
		// TODO Auto-generated method stub
		try {
			Boxentity receiverbox = findboxentityByname(receiverName);
			Boxentity senderbox = findBoxentityByid(boxentityid);
			Messageentity message = new Messageentity();
			message.setSenderName(senderbox.getBoxName());
			message.setReceiverName(receiverName);
			message.setSendingDate(sendingDate);
			message.setSubject(subject);
			message.setBody(body);
			message.setAlreadyRead(alreadyRead);
			message.setBox(receiverbox);
			receiverbox.getMessages().add(message);
			em.persist(message);
			return true;
		} catch (NoResultException e) {
			return false;
		}
	}

	@Override
	public boolean addUserMailbox(Userentity user, String boxName) {
		try {
			MailBoxentity newbox = new MailBoxentity();
			newbox.setBoxName(boxName);
			newbox.setUser(user);
			user.setMailbox(newbox);
			em.persist(newbox);
			return true;
		} catch (NoResultException e) {
			return false;
		}
	}

	@Override
	public boolean removeUserMailBox(Userentity user) {
		// TODO Auto-generated method stub
		try {
			Query q = em
					.createQuery("delete from Boxentity b where b.boxid= :id");
			q.setParameter("boxentityid", user.getMailbox());
			q.executeUpdate();
			return true;

		} catch (NoResultException e) {
			return false;
		}


	}

	@Override
	public boolean sendNews(int boxentityid, String newsboxName,
			String sendingDate, String subject, String body, boolean alreadyRead) {
		
		if(this.sendAMessageToABox(boxentityid, newsboxName, sendingDate, subject, body, alreadyRead))return true;
		else return false;
		
	
	}

	private Boxentity findBoxentityByid(int id) {
		Query q = em
				.createQuery("select b from Boxentity b where b.boxid = :id");
		q.setParameter("id", id);
		return (Boxentity) q.getSingleResult();
	}

	private Boxentity findboxentityByname(String receiverName) {
		Query q = em
				.createQuery("select b from Boxentity b where b.boxname = :receiverName");
		q.setParameter("receiverName", receiverName);
		return (Boxentity) q.getSingleResult();
	}

}
