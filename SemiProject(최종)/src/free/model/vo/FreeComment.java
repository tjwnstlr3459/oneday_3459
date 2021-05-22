package free.model.vo;

public class FreeComment {
	private int fcNo;
	private String fcWriter;
	private String fcContent;
	private String fcDate;
	private int freeRef;
	private int fcRef;

	public FreeComment() {
		super();
	}

	public FreeComment(int fcNo, String fcWriter, String fcContent, String fcDate, int freeRef, int fcRef) {
		super();
		this.fcNo = fcNo;
		this.fcWriter = fcWriter;
		this.fcContent = fcContent;
		this.fcDate = fcDate;
		this.freeRef = freeRef;
		this.fcRef = fcRef;
	}

	public int getFcNo() {
		return fcNo;
	}

	public void setFcNo(int fcNo) {
		this.fcNo = fcNo;
	}

	public String getFcWriter() {
		return fcWriter;
	}

	public void setFcWriter(String fcWriter) {
		this.fcWriter = fcWriter;
	}

	public String getFcContent() {
		return fcContent;
	}

	public void setFcContent(String fcContent) {
		this.fcContent = fcContent;
	}

	public String getFcDate() {
		return fcDate;
	}

	public void setFcDate(String fcDate) {
		this.fcDate = fcDate;
	}

	public int getFreeRef() {
		return freeRef;
	}

	public void setFreeRef(int freeRef) {
		this.freeRef = freeRef;
	}

	public int getFcRef() {
		return fcRef;
	}

	public void setFcRef(int fcRef) {
		this.fcRef = fcRef;
	}

}