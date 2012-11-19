package application;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import mailbox.IFillDataServer;

public class FillDataClient {

	/**
	 * @param args
	 * @throws NamingException
	 */
	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		InitialContext ic = new InitialContext();
		IFillDataServer sb = (IFillDataServer) ic.lookup("mailbox.IFillDataServer");

		sb.fillData();
		System.out.println("c'est la fin");
	}

}
