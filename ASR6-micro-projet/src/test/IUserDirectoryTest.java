/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.Collection;

import javax.naming.InitialContext;

import mailbox.IBox;
import mailbox.IMailBox;
import mailbox.IMailBoxManager;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import directory.IUserDirectory;
import entity.Userentity;

/**
 * @author wang_tie
 * 
 */
public class IUserDirectoryTest {

	private IMailBoxManager mailboxManager;
	private IBox box;
	private IMailBox mailbox;
	private IUserDirectory userDirectory;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		InitialContext ic = new InitialContext();
		System.out.println("Test begin: ");

		mailboxManager = (IMailBoxManager) ic.lookup("mailbox.IMailBoxManager");
		box = (IBox) ic.lookup("mailbox.IBox");
		mailbox = (IMailBox) ic.lookup("mailbox.IMailBox");

		IUserDirectory userDirectory = (IUserDirectory) ic
				.lookup("directory.IUserDirectory");
	}

	@Test
	public void testAddAUser() {
		String username = "Dongdong";
		Collection<Userentity> allUsers = userDirectory.lookupAllUsers();
		userDirectory.addUser(username, username + "'s mailbox");

		assertEquals(userDirectory.lookupAllUsers().size(), allUsers.size()+1);
	}

	@Test
	public void testLookupAUserRight() {
		String username = "Dongdong2";
		userDirectory.addUser(username, username + "'s mailbox");

		// TODO? updateRights
		Collection<Userentity> allUsers = userDirectory.lookupAllUsers();
		assertEquals(userDirectory.lookupAllUsers().size(), allUsers.size()+1);
	}
}
