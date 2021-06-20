package cn.com.sky.src.service.interfaces;

import java.util.List;

import entity.Roles;

public interface RolesService {

	public boolean addRoles(Roles roles);

	public boolean deleteRoles(int id);

	public boolean updateRoles(Roles roles);

	public List<Roles> queryAllRoles();

	public Roles queryRolesByName(String name);

	public Roles queryRolesById(int id);
}
