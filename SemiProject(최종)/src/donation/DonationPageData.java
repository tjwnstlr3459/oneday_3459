package donation;

import java.util.ArrayList;


public class DonationPageData {
	private ArrayList<DonationList> list;
	private String pageNavi;
	public DonationPageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DonationPageData(ArrayList<DonationList> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}
	public ArrayList<DonationList> getList() {
		return list;
	}
	public void setList(ArrayList<DonationList> list) {
		this.list = list;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
}
