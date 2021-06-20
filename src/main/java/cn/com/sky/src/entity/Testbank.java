package cn.com.sky.src.entity;


public class Testbank implements java.io.Serializable {


	private Integer testid;
	private Chapter chapter;
	private String title;
	private String a;
	private String b;
	private String c;
	private String d;
	private String answer;


	public Testbank() {
	}

	public Testbank(Chapter chapter, String title, String a, String b,
			String c, String d, String answer) {
		this.chapter = chapter;
		this.title = title;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.answer = answer;
	}


	public Integer getTestid() {
		return this.testid;
	}

	public void setTestid(Integer testid) {
		this.testid = testid;
	}

	public Chapter getChapter() {
		return this.chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getA() {
		return this.a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return this.b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getC() {
		return this.c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public String getD() {
		return this.d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}