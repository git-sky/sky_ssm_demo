package cn.com.sky.src.dao;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import dao.interfaces.BbsDAO;
import entity.Bbs;

public class BbsDAOImpl extends HibernateDaoSupport implements BbsDAO {

	public void save(Bbs bbs) {
		try {
			getHibernateTemplate().save(bbs);
		} catch (RuntimeException re) {
			throw new RuntimeException("主题添加错误！");
		
		}
	}

	public void update(Bbs bbs) {
		try {
			getHibernateTemplate().saveOrUpdate(bbs);
		} catch (RuntimeException re) {
			throw new RuntimeException("主题修改错误！");
		}
	}

	public void delete(int id) {
		try {
			this.getHibernateTemplate().delete(
					this.getHibernateTemplate().get(Bbs.class, id));
		} catch (RuntimeException re) {
			throw new RuntimeException("主题删除错误！");
		}
	}

	public Bbs findById(int id) {
		try {
			Bbs bbs = (Bbs) getHibernateTemplate().get("entity.Bbs", id);
			return bbs;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List findBbsByUserId(final int id) {

		return (List) this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws SQLException, HibernateException {
						Query q = session
								.createQuery("from Bbs bbs where bbs.users.userid='"
										+ id + "'");
						List bbs = q.list();
						return bbs;
					}
				});
	}

	public Bbs findByTitle(String title) {
			return (Bbs) getHibernateTemplate().get("entity.Bbs", title);
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
						List bbs = q.list();
						return bbs;
					}
				});
	}

	// 总条数
	@SuppressWarnings("unchecked")
	public int getTotalCount(String hql) {
		List<Bbs> bbs = getHibernateTemplate().find(hql);
		return bbs.size();
	}

}