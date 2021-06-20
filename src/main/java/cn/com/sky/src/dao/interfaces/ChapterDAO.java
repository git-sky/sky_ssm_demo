package cn.com.sky.src.dao.interfaces;

import java.util.List;

import entity.Chapter;

public interface ChapterDAO {

	public void save(Chapter chapter);

	public void update(Chapter chapter);

	public void delete(int id);

	public Chapter findById(int id);

	public List findByName(String name);

	public List findAll();

}