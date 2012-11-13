package mailbox;

import static javax.persistence.CascadeType.ALL;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



public class Box implements IBox {
	
	
	private int boxID;
	private String boxName;
	private Collection<Message> Messages = new ArrayList<Message>(); 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getBoxID() {
		return boxID;
	}

	public void setBoxID(int boxID) {
		this.boxID = boxID;
	}

	public String getBoxName() {
		return boxName;
	}

	public void setBoxName(String boxName) {
		this.boxName = boxName;
	}
	@OneToMany(cascade = ALL, mappedBy = "box")
	public Collection<Message> getMessages() {
		return Messages;
	}

	public void setMessages(Collection<Message> messages) {
		Messages = messages;
	}

	@Override
	public void listAllMessages() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readAMessage(Message msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addMessage(Message msg) {
		// TODO Auto-generated method stub
		
	}

}
