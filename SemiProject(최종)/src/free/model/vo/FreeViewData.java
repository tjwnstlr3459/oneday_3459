package free.model.vo;

import java.util.ArrayList;

public class FreeViewData {
	private Free f;
	private ArrayList<FreeComment> list;
	private int love;

	public FreeViewData() {
		super();
	}

	public FreeViewData(Free f, ArrayList<FreeComment> list, int love) {
		super();
		this.f = f;
		this.list = list;
		this.love = love;
	}

	public Free getF() {
		return f;
	}

	public void setF(Free f) {
		this.f = f;
	}

	public ArrayList<FreeComment> getList() {
		return list;
	}

	public void setList(ArrayList<FreeComment> list) {
		this.list = list;
	}

	public int getLove() {
		return love;
	}

	public void setLove(int love) {
		this.love = love;
	}

}