package cafe.model.vo;

public class Cafe {
	private String cafeId;
	private String cafePw;
	private String cafeName;
	private String cafeAddr;
	private String cafeInfo;
	public Cafe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cafe(String cafeId, String cafePw, String cafeName, String cafeAddr, String cafeInfo) {
		super();
		this.cafeId = cafeId;
		this.cafePw = cafePw;
		this.cafeName = cafeName;
		this.cafeAddr = cafeAddr;
		this.cafeInfo = cafeInfo;
	}
	public String getCafeId() {
		return cafeId;
	}
	public void setCafeId(String cafeId) {
		this.cafeId = cafeId;
	}
	public String getCafePw() {
		return cafePw;
	}
	public void setCafePw(String cafePw) {
		this.cafePw = cafePw;
	}
	public String getCafeName() {
		return cafeName;
	}
	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}
	public String getCafeAddr() {
		return cafeAddr;
	}
	public void setCafeAddr(String cafeAddr) {
		this.cafeAddr = cafeAddr;
	}
	public String getCafeInfo() {
		return cafeInfo;
	}
	public void setCafeInfo(String cafeInfo) {
		this.cafeInfo = cafeInfo;
	}
	
	
}
