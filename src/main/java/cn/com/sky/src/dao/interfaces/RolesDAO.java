package cn.com.sky.src.dao.interfaces;

import java.util.List;

import entity.Roles;

public interface RolesDAO {

	public void save(Roles roles);

	public void update(Roles roles);

	public void delete(Roles roles);

	public Roles findById(int id);

	public List findByRolename(String rolename);

	public List findAll();

}