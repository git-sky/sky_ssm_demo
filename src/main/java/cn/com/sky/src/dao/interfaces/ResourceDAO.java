package cn.com.sky.src.dao.interfaces;

import java.util.List;
import entity.Resource;

public interface ResourceDAO {
	public void save(Resource res);

	public void update(Resource res);

	public Resource findById(int id);

	public Resource findByUsername(String username);
	
	//public Resource findByUserId(int id);
	
	public Resource findByAdmin(String username);

	public void delete(int id);

	public List<Resource> findAll(String hql, int page, int pagecount);

	// 总条数
	public int getTotalCount(String hql);

	public Resource findByResourcename(String resourcename);

	List findResourceByUserId(int id);
	
}
