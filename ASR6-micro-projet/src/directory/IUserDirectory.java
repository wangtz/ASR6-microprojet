package directory;

import java.util.Collection;

import javax.ejb.Remote;

import entity.NewsGroupRightentity;
import entity.Userentity;

@Remote
public interface IUserDirectory {

	public void addUser(String username, String boxname);

	public boolean removeUser(int userid);

	public Collection<Userentity> lookupAllUsers();

	public NewsGroupRightentity lookupAUserRight(int userid);

	public void updateRights(int userid,String whichright,boolean change);
	
	public Userentity finduserByid(int userid);
	
	public Userentity finduserByid(String username);
}
