package entity;

import static javax.persistence.CascadeType.ALL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class NewsGroupRightentity {
	
    private String RightID;
	private boolean readNewsGroup;
	private boolean writeNewsGroup;
	private Userentity user;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String getRightID() {
		return RightID;
	}
	public void setRightID(String rightID) {
		RightID = rightID;
	}
	public boolean isReadNewsGroup() {
		return readNewsGroup;
	}
	public void setReadNewsGroup(boolean readNewsGroup) {
		this.readNewsGroup = readNewsGroup;
	}
	public boolean isWriteNewsGroup() {
		return writeNewsGroup;
	}
	public void setWriteNewsGroup(boolean writeNewsGroup) {
		this.writeNewsGroup = writeNewsGroup;
	}
	
    @OneToOne(cascade = ALL, mappedBy = "newsgrouprightentity")
	@JoinColumn(name = "userentity_id")
    public Userentity getUser() {
		return user;
	}
	public void setUser(Userentity user) {
		this.user = user;
	}
	
  
	
}