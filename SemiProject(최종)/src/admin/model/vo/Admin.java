package admin.model.vo;

public class Admin {
	private int adminNo;
	private String adminId;
	private String adminPw;
	private String adminName;
	private String phone;
	private String addr;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int adminNo, String adminId, String adminPw, String adminName, String phone, String addr) {
		super();
		this.adminNo = adminNo;
		this.adminId = adminId;
		this.adminPw = adminPw;
		this.adminName = adminName;
		this.phone = phone;
		this.addr = addr;
	}
	public int getAdminNo() {
		return adminNo;
	}
	public void setAdminNo(int adminNo) {
		this.adminNo = adminNo;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPw() {
		return adminPw;
	}
	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
