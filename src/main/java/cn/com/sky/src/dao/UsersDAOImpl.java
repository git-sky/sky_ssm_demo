package cn.com.sky.src.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.interfaces.UsersDAO;
import entity.Users;

public class UsersDAOImpl extends HibernateDaoSupport implements UsersDAO {

	public void save(Users user) {
		try {
			getHibernateTemplate().save(user);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void update(Users user) {
		try {
			getHibernateTemplate().saveOrUpdate(user);
		} catch (RuntimeException re) {
			throw re;
		}

	}

	public void delete(int id) throws Exception {
		try {
			this.getHibernateTemplate().delete(
					this.getHibernateTemplate().get(Users.class, id));
		} catch (Exception e) {
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Users> checkUser(Users user) {
		try {
			Query query = getSession()
					.createQuery(
							"from Users us where us.username=? and us.pass=? and us.roles.roleid=1");
			query.setParameter(0, user.getUsername());
			query.setParameter(1, user.getPass());
			return query.list();

		} catch (RuntimeException re) {
			throw re;
		}
	}

	public Users findById(int id) {
		try {
			Users user = (Users) getHibernateTemplate().get("entity.Users", id);
			return user;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public Users findByUsername(String username) {

		String queryString = "from Users users where users.username=? and users.roles.roleid=1";

		List<Users> user = getHibernateTemplate().find(queryString, username);
		if (user.size() > 0) {
			System.out.println(user.get(0));
			return user.get(0);
		} else {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public Users findByAdmin(String username) {

		String queryString = "from Users users where users.username=? and users.roles.roleid=2";

		List<Users> user = getHibernateTemplate().find(queryString, username);
		if (user.size() > 0)
			return user.get(0);
		return null;

	}

	@SuppressWarnings("unchecked")
	public List<Users> findAll(final String hql, final int page,
			final int pagecount) {
		return (List) this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws SQLException, HibernateException {
						Query q = session.createQuery(hql);
						q.setFirstResult((page - 1) * pagecount);
						q.setMaxResults(pagecount);
						List users = q.list();
						return users;
					}
				});
	}

	// 总条数
	@SuppressWarnings("unchecked")
	public int getTotalCount(String hql) {
		List<Users> user = getHibernateTemplate().find(hql);
		return user.size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> checkAdmin(Users user) {
		try {
			Query query = getSession()
					.createQuery(
							"from Users us where us.username=? and us.pass=? and us.roles.roleid=2");
			query.setParameter(0, user.getUsername());
			query.setParameter(1, user.getPass());
			return query.list();

		} catch (RuntimeException re) {
			throw re;
		}
	}

}
