package mailbox;

import javax.ejb.Remote;

@Remote
public interface IFillDataServer {
	public void fillData();
}
