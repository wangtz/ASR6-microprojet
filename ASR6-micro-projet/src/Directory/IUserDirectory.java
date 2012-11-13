package Directory;

public interface IUserDirectory {

  public void addUser(FinalUser user);
  
  public void removeUser(FinalUser user);
 
  public void lookupAllUsers();
  
  public void lookupAUserRight(FinalUser user);
  
  public void updateRights(FinalUser user);
}
