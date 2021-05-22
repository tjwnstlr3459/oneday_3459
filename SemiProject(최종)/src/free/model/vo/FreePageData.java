package free.model.vo;

import java.util.ArrayList;

public class FreePageData {
	private ArrayList<Free> list;
	private String pageNavi;

	public FreePageData() {
		super();
	}

	public FreePageData(ArrayList<Free> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}

	public ArrayList<Free> getList() {
		return list;
	}

	public void setList(ArrayList<Free> list) {
		this.list = list;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

}
