package entity;

import static javax.persistence.CascadeType.ALL;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity

public class MailBoxentity extends Boxentity{
   private Userentity user;
   
   @OneToOne(cascade = ALL, mappedBy = "mailbox")
   @JoinColumn(name = "userentity")
   	public Userentity getUser() {
   		return user;
   	}


	public void setUser(Userentity user) {
		this.user = user;
	}

}
