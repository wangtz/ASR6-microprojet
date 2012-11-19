package mailbox;

import static javax.persistence.CascadeType.ALL;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import directory.FinalUser;


public class MailBox extends Box implements IMailBox {
	

	@Override
	public void deleteAMessage(Message msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteReadMessages() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllMessage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void liestNewMessages() {
		// TODO Auto-generated method stub
		
	}

}
