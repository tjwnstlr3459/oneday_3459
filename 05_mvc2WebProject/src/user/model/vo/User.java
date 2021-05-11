package user.model.vo;

public class User {
	private int UserNo;
	private String UserId;
	private String UserName;
	private int UserAge;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userNo, String userId, String userName, int userAge) {
		super();
		UserNo = userNo;
		UserId = userId;
		UserName = userName;
		UserAge = userAge;
	}
	public int getUserNo() {
		return UserNo;
	}
	public void setUserNo(int userNo) {
		UserNo = userNo;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public int getUserAge() {
		return UserAge;
	}
	public void setUserAge(int userAge) {
		UserAge = userAge;
	}
	
	
} 
