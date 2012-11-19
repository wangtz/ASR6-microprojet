package mailbox;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.MailBoxentity;
import entity.Userentity;

@Stateless(name = "uv6/filldata")
public class FillDataServer implements IFillDataServer {

	@PersistenceContext(unitName = "pu1")
	private EntityManager em;

	@Override
	public void fillData() {
		Userentity user1 = new Userentity();
		user1.setUserName("Dongdong GUO");

		MailBoxentity box1 = new MailBoxentity();
		box1.setBoxName("Dongdong's mailbox");
		box1.setUser(user1);
		box1.setMessages(null);
		user1.setMailbox(box1);

		em.persist(box1);
		em.persist(user1);
	}

}
