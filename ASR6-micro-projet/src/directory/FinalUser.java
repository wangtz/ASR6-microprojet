package directory;

import static javax.persistence.CascadeType.ALL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import mailbox.MailBox;
//test
@Entity
public class FinalUser {

	private int userID;
	private String userName;
	private NewsGroupRight right;
    private MailBox mailbox;
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public NewsGroupRight getRight() {
		return right;
	}

	public void setRight(NewsGroupRight right) {
		this.right = right;
	}

	 @OneToOne(cascade = ALL, mappedBy = "finaluser")
	@JoinColumn(name = "mailbox_id")
	public MailBox getMailbox() {
		return mailbox;
	}

	public void setMailbox(MailBox mailbox) {
		this.mailbox = mailbox;
	}
	
	
	

	public String getUserRight() {
		return null;
	}

	public void updateUserRight() {
	}

}
