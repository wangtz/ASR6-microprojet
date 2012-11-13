package mailbox;

import directory.FinalUser;

public interface IMailBoxManager {
	
public void listAUserNewMessages();

public void listAUserAllMessages();

public void readAUserAMessage(Message msg);

public void deleteAUserAmessage(Message msg);

public void deleteAUserReadMessages();

public void sendAMessageToABox(Message msg);

public void addUserMailbox(FinalUser user);

public void removeUserMailBox(FinalUser user);

public void sendNews(Message msg);
}
