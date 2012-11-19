package mailbox;

import java.util.Collection;

import javax.ejb.Remote;

import entity.Messageentity;

@Remote
public interface IBox {
    
	public Collection<Messageentity> listAllMessages(int id);
	
	public Messageentity readAMessage(int id);
	
	public int addMessage(int id,String senderName, String receiverName,String sendingDate, String subject, String body, boolean alreadyRead);

	
	
}
