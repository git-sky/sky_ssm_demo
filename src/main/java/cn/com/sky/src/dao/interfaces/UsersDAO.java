package cn.com.sky.src.dao.interfaces;

import java.util.List;

import entity.Users;

public interface UsersDAO {

	public void save(Users users);

	public void update(Users user);

	public void delete(int id) throws Exception;

	public Users findById(int id);


	public Users findByUsername(String username);

	public Users findByAdmin(String username);

	public List checkAdmin(Users user);

	public List checkUser(Users user);

	public List findAll(final String hql, final int page, final int pagecount);

	// 总条数
	public int getTotalCount(String hql);

}