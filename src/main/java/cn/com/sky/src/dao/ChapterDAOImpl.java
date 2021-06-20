package cn.com.sky.src.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.interfaces.ChapterDAO;
import entity.Chapter;

public class ChapterDAOImpl extends HibernateDaoSupport implements ChapterDAO {

	public void save(Chapter chapter) {
		try {
			getHibernateTemplate().save(chapter);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void update(Chapter chapter) {
		try {
			getHibernateTemplate().saveOrUpdate(chapter);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(int id) {
		try {
			this.getHibernateTemplate().delete(
					this.getHibernateTemplate().get(Chapter.class, id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public Chapter findById(int id) {
		try {
			Chapter instance = (Chapter) getHibernateTemplate().get(
					"entity.Chapter", id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List findByName(String name) {
		try {
			String queryString = "from Chapter chapter where chapter.name= ?";
			return getHibernateTemplate().find(queryString, name);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List findAll() {
		try {
			String queryString = "from Chapter";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
