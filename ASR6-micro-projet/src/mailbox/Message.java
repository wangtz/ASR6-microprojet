package mailbox;

import static javax.persistence.CascadeType.ALL;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import entity.NewsGroupRightentity;
import entity.Messageentity;

public class Message {


	public void setIsRead(Messageentity message) {
		message.setAlreadyRead(true);
	}

	public boolean isRead(Messageentity message) {
		return message.isAlreadyRead();
	}


}
