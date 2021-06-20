package cn.com.sky.src.dao.interfaces;

import java.util.List;

import entity.News;

public interface NewsDAO {

	public void save(News news);

	public void update(News news);

	public void delete(int id);

	public News findById(int id);

	public News findByTitle(String title);

	public List findBySource(String source);

	public int getTotalCount(String hql) ;


	public List<News> findAll(String hql, int page, int pagecount) ;
}