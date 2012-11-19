package mailbox;

import java.util.Collection;
import java.util.Collections;

import javax.ejb.Remote;

import directory.FinalUser;
import entity.Messageentity;
import entity.Userentity;



@Remote public interface IMailBoxManager {

	
public Collection<Messageentity> listAUserNewMessages(int boxentityid);

public Collection<Messageentity> listAUserAllMessages(int boxentityid);

public Messageentity readAUserAMessage(int boxentityid,int messageid);

public boolean deleteAUserAmessage(int boxentityid, int messageid);

public boolean deleteAUserReadMessages(int boxentityid);

public boolean sendAMessageToABox(int boxentityid, String receiverName,
		String sendingDate, String subject, String body, boolean alreadyRead);

public boolean addUserMailbox(Userentity user, String boxName);

public boolean removeUserMailBox(Userentity user);

public boolean sendNews(int boxentityid, String newsboxName,
		String sendingDate, String subject, String body, boolean alreadyRead);
}
