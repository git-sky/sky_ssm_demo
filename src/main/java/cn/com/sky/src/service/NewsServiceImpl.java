package cn.com.sky.src.service;

import java.util.List;

import dao.interfaces.NewsDAO;

import entity.News;
import entity.Users;
import service.interfaces.NewsService;

public class NewsServiceImpl implements NewsService {
	
	private NewsDAO nd;

	public void setNd(NewsDAO nd) {
		this.nd = nd;
	}

	public NewsDAO getNd() {
		return nd;
	}

	public void addNews(News news) {
		nd.save(news);

	}

	public void deleteNews(int id) {
	nd.delete(id);
	}

	public News queryNewsById(int id) {
		return nd.findById(id);
	}

	public News queryNewsByName(String title) {
		return nd.findByTitle(title);
	}

	public void updateNews(News news) {
	nd.update(news);
	}

	@Override
	public int getTotalCount(String hql) {
	return nd.getTotalCount(hql);
	}

	@Override
	public List<News> queryAllNews(String hql, int page, int pagecount) {
		return nd.findAll(hql, page, pagecount);
	}



}
