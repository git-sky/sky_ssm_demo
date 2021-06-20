package cn.com.sky.src.entity;

public class Adv {

	private int advid;
	private String title;
	private String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	private String contents;

	public Adv() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAdvid() {
		return advid;
	}

	public void setAdvid(int advid) {
		this.advid = advid;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

}
