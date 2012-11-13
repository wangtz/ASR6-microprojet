package application;
// test
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DirectoryManagerApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		displayLineBreak();

		System.out.println("Print password: ");

		displayAllUsers();

		while (true) {

			executeNextCommand();
		}

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
			if (number.trim().equals("d")) {
				System.out.println("Delte user of id: ");
				String line = bufferedreader.readLine();
				int id = Integer.parseInt(line);
				System.out.println("User deleted.");

			} else if (number.trim().equals("a")) {

				System.out.println("Username: ");
				String username = bufferedreader.readLine();
				System.out.println("Userwrite (r, rw): ");
				String right = bufferedreader.readLine();
				System.out.println("User created.");
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

	private static void displayAllUsers() {
		System.out.println("All users:");
		int i;
		for (i = 0; Math.random() > 0.2; i++) {
			int msgId;
			String msgTitle;
			String right;

			msgId = i;
			msgTitle = "username";
			right = (Math.random() > 0.5) ? "Read" : "Read & Write";

			System.out.printf("> %d %s %s\n", msgId, msgTitle, right);
		}

	}

	private static void displayLineBreak() {
		for (int i = 0; i < 80; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

}
