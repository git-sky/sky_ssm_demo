package cn.com.sky.src.dao;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import dao.interfaces.AdvDAO;
import entity.Adv;

public class AdvDAOImpl extends HibernateDaoSupport implements AdvDAO {

	public void save(Adv adv) {

		try {
			getHibernateTemplate().save(adv);

		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void update(Adv adv) {
		try {
			getHibernateTemplate().saveOrUpdate(adv);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(int id) {
		try {
			this.getHibernateTemplate().delete(
					this.getHibernateTemplate().get(Adv.class, id));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List findAll() {
		String queryString = "from Adv";
		return getHibernateTemplate().find(queryString);
	}

	@Override
	public Adv queryAdvById(int id) {
		try {
			Adv adv = (Adv) getHibernateTemplate().get("entity.Adv", id);
			return adv;
		} catch (RuntimeException re) {
			throw re;
		}

	}
}