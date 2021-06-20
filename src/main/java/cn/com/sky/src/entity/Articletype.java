package cn.com.sky.src.entity;

import java.util.HashSet;
import java.util.Set;

public class Articletype implements java.io.Serializable {

	private Integer articletypeid;
	private String name;
	private Set articles = new HashSet();

	public Articletype() {
	}

	public Articletype(String name) {
		this.name = name;
	}

	public Articletype(String name, Set articles) {
		this.name = name;
		this.articles = articles;
	}

	public Integer getArticletypeid() {
		return this.articletypeid;
	}

	public void setArticletypeid(Integer articletypeid) {
		this.articletypeid = articletypeid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getArticles() {
		return this.articles;
	}

	public void setArticles(Set articles) {
		this.articles = articles;
	}

}