package cn.com.sky.src.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.interfaces.NewsDAO;
import entity.News;


public class NewsDAOImpl extends HibernateDaoSupport implements NewsDAO {

	public void save(News news) {
		try {
			getHibernateTemplate().save(news);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void update(News news) {
		try {
			getHibernateTemplate().saveOrUpdate(news);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	

	public News findById(int id) {
		try {
			News news = (News) getHibernateTemplate().get("entity.News",
					id);
			return news;
		} catch (RuntimeException re) {
			throw re;
		}
	}


	public News findByTitle(String title) {
		
			String queryString = "from News news where news.title=?";

			List<News> news = getHibernateTemplate().find(queryString, title);
			if (news.size() > 0)
				return news.get(0);
			return null;

	}

	public List findBySource(String source) {
		try {
			String queryString = "from News news where news.source= ?";
			return getHibernateTemplate().find(queryString, source);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<News> findAll(final String hql, final int page,
			final int pagecount) {
		return (List) this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws SQLException, HibernateException {
						Query q = session.createQuery(hql);
						q.setFirstResult((page - 1) * pagecount);
						q.setMaxResults(pagecount);
						List news = q.list();
						return news;
					}
				});
	}

	//总条数
	@SuppressWarnings("unchecked")
	public int getTotalCount(String hql) {
		List<News> news = getHibernateTemplate().find(hql);
		return news.size();
	}


	@Override
	public void delete(int id) {
		try {
			this.getHibernateTemplate().delete(
					this.getHibernateTemplate().get(News.class, id));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}