package cn.com.sky.src.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.interfaces.TestbankDAO;
import entity.Testbank;


public class TestbankDAOImpl extends HibernateDaoSupport implements TestbankDAO {
	
	public void save(Testbank testbank) {
		try {
			getHibernateTemplate().save(testbank);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void update(Testbank testbank) {
		try {
			getHibernateTemplate().saveOrUpdate(testbank);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public Testbank findById(int id) {
		try {
			Testbank instance = (Testbank) getHibernateTemplate().get(
					"entity.Testbank", id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}


	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from Testbank as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public Testbank findByTitle(String title) {
		String queryString = "from Testbank testbank where testbank.title=?";

		List<Testbank> testbank = getHibernateTemplate().find(queryString, title);
		if (testbank.size() > 0)
			return testbank.get(0);
		return null;
		
	}

	public List findByA(Object a) {
		return findByProperty(A, a);
	}

	public List findByB(Object b) {
		return findByProperty(B, b);
	}

	public List findByC(Object c) {
		return findByProperty(C, c);
	}

	public List findByD(Object d) {
		return findByProperty(D, d);
	}

	public List findByAnswer(Object answer) {
		return findByProperty(ANSWER, answer);
	}

	public void delete(int id) {
		try {
			this.getHibernateTemplate().delete(
					this.getHibernateTemplate().get(Testbank.class, id));
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
						List testbank = q.list();
						return testbank;
					}
				});
	}

	//总条数
	@SuppressWarnings("unchecked")
	public int getTotalCount(String hql) {
		List<Testbank> testbank = getHibernateTemplate().find(hql);
		return testbank.size();
	}

	public List generate(final String hql) {
		return getHibernateTemplate().find(hql);
	}





}