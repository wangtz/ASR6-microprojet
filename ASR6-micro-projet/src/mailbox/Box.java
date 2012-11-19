package mailbox;

import static javax.persistence.CascadeType.ALL;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;



public class Box implements IBox {
	
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
