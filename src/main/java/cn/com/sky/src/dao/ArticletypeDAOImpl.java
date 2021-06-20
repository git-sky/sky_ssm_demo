package cn.com.sky.src.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.interfaces.ArticletypeDAO;
import entity.Article;
import entity.Articletype;


public class ArticletypeDAOImpl extends HibernateDaoSupport implements ArticletypeDAO {

	public void save(Articletype articletype) {
		try {
			getHibernateTemplate().save(articletype);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void update(Articletype articletype) {
		try {
			getHibernateTemplate().saveOrUpdate(articletype);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(int id) {
		try {
			this.getHibernateTemplate().delete(
					this.getHibernateTemplate().get(Articletype.class, id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public Articletype findById(int id) {
		try {
			Articletype articletype = (Articletype) getHibernateTemplate().get(
					"entity.Articletype", id);
			return articletype;
		} catch (RuntimeException re) {
			throw re;
		}
	}



	public List findByName(String name) {
		try {
			String queryString = "from Articletype articletype where articletype.name= ?";
			return getHibernateTemplate().find(queryString, name);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public List findAll() {
			String queryString = "from Articletype";
			return getHibernateTemplate().find(queryString);
	}

	//总条数
	@SuppressWarnings("unchecked")
	public int getTotalCount() {
		String queryString = "from Aricles";
		List<Article> articletype = getHibernateTemplate().find(queryString);
		return articletype.size();
	}

	//总页数
	public int getTotalPage(int pageSize) {
		int totalCount = getTotalCount();
		return ((totalCount + pageSize) - 1) / pageSize;

	}


}