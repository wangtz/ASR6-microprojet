package directory;

import javax.ejb.Stateless;

import entity.NewsGroupRightentity;

@Stateless
public class FinalUser {

	private UserDirectory userdirectory;

	public NewsGroupRightentity getUserRight(int userID) {

		return userdirectory.lookupAUserRight(userID);
	}

	public void updateUserRight(int userID) {
		userdirectory.updateRights(userID);
	}

}
