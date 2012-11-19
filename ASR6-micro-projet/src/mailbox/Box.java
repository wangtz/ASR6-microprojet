package mailbox;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Boxentity;
import entity.Messageentity;

@Stateless
public class Box implements IBox {

	@PersistenceContext(unitName = "pu1")
	private EntityManager em;

	public Box() {
	}

	@Override
	public Collection<Messageentity> listAllMessages(int boxentityid) {

		try {

			Query q = em
					.createQuery("select m from Messageentity m where m.boxentity= :id");
			q.setParameter("id", boxentityid);
			Collection<Messageentity> resultList = q.getResultList();
			return resultList;

		} catch (NoResultException e) {
			return null;
		}
		// return null;
		// TODO Auto-generated method stub

	}

	@Override
	public Messageentity readAMessage(int Messageid) {
		// TODO Auto-generated method stub
		try {
			Query q = em
					.createQuery("select m from Messageentity m where m.messageid= :id");
			q.setParameter("id", Messageid);
			Messageentity message=(Messageentity)q.getSingleResult();
			message.isAlreadyRead();
			em.persist(message);
			return (Messageentity) q.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}

	}

	@Override
	public int addMessage(int id, String senderName, String receiverName,
			String sendingDate, String subject, String body, boolean alreadyRead) {
		// TODO Auto-generated method stub
		try {
			Boxentity box = findBoxentityByid(id);
			Messageentity message = new Messageentity();
			message.setSenderName(senderName);
			message.setReceiverName(receiverName);
			message.setSendingDate(sendingDate);
			message.setSubject(subject);
			message.setBody(body);
			message.setAlreadyRead(alreadyRead);
			message.setBox(box);
			box.getMessages().add(message);
			em.persist(message);
			return 1;
		} catch (NoResultException e) {
			return -1;
		}

	}

	private Boxentity findBoxentityByid(int id) {
		Query q = em
				.createQuery("select b from Boxentity b where b.boxid = :id");
		q.setParameter("id", id);
		return (Boxentity) q.getSingleResult();
	}

}
