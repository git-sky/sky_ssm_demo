package cn.com.sky.src.entity;


public class News implements java.io.Serializable {

	private Integer newsid;
	private String title;
	private String source;
	private int readcount;
	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	private String contents;
	private String  date;


	public News() {
	}

	public News(String title, String source, String contents, String date) {
		this.title = title;
		this.source = source;
		this.contents = contents;
		this.date = date;
	}


	public Integer getNewsid() {
		return this.newsid;
	}

	public void setNewsid(Integer newsid) {
		this.newsid = newsid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}