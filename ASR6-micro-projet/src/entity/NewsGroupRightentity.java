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

	private int RightID;
	private boolean readNewsGroup;
	private boolean writeNewsGroup;
	private Userentity user;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getRightID() {
		return RightID;
	}

	public void setRightID(int rightID) {
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

	
    @OneToOne(cascade = ALL, mappedBy = "right")
	@JoinColumn(name = "userentity")
    public Userentity getUser() {

		return user;
	}

	public void setUser(Userentity user) {
		this.user = user;
	}

}
