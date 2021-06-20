package cn.com.sky.src.dao;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import dao.interfaces.ArticleDAO;
import entity.Article;

public class ArticleDAOImpl extends HibernateDaoSupport implements ArticleDAO {

	public void save(Article article) {
		try {
			getHibernateTemplate().save(article);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void update(Article article) {
		try {
			getHibernateTemplate().saveOrUpdate(article);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(int id) {
		try {
			this.getHibernateTemplate().delete(
					this.getHibernateTemplate().get(Article.class, id));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Article findById(int id) {
		try {
			Article article = (Article) getHibernateTemplate().get(
					"entity.Article", id);
			return article;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public Article findByTitle(String title) {
		try {
			String queryString = "from Article article where article.title= ?";
					
			List<Article> article = getHibernateTemplate().find(queryString, title);
			if (article.size() > 0)
				return article.get(0);
		} catch (RuntimeException re) {
			throw re;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List findAll(final String hql, final int page,
			final int pagecount) {
		return (List) this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws SQLException, HibernateException {
						Query q = session.createQuery(hql);
						q.setFirstResult((page - 1) * pagecount);
						q.setMaxResults(pagecount);
						List articles = q.list();
						return articles;
					}
				});
	}

	//总条数
	@SuppressWarnings("unchecked")
	public int getTotalCount(String hql) {
		List<Article> article = getHibernateTemplate().find(hql);
		return article.size();
	}

	
}