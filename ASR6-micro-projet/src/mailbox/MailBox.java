package mailbox;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Messageentity;



public class MailBox extends Box implements IMailBox {
	
	@PersistenceContext(unitName = "pu1")
	private EntityManager em;

	@Override
	public boolean deleteAMessage(int messageid) {
		try {
			Query q = em
					.createQuery("delete from Messageentity m where m.messageid= :id");
			q.setParameter("id", messageid);
			return true;

		} catch (NoResultException e) {
		  return false;
		}
		
	}

	@Override
	public boolean deleteReadMessages() {
		// TODO Auto-generated method stub
		try {
			Query q = em
					.createQuery("delete from Messageentity m where m.alreadyread=true");
			return true;

		} catch (NoResultException e) {
		  return false;
		}
	}

	@Override
	public boolean deleteAllMessage() {
		// TODO Auto-generated method stub
		try {
			Query q = em
					.createQuery("delete from Messageentity m ");
			return true;

		} catch (NoResultException e) {
		  return false;
		}
	}
	

	@Override
	public Collection<Messageentity> liestNewMessages() {
		try {
			Query q = em
					.createQuery("delete from Messageentity m where m.alreadyread=false");
			Collection<Messageentity> resultList = q.getResultList();
			return resultList;

		} catch (NoResultException e) {
		  return null;
		}
		
	}

}
