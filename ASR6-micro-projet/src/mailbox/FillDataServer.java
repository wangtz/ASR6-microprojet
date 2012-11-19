package mailbox;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.MailBoxentity;
import entity.Messageentity;
import entity.NewsBoxentity;
import entity.NewsGroupRightentity;
import entity.Userentity;

@Stateless(name = "filldata")
public class FillDataServer implements IFillDataServer {

	@PersistenceContext(unitName = "pu1")
	private EntityManager em;

	@Override
	public void fillData() {
		NewsBoxentity newsBox = new NewsBoxentity();
		Messageentity msg;
		
		newsBox.setBoxName("newsbox");
		
		Userentity userReadOnly = createUserForNewsGroupReadOnly();
		Userentity userAdmin = createUserAdmin();
		msg = sendMessage(userReadOnly, userAdmin);
		
		msg = broadcast(newsBox, userAdmin);
	}

	public Messageentity broadcast(NewsBoxentity newsBox, Userentity adminSender) {
		Messageentity msg = new Messageentity();
		msg.setSubject("[Annoncement] YB is going back to china.");
		msg.setBody("RT.");
		msg.setSenderName(adminSender.getUserName());
		msg.setBox(newsBox);
		newsBox.getMessages().add(msg);

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		msg.setSendingDate(dateFormat.format(date));
		
		em.persist(msg);
		em.persist(newsBox);
		
		return msg;
	}

	public Messageentity sendMessage(Userentity to, Userentity from) {
		Messageentity msg = new Messageentity();
		msg.setSubject("Returning party.");
		msg.setBody("Will you join party tonight?");
		msg.setReceiverName(to.getUserName());
		msg.setSenderName(from.getUserName());
		msg.setBox(to.getMailbox());

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		msg.setSendingDate(dateFormat.format(date));

		to.getMailbox().getMessages().add(msg);
		
		em.persist(msg);
		em.persist(to.getMailbox());
		return msg;
	}

	private Userentity createUserForNewsGroupReadOnly() {
		Userentity user1 = new Userentity();
		user1.setUserName("Dongdong GUO");

		MailBoxentity box1 = new MailBoxentity();
		box1.setBoxName("Dongdong's mailbox");
		box1.setUser(user1);
		box1.setMessages(null);
		user1.setMailbox(box1);

		NewsGroupRightentity right1 = new NewsGroupRightentity();
		right1.setReadNewsGroup(true);
		right1.setWriteNewsGroup(false);
		user1.setRight(right1);

		em.persist(user1);
		em.persist(box1);
		em.persist(right1);

		return user1;
	}

	private Userentity createUserAdmin() {
		Userentity user1 = new Userentity();
		user1.setUserName("Duan Shen");

		MailBoxentity box1 = new MailBoxentity();
		box1.setBoxName("Duan's mailbox");
		box1.setUser(user1);
		box1.setMessages(null);
		user1.setMailbox(box1);

		NewsGroupRightentity right1 = new NewsGroupRightentity();
		right1.setReadNewsGroup(true);
		right1.setWriteNewsGroup(true);
		user1.setRight(right1);

		em.persist(user1);
		em.persist(box1);
		em.persist(right1);

		return user1;
	}

}
