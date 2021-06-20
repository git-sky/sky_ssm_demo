package cn.com.sky.src.service.interfaces;

import java.util.List;

import entity.News;
import entity.Users;

public interface NewsService {

	public void addNews(News news);

	public void updateNews(News news);

	public void deleteNews(int id);

	public News queryNewsByName(String name);

	public News queryNewsById(int id);
	
	public List<News> queryAllNews(final String hql, final int page, final int pagecount);
	
	//总条数
	public int getTotalCount(String hql);

}
