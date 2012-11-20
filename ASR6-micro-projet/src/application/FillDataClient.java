package application;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

//import org.omg.CORBA.Context;<>

import mailbox.IFillDataServer;
import mailbox.IMailBoxManager;

public class FillDataClient {

	/**
	 * @param args
	 * @throws NamingException
	 */
	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.enterprise.naming.SerialInitContextFactory");
		props.setProperty("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
		props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
		
		InitialContext ic = new InitialContext(props);
		IFillDataServer sb = (IFillDataServer) ic
				.lookup("mailbox.IFillDataServer");
		System.out.println("lookup [OK]");
		
		sb.fillData();
		System.out.println("c'est la fin de fill data");
		
		
		
	}

}
