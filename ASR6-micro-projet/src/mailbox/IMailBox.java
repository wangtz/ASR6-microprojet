package mailbox;

import javax.ejb.Remote;


@Remote
public interface IMailBox {

	public void deleteAMessage(Message msg);

	public void deleteReadMessages();
	
	public void deleteAllMessage();
	
	public void liestNewMessages();

}
