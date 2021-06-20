package cn.com.sky.src.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.interfaces.ResourcetypeDAO;
import entity.Resourcetype;


public class ResourcetypeDAOImpl extends HibernateDaoSupport implements ResourcetypeDAO {

	public void save(Resourcetype resourcetype) {
		try {
			getHibernateTemplate().save(resourcetype);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void update(Resourcetype resourcetype) {
		try {
			getHibernateTemplate().saveOrUpdate(resourcetype);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void delete(int id) {
		try {
			this.getHibernateTemplate().delete(
					this.getHibernateTemplate().get(Resourcetype.class, id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public Resourcetype findById(int id) {
		try {
			Resourcetype resourcetype = (Resourcetype) getHibernateTemplate().get(
					"entity.Resourcetype", id);
			return resourcetype;
		} catch (RuntimeException re) {
			throw re;
		}
	}


	public List findByResourcename(String resourcename) {
		try {
			String queryString = "from Resourcetype  resourcetype where resourcetype.resourcename= ?";
			return getHibernateTemplate().find(queryString, resourcename);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List findAll() {
		try {
			String queryString = "from Resourcetype";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			throw re;
		}
	}

}