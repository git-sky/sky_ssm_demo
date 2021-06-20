package cn.com.sky.src.service.interfaces;

import java.util.List;

import entity.Resource;
import entity.Resourcetype;

public interface ResourceService {

	public void addResource(Resource resource);

	public void deleteResource(int id);

	public void updateResource(Resource resource);

	public List<Resource> queryAllResource(String hql, int page, int pagecount);

	public Resource queryResourceByName(String name);

	public Resource queryResourceById(int resourcetypeid);
	
	public List<Resourcetype> queryAllResourcetype();
	
	public Resourcetype queryResourcetypeById(int id);
	
	public int getTotalCount(String hql);


}
