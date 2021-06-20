package cn.com.sky.src.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.interfaces.ResourceDAO;
import entity.Resource;

public class ResourceDAOImpl extends HibernateDaoSupport implements ResourceDAO {

	public void save(Resource resource) {
		try {
			getHibernateTemplate().save(resource);
		} catch (RuntimeException re) {
			throw new RuntimeException("上传资源出错！");
		}
	}

	public void delete(int id) {
		try {
			this.getHibernateTemplate().delete(
					this.getHibernateTemplate().get(Resource.class, id));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public List findAll(final String hql, final int page, final int pagecount) {
		return (List) this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws SQLException, HibernateException {
						Query q = session.createQuery(hql);
						q.setFirstResult((page - 1) * pagecount);
						q.setMaxResults(pagecount);
						List resource = q.list();
						return resource;
					}
				});
	}

	// 总条数
	@SuppressWarnings("unchecked")
	public int getTotalCount(String hql) {
		List<Resource> resource = getHibernateTemplate().find(hql);
		return resource.size();
	}

	public Resource findById(int id) {
		try {
			Resource resource = (Resource) getHibernateTemplate().get(
					"entity.Resource", id);
			return resource;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public Resource findByResourcename(String resourcename) {
		String queryString = "from Resource resource where resource.resourcename=?";

		List<Resource> resource = getHibernateTemplate().find(queryString, resourcename);
		if (resource.size() > 0)
			return resource.get(0);
		return null;

	}

	@Override
	public Resource findByAdmin(String username) {
		return null;
	}

	@Override
	public Resource findByUsername(String username) {
		return null;
	}

	@Override
	public void update(Resource resource) {
		try {
			getHibernateTemplate().saveOrUpdate(resource);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	

	@Override
	public List findResourceByUserId(final int id) {
		return (List) this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws SQLException, HibernateException {
						Query q = session
								.createQuery("from Resource res where res.users.userid='"
										+ id + "'");
						List res = q.list();
						return res;
					}
				});
	}


}