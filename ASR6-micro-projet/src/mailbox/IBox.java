package mailbox;

import java.util.Collection;

import javax.ejb.Remote;

import entity.Messageentity;

@Remote
public interface IBox {
    
	public Collection<Messageentity> listAllMessages(int id);
	
	public void readAMessage(Messageentity msg);
	
	public void addMessage(Messageentity msg);
	
	
}
