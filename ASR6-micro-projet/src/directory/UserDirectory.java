package directory;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.MailBoxentity;
import entity.Messageentity;
import entity.NewsGroupRightentity;
import entity.Userentity;
import mailbox.IMailBoxManagerBean;

@Stateless
public class UserDirectory implements IUserDirectory {
    private NewsGroupRight n;
    private IMailBoxManagerBean mailbox;
	@PersistenceContext(unitName = "pu1")
	private EntityManager em;
	
	@Override
	
//ÐèÒª¿¼¾¿	
	public void addUser(String username,String boxname) {
	Userentity user=new Userentity();
	MailBoxentity newbox = new MailBoxentity();
	NewsGroupRightentity nentity=new NewsGroupRightentity();
	
	
	user.setUserName(username);
	nentity.setReadNewsGroup(false);
	nentity.setWriteNewsGroup(false);
	newbox.setBoxName(boxname);
	
	user.setRight(nentity);
	nentity.setUser(user);
	newbox.setUser(user);
	user.setMailbox(newbox);
	
	em.persist(nentity);
	em.persist(user);
	em.persist(newbox);
//	mailbox.addUserMailbox(user, boxname);
	

	}

	@Override
	public boolean removeUser(int userid) {
		// TODO Auto-generated method stub
		 Userentity user=this.finduserByid(userid);
   if(user!=null)
   {
	  
     em.remove(user);
     return true;
     
   }
   else return false;
   }

	@Override
	public Collection<Userentity> lookupAllUsers() {
		// TODO Auto-generated method stub
		try {

			Query q = em
					.createQuery("select u from Userentity u");
			Collection<Userentity> resultList = q.getResultList();
			return resultList;

		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public NewsGroupRightentity lookupAUserRight(int userid) {
		// TODO Auto-generated method stub
     Userentity user=this.finduserByid(userid);
     return user.getRight();
	}

	@Override
	public void updateRights(int userid) {
		// TODO Auto-generated method stub
     Userentity user=this.finduserByid(userid);
     NewsGroupRightentity nentity=n.findentityByid(user.getRight().getRightID());
    user.setRight(nentity);
	}
	private Userentity finduserByid(int userid)
	{
		
		Query q = em
				.createQuery("select u from userentity u where u.userid= :id");
		q.setParameter("id", userid);
	  return (Userentity) q.getSingleResult();
		
	}
    public Userentity finduserByname(String username)
	{
		
		Query q = em
				.createQuery("select u from userentity u where u.username= :name");
		q.setParameter("name", username);
	  return (Userentity) q.getSingleResult();
		
	}
	
	

}
