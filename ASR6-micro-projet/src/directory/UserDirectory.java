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
	
//��Ҫ����	
	public void addUser(String username,String boxname) {
	Userentity user=new Userentity();
//	MailBoxentity mailboxentity=new MailBoxentity();
	NewsGroupRightentity nentity=new NewsGroupRightentity();
	user.setUserName(username);
	nentity.setReadNewsGroup(false);
	nentity.setWriteNewsGroup(false);
	
	user.setRight(nentity);
	nentity.setUser(user);
	em.persist(nentity);
	em.persist(user);
	mailbox.addUserMailbox(user, boxname);
	

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
	public void updateRights(int userid,String whichright,boolean change) {
		// TODO Auto-generated method stub
     Userentity user=this.finduserByid(userid);
     if(whichright=="WriteAccess"&&change==true) n.setWriteAccess(user.getRight().getRightID());
     else if(whichright=="WriteAccess"&&change==false) n.unsetWriteAccess(user.getRight().getRightID());
     else if(whichright=="ReadAccess"&&change==true)n.setReadAccess(user.getRight().getRightID());
     else  n.unsetReadAccess(user.getRight().getRightID());
	}
	public Userentity finduserByid(int userid)
	{
		
		Query q = em
				.createQuery("select u from userentity u where u.userid= :id");
		q.setParameter("id", userid);
	  return (Userentity) q.getSingleResult();
		
	}
	public Userentity finduserByid(String username)
	{
		
		Query q = em
				.createQuery("select u from userentity u where u.username= :username");
		q.setParameter("username", username);
	  return (Userentity) q.getSingleResult();
		
	}
	
	
	

}
