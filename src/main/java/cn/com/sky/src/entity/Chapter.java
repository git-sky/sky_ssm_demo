package cn.com.sky.src.entity;

import java.util.HashSet;
import java.util.Set;

public class Chapter implements java.io.Serializable {


	private Integer chapterid;
	private String name;
	private Set scores = new HashSet();
	private Set testbanks = new HashSet();


	public Chapter() {
	}

	public Chapter(String name) {
		this.name = name;
	}

	public Chapter(String name, Set scores, Set testbanks) {
		this.name = name;
		this.scores = scores;
		this.testbanks = testbanks;
	}


	public Integer getChapterid() {
		return this.chapterid;
	}

	public void setChapterid(Integer chapterid) {
		this.chapterid = chapterid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getScores() {
		return this.scores;
	}

	public void setScores(Set scores) {
		this.scores = scores;
	}

	public Set getTestbanks() {
		return this.testbanks;
	}

	public void setTestbanks(Set testbanks) {
		this.testbanks = testbanks;
	}

}