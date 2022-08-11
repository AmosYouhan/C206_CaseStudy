import java.util.ArrayList;

public class Account {
	
	private int accId;
	private String password;
	private String pName;
	private String sName;
	
	public Account(int accId, String password, String pName, String sName) {
		this.accId = accId;
		this.password = password;
		this.pName = pName;
		this.sName = sName;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

}
