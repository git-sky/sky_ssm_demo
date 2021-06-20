package cn.com.sky.src.dao.interfaces;

import java.util.List;

import entity.Article;

public interface ArticleDAO {

	public void save(Article article);

	public void update(Article article);

	public void delete(int id);

	public Article findById(int id);

	public Article findByTitle(String title);

	public List findAll(String hql, int page, int pagecount);

	// 总条数
	public int getTotalCount(String hql);


}