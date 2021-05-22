package donation;

public class DonationList {
	private int dona_no;
	private String dona_title;
	private String dona_writer;
	private String dona_content;
	private String date;
	private int pa_amount;
	private String pa_level;
	public DonationList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DonationList(int dona_no, String dona_title, String dona_writer, String dona_content, String date,
			int pa_amount, String pa_level) {
		super();
		this.dona_no = dona_no;
		this.dona_title = dona_title;
		this.dona_writer = dona_writer;
		this.dona_content = dona_content;
		this.date = date;
		this.pa_amount = pa_amount;
		this.pa_level = pa_level;
	}
	public int getDona_no() {
		return dona_no;
	}
	public void setDona_no(int dona_no) {
		this.dona_no = dona_no;
	}
	public String getDona_title() {
		return dona_title;
	}
	public void setDona_title(String dona_title) {
		this.dona_title = dona_title;
	}
	public String getDona_writer() {
		return dona_writer;
	}
	public void setDona_writer(String dona_writer) {
		this.dona_writer = dona_writer;
	}
	public String getDona_content() {
		return dona_content;
	}
	public void setDona_content(String dona_content) {
		this.dona_content = dona_content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getPa_amount() {
		return pa_amount;
	}
	public void setPa_amount(int pa_amount) {
		this.pa_amount = pa_amount;
	}
	public String getPa_level() {
		return pa_level;
	}
	public void setPa_level(String pa_level) {
		this.pa_level = pa_level;
	}
	
}
