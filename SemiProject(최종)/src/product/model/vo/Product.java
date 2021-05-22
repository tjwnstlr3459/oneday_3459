package product.model.vo;

public class Product {
	private int rnum;
	private int productNo;
	private String productTitle;
	private String productInfo;
	private String filename;
	private String filepath;
	private String productContent;
	private String productSpons;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int rnum, int productNo, String productTitle, String productInfo, String filename, String filepath,
			String productContent, String productSpons) {
		super();
		this.rnum = rnum;
		this.productNo = productNo;
		this.productTitle = productTitle;
		this.productInfo = productInfo;
		this.filename = filename;
		this.filepath = filepath;
		this.productContent = productContent;
		this.productSpons = productSpons;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	public String getProductInfo() {
		return productInfo;
	}
	public String getProductInfoBr() {
		return productInfo.replaceAll("\r\n", "<br>");
	}
	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getProductContent() {
		return productContent;
	}
	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}
	public String getProductSpons() {
		return productSpons;
	}
	public void setProductSpons(String productSpons) {
		this.productSpons = productSpons;
	}
	
	
}
