package directory;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Messageentity;
import entity.NewsGroupRightentity;
@Stateless
public class NewsGroupRight {
	
	@PersistenceContext(unitName = "pu1")
	private EntityManager em;
	
	public boolean getReadAccess(int newsgraouprightid) {
		
		NewsGroupRightentity n=this.findentityByid(newsgraouprightid);
		return n.isReadNewsGroup();
	
	}

	public void setReadAccess(int newsgraouprightid) {
		NewsGroupRightentity n=this.findentityByid(newsgraouprightid);
		n.setReadNewsGroup(true);
		em.persist(n);
	}

	public void unsetReadAccess(int newsgraouprightid) {
		NewsGroupRightentity n=this.findentityByid(newsgraouprightid);
		n.setReadNewsGroup(false);
		em.persist(n);
	}

	public boolean getWriteAccess(int newsgraouprightid) {
		NewsGroupRightentity n=this.findentityByid(newsgraouprightid);
		return n.isWriteNewsGroup();
	}

	public void setWriteAccess(int newsgraouprightid) {
		NewsGroupRightentity n=this.findentityByid(newsgraouprightid);
		n.setWriteNewsGroup(true);
		em.persist(n);
	}

	public void unsetWriteAccess(int newsgraouprightid) {
		NewsGroupRightentity n=this.findentityByid(newsgraouprightid);
		n.setWriteNewsGroup(false);
		em.persist(n);
	}

	public NewsGroupRightentity findentityByid(int newsgraouprightid)
	{
		
		Query q = em
				.createQuery("select n from newsgrouprightentity n where n.rightid= :id");
		q.setParameter("id", newsgraouprightid);
	  return (NewsGroupRightentity) q.getSingleResult();
		
	}
}
