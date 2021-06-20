package cn.com.sky.src.service;

import java.util.List;

import dao.interfaces.RolesDAO;

import entity.Roles;
import service.interfaces.RolesService;

public class RolesServiceImpl implements RolesService {
	private RolesDAO rd;

	public void setRd(RolesDAO rd) {
	this.rd = rd;
}

public RolesDAO getRd() {
	return rd;
}

	public boolean addRoles(Roles roles) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteRoles(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Roles> queryAllRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	public Roles queryRolesById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Roles queryRolesByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateRoles(Roles roles) {
		// TODO Auto-generated method stub
		return false;
	}

}
