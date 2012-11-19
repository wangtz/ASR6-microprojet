package mailbox;

import entity.Messageentity;

public class Message {

	public void setIsRead(Messageentity message) {
		message.setAlreadyRead(true);
	}

	public boolean isRead(Messageentity message) {
		return message.isAlreadyRead();
	}


}
