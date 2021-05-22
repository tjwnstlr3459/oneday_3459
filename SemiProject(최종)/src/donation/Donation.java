package donation;

public class Donation {

	private String pa_use;
	private String pa_kind;
	private String pa_lev;
	private String pa_name;
	private String pa_phone;
	private String pa_email;
	private String pa_email2;
	private int price_choice;
	
	public Donation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Donation(String pa_use, String pa_kind, String pa_lev, String pa_name, String pa_phone, String pa_email,
			String pa_email2, int price_choice) {
		super();
		this.pa_use = pa_use;
		this.pa_kind = pa_kind;
		this.pa_lev = pa_lev;
		this.pa_name = pa_name;
		this.pa_phone = pa_phone;
		this.pa_email = pa_email;
		this.pa_email2 = pa_email2;
		this.price_choice = price_choice;
	}
	public String getPa_use() {
		return pa_use;
	}
	public void setPa_use(String pa_use) {
		this.pa_use = pa_use;
	}
	public String getPa_kind() {
		return pa_kind;
	}
	public void setPa_kind(String pa_kind) {
		this.pa_kind = pa_kind;
	}
	public String getPa_lev() {
		return pa_lev;
	}
	public void setPa_lev(String pa_lev) {
		this.pa_lev = pa_lev;
	}
	public String getPa_name() {
		return pa_name;
	}
	public void setPa_name(String pa_name) {
		this.pa_name = pa_name;
	}
	public String getPa_phone() {
		return pa_phone;
	}
	public void setPa_phone(String pa_phone) {
		this.pa_phone = pa_phone;
	}
	public String getPa_email() {
		return pa_email;
	}
	public void setPa_email(String pa_email) {
		this.pa_email = pa_email;
	}
	public String getPa_email2() {
		return pa_email2;
	}
	public void setPa_email2(String pa_email2) {
		this.pa_email2 = pa_email2;
	}
	public int getPrice_choice() {
		return price_choice;
	}
	public void setPrice_choice(int price_choice) {
		this.price_choice = price_choice;
	}
	
	
}



	