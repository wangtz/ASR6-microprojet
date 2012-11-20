package mailbox;

import javax.ejb.Stateless;

import entity.Messageentity;
@Stateless
public class Message {

	public void setIsRead(Messageentity message) {
		message.setAlreadyRead(true);
	}

	public boolean isRead(Messageentity message) {
		return message.isAlreadyRead();
	}


}
