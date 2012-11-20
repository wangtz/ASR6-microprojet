package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import mailbox.IFillDataServer;
import mailbox.IMailBoxManager;

public class MailboxApplication {

	private static IMailBoxManager mailboxManager = null;
	
	/**
	 * @param args
	 * @throws NamingException 
	 */
	public static void main(String[] args) throws NamingException {
		InitialContext ic = new InitialContext();
		mailboxManager = (IMailBoxManager) ic.lookup("mailbox.IMailBox");
		
		MailboxApplication app = new MailboxApplication();
		app.getUserName();
		
		displayLineBreak();

		displayAllMessages();

		while (true) {

			executeNextCommand();
		}

	}
	
	public void MailboxApplication()
	{
		
	}

	private String getUserName() {
		// TODO Auto-generated method stub
		
	}

	private static void executeNextCommand() {
		BufferedReader bufferedreader = new BufferedReader(
				new InputStreamReader(System.in));
		String number = null;
		try {

			number = bufferedreader.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
			System.exit(-1);
		}
		try {
			int value = Integer.parseInt(number);

			displayLineBreak();
			System.out.println("Message " + value + ": ");
			System.out.println("Subject: Message subject");
			System.out.println("Recepient: YOU");
			System.out.println("Content: Message content");

			return;
		} catch (NumberFormatException e) {
			try {
				if (number.trim().equals("d")) {
					System.out.println("Delte message of id: ");
					String line = bufferedreader.readLine();
					int id = Integer.parseInt(line);
					System.out.println("Message deleted.");

				} else if (number.trim().equals("w")) {

					System.out.println("Subject: ");
					String subject = bufferedreader.readLine();
					System.out.println("Recipient: ");
					String recipent = bufferedreader.readLine();
					String content = getContent(bufferedreader);
					// System.in.skip(System.in.available());
					System.out.println("Message sent.");
				} else if (number.trim().equals("q")) {
					System.out.println("System quited");
					System.exit(-1);
				} else {
					System.out.println("Command unknown!");
					return;
				}
			} catch (IOException e1) {
				System.out.println("Command unknown!");
				return;
			}
		}
		return;
	}

	private static String getContent(BufferedReader bufferedreader) {
		String content = "";
		while (true) {
			String line = null;
			try {
				line = bufferedreader.readLine();
			} catch (IOException e) {
				// EOF
				line = null;
				break;
			}
			if (line == null) {
				break;
			} else {
				content += line;
			}
		}
		return content;
	}

	private static void displayAllMessages() {
		System.out.println("All messages:");
		int i;
		
	//	mailboxManager.listAUserAllMessages();
		for (i = 0; Math.random() > 0.2; i++) {
			char isNew;
			int msgId;
			String msgTitle;

			isNew = (Math.random() > 0.5) ? 'N' : ' ';
			msgId = i;
			msgTitle = "This is a new msg";

			System.out.printf("> %c %d %s\n", isNew, msgId, msgTitle);
		}

		System.out.println("NewsList:");
		for (; Math.random() > 0.3; i++) {
			char isNew;
			int msgId;
			String msgTitle;

			isNew = (Math.random() > 0.5) ? 'N' : ' ';
			msgId = i;
			msgTitle = "A new list msg.";

			System.out.printf("> %c %d %s\n", isNew, msgId, msgTitle);
		}
	}

	private static void displayLineBreak() {
		for (int i = 0; i < 80; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

}
