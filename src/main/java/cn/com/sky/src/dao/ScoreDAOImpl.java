package cn.com.sky.src.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.interfaces.ScoreDAO;
import entity.Score;

public class ScoreDAOImpl extends HibernateDaoSupport implements ScoreDAO {

	public void save(Score score) {
		try {
			getHibernateTemplate().save(score);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void update(Score score) {
		try {
			getHibernateTemplate().save(score);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(int id) {
		try {
			this.getHibernateTemplate().delete(
					this.getHibernateTemplate().get(Score.class, id));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Score findById(int id) {
		try {
			Score score = (Score) getHibernateTemplate()
					.get("entity.Score", id);
			return score;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@Override
	public List findScoreByUserId(final int id) {
		return (List) this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws SQLException, HibernateException {
						Query q = session
								.createQuery("from Score score where score.users.userid='"
										+ id + "'");
						List score = q.list();
						return score;
					}
				});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Score> findAll(final String hql, final int curPage,
			final int pageSize) {
		return (List) this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws SQLException, HibernateException {
						Query q = session.createQuery(hql);
						q.setFirstResult((curPage - 1) * pageSize);
						q.setMaxResults(pageSize);
						List scores = q.list();
						return scores;
					}
				});
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getTotalCount(String hql) {
		String queryString =hql;
		List<Score> score = getHibernateTemplate().find(queryString);

		return score.size();
	}

	public List generate(final String hql) {
		return getHibernateTemplate().find(hql);
	}

}