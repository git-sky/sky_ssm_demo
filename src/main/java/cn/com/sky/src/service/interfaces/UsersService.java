package cn.com.sky.src.service.interfaces;

import java.util.List;
import java.util.Map;

import entity.Users;

public interface UsersService {

	public boolean checkUser(Users user) throws Exception;

	public boolean checkAdmin(Users user) throws Exception;

	public void addUser(Users user) throws Exception;

	public Map show(int id)throws Exception;
	
	public void deleteUser(int id) throws Exception;

	public void updateUser(Users user) throws Exception;

	public Users queryUserByName(String username) throws Exception;

	public Users queryAdminByName(String name);

	public Users queryUserById(int id);

	public List<Users> queryAllUser(final String hql, final int page,
                                    final int pagecount);

	public int getTotalCount(String hql);

}
