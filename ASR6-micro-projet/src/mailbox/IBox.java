package mailbox;

public interface IBox {
    
	public void listAllMessages();
	
	public void readAMessage(Message msg);
	
	public void addMessage(Message msg);
	
	
}
