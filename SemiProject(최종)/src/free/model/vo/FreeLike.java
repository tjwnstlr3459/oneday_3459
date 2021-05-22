package free.model.vo;

public class FreeLike {
	private int flNo;
	private int freeRef;
	private String memberId;

	public FreeLike() {
		super();
	}

	public FreeLike(int flNo, int freeRef, String memberId) {
		super();
		this.flNo = flNo;
		this.freeRef = freeRef;
		this.memberId = memberId;
	}

	public int getFlNo() {
		return flNo;
	}

	public void setFlNo(int flNo) {
		this.flNo = flNo;
	}

	public int getFreeRef() {
		return freeRef;
	}

	public void setFreeRef(int freeRef) {
		this.freeRef = freeRef;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

}