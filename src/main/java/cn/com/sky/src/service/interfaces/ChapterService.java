package cn.com.sky.src.service.interfaces;

import java.util.List;
import entity.Chapter;

public interface ChapterService {

	public void addChapter(Chapter chapter) throws Exception;

	public void deleteChapter(int id) throws Exception;

	public void updateChapter(Chapter chapter) throws Exception;

	public List<Chapter> queryAllChapter();

	public Chapter queryChapterById(int id) throws Exception;

	public Chapter queryChapterByName(String name) throws Exception;
}
