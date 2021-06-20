package cn.com.sky.src.service;

import java.util.List;

import dao.interfaces.ArticleDAO;

import entity.Article;
import service.interfaces.ArticleService;

public class ArticleServiceImpl implements ArticleService {

	private ArticleDAO ad;

	public void setAd(ArticleDAO ad) {
		this.ad = ad;
	}

	public ArticleDAO getAd() {
		return ad;
	}

	public void addArticle(Article article){
		ad.save(article);
	}

	public void deleteArticle(int id) throws Exception {
		ad.delete(id);
	}

	public Article queryArticleById(int id){
		return ad.findById(id);
	}

	public Article queryArticleByName(String title) throws Exception {

		return ad.findByTitle(title);
	}

	public void updateArticle(Article article) throws Exception {
		ad.update(article);
	}

	@Override
	public int getTotalCount(String hql) {

		return ad.getTotalCount(hql);
	}


	@Override
	public List<Article> queryAllArticle(String hql, int page, int pagecount) {
		return ad.findAll(hql, page, pagecount);
	}

}
