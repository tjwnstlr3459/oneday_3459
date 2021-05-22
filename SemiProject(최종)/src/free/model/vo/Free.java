package free.model.vo;

public class Free {
	private int rnum;
	private int freeNo;
	private String freeTitle;
	private String freeWriter;
	private String freeContent;
	private String freeDate;
	private String filepath;
	private int readCount;
	private int likeCount;

	public Free() {
		super();
	}

	public Free(int rnum, int freeNo, String freeTitle, String freeWriter, String freeContent, String freeDate,
			String filepath, int readCount, int likeCount) {
		super();
		this.rnum = rnum;
		this.freeNo = freeNo;
		this.freeTitle = freeTitle;
		this.freeWriter = freeWriter;
		this.freeContent = freeContent;
		this.freeDate = freeDate;
		this.filepath = filepath;
		this.readCount = readCount;
		this.likeCount = likeCount;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public int getFreeNo() {
		return freeNo;
	}

	public void setFreeNo(int freeNo) {
		this.freeNo = freeNo;
	}

	public String getFreeTitle() {
		return freeTitle;
	}

	public void setFreeTitle(String freeTitle) {
		this.freeTitle = freeTitle;
	}

	public String getFreeWriter() {
		return freeWriter;
	}

	public void setFreeWriter(String freeWriter) {
		this.freeWriter = freeWriter;
	}

	public String getFreeContent() {
		return freeContent;
	}

	public void setFreeContent(String freeContent) {
		this.freeContent = freeContent;
	}

	public String getFreeDate() {
		return freeDate;
	}

	public void setFreeDate(String freeDate) {
		this.freeDate = freeDate;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
}
