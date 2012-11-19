package mailbox;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import directory.FinalUser;

@Stateless(name="uv6/mailbox")
public class IMailBoxManagerBean implements IMailBoxManager {

    @PersistenceContext(unitName="pu1")
    private EntityManager em;

	@Override
	public void listAUserNewMessages() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listAUserAllMessages() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readAUserAMessage(Message msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAUserAmessage(Message msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAUserReadMessages() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendAMessageToABox(Message msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUserMailbox(FinalUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUserMailBox(FinalUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendNews(Message msg) {
		// TODO Auto-generated method stub
		
	}

}
