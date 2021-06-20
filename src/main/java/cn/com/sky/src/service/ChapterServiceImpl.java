package cn.com.sky.src.service;

import java.util.List;

import dao.interfaces.ChapterDAO;

import entity.Chapter;
import service.interfaces.ChapterService;

public class ChapterServiceImpl implements ChapterService {

	private ChapterDAO cd;

	public void setCd(ChapterDAO cd) {
		this.cd = cd;
	}

	public ChapterDAO getCd() {
		return cd;
	}

	public void addChapter(Chapter chapter) {
		cd.save(chapter);
	}

	public void deleteChapter(int id){
		cd.delete(id);
	}

	public List<Chapter> queryAllChapter() {
		return cd.findAll();
	}

	public Chapter queryChapterById(int id){
		return cd.findById(id);
	}

	public Chapter queryChapterByName(String name){
		return null;
	}

	public void updateChapter(Chapter chapter) {
		
		cd.update(chapter);
	}

}
