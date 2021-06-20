package cn.com.sky.src.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.interfaces.ReplyDAO;
import entity.Reply;

public class ReplyDAOImpl extends HibernateDaoSupport implements ReplyDAO {

	public void save(Reply reply) {
		try {
			getHibernateTemplate().save(reply);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public Reply findById(int id) {
		try {
			Reply reply = (Reply) getHibernateTemplate()
					.get("entity.Reply", id);
			return reply;
		} catch (RuntimeException re) {
			throw re;
		}
	}



	public void delete(int id) {
		try {
			this.getHibernateTemplate().delete(
					this.getHibernateTemplate().get(Reply.class, id));
		} catch (Exception e) {
			e.printStackTrace();
		}
	
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
						List reply = q.list();
						return reply;
					}
				});
	}
	
	
	@SuppressWarnings("unchecked")
	public List findAll(String hql) {
		return getHibernateTemplate().find(hql);
	}

	//总条数
	@SuppressWarnings("unchecked")
	public int getTotalCount() {
		String queryString = "from Aricles";
		List<Reply> reply = getHibernateTemplate().find(queryString);
		return reply.size();
	}

	//总页数
	public int getTotalPage(int pageSize) {
		int totalCount = getTotalCount();
		return ((totalCount + pageSize) - 1) / pageSize;

	}

}