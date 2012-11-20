package directory;

import javax.ejb.Stateless;

import entity.NewsGroupRightentity;
import entity.Userentity;

@Stateless
public class FinalUser {

	private UserDirectory userdirectory;

	public NewsGroupRightentity getUserRight(int userID) {

		return userdirectory.lookupAUserRight(userID);
	}

	public void updateUserRight(int userid,String whichright,boolean change) {
	        userdirectory.updateRights(userid, whichright, change);
		
	}

}
