package cn.com.sky.src.service.interfaces;

import java.util.List;

import entity.Article;
import entity.Users;

public interface ArticleService {
	
	public void addArticle(Article article);

	public void deleteArticle(int id) throws Exception;

	public void updateArticle(Article article) throws Exception;

	public Article queryArticleById(int id);

	public Article queryArticleByName(String name) throws Exception;
	
	public List<Article> queryAllArticle(final String hql, final int page, final int pagecount);
	//总条数
	public int getTotalCount(String hql);

}

