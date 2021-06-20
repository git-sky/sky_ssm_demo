package cn.com.sky.src.entity;

public class Article implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer articleid;
	private Articletype articletype;
	private String title;
	private int readcount;
	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	private String contents;
	private String date;


	public Article() {
	}

	public Article(Articletype articletype, String title, String contents,
			String date) {
		this.articletype = articletype;
		this.title = title;
		this.contents = contents;
		this.date = date;
	}


	public Integer getArticleid() {
		return this.articleid;
	}

	public void setArticleid(Integer articleid) {
		this.articleid = articleid;
	}

	public Articletype getArticletype() {
		return this.articletype;
	}

	public void setArticletype(Articletype articletype) {
		this.articletype = articletype;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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