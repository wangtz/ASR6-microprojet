package mailbox;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Messageentity;

@Stateless
public class Box implements IBox {

	
//	@PersistenceContext(unitName = "box1")
//	private EntityManager em;
	
	public Box(){}
	

	@Override
	public Collection<Messageentity> listAllMessages(int id) {

//		 try{
//			 
//			 Query q=em.createQuery("select b.Messages from Boxentity b where b.id= :id");
//			 q.setParameter("id", id);
//			 Collection<Messageentity> resultList = (Collection<Messageentity>)q.getResultList();
//			return resultList;
//			 
//		 } catch (NoResultException e) {
//				return null;
//		}
	return null;
		// TODO Auto-generated method stub	

	}

	@Override
	public void readAMessage(Messageentity msg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addMessage(Messageentity msg) {
		// TODO Auto-generated method stub

	}

}
