package cn.com.sky.src.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.interfaces.RolesDAO;
import entity.Roles;


public class RolesDAOImpl extends HibernateDaoSupport implements RolesDAO {

	public void save(Roles roles) {
		try {
			getHibernateTemplate().save(roles);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void update(Roles roles) {
		try {
			getHibernateTemplate().save(roles);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(Roles roles) {
		try {
			getHibernateTemplate().delete(roles);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public Roles findById(int id) {
		try {
			Roles roles = (Roles) getHibernateTemplate().get(
					"entity.Roles", id);
			return roles;
		} catch (RuntimeException re) {
			throw re;
		}
	}


	public List findByRolename(String rolename) {
		try {
			String queryString = "from Roles roles where roles.rolename= ?";
			return getHibernateTemplate().find(queryString, rolename);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List findAll() {
		try {
			String queryString = "from Roles";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			throw re;
		}
	}

}