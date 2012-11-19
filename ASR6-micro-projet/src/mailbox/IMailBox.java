package mailbox;

import java.util.Collection;

import javax.ejb.Remote;

import entity.Messageentity;


@Remote
public interface IMailBox {

	public boolean deleteAMessage(int messageid);

	public boolean deleteReadMessages();
	
	public boolean deleteAllMessage();
	
	public Collection<Messageentity> liestNewMessages();

}
