package test;

import static org.junit.Assert.*;

import java.util.Collection;

import javax.naming.InitialContext;

import mailbox.IBox;
import mailbox.IMailBox;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.Messageentity;

public class MailBoxTest {
	private IMailBox mailbox;
	private IBox box;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		InitialContext ic = new InitialContext();
		mailbox = (IMailBox) ic.lookup("mailbox.IMailBox");
		box = (IBox) ic.lookup("mailbox.IBox");
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testDeleteAMessage() {
		int messageId = 3;
		box.addMessage(messageId, "Ddongdong", "Tiezhen", "2012-11-02",
				"hello", "body", false);
		
		Collection<Messageentity> allMsgs1 = box.listAllMessages(boxId);
		assertEquals(allMsgs1.size() + 1, allMsgs1.size());

		mailbox.deleteAMessage(messageId);

		Collection<Messageentity> allMsgs2 = box.listAllMessages(boxId);
		assertEquals(allMsgs1.size() + 1, allMsgs2.size());
		fail("Pas encore implémenté"); // TODO
	}

	@Test
	public final void testDeleteReadMessages() {
		fail("Pas encore implémenté"); // TODO
	}

	@Test
	public final void testDeleteAllMessage() {
		int messageId = 4;
		box.addMessage(messageId, "Ddongdong", "Tiezhen", "2012-11-02",
				"hello", "body", false);
		mailbox.deleteAllMessage();
		
		fail("Pas encore implémenté"); // TODO
	}

	@Test
	public final void testLiestNewMessages() {
		fail("Pas encore implémenté"); // TODO
	}

	@Test
	public final void testBox() {
		fail("Pas encore implémenté"); // TODO
	}

	@Test
	public final void testListAllMessages() {
		int boxId = 0; // TODO
		Collection<Messageentity> allMsgs1 = box.listAllMessages(boxId);
		box.addMessage(1, "Ddongdong", "Tiezhen", "2012-11-02", "hello",
				"body", false);
		Collection<Messageentity> allMsgs2 = box.listAllMessages(boxId);
		assertEquals(allMsgs1.size() + 1, allMsgs2.size());
	}

	@Test
	public final void testReadAMessage() {
		fail("Pas encore implémenté"); // TODO
	}

	@Test
	public final void testAddMessage() {
		// why can't call method of box)??
		assertEquals(box.addMessage(0, "Ddongdong", "Tiezhen", "2012-11-02",
				"hello", "body", false), 1);
	}

}
