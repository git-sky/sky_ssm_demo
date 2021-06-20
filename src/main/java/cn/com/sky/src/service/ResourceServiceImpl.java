package cn.com.sky.src.service;

import java.util.List;
import dao.interfaces.ResourceDAO;
import dao.interfaces.ResourcetypeDAO;
import entity.Resource;
import entity.Resourcetype;
import service.interfaces.ResourceService;

public class ResourceServiceImpl implements ResourceService {

	private ResourceDAO rd;
	
	private ResourcetypeDAO rtd;

	public void setRtd(ResourcetypeDAO rtd) {
		this.rtd = rtd;
	}

	public void setRd(ResourceDAO rd) {
		this.rd = rd;
	}

	public void addResource(Resource resource) {
		rd.save(resource);

	}

	public void deleteResource(int id) {
		rd.delete(id);

	}

	public Resource queryResourceById(int id) {
		return rd.findById(id);
	}

	public Resource queryResourceByName(String name) {
		return rd.findByResourcename(name);

	}

	public void updateResource(Resource resource) {
		rd.update(resource);
	}

	@Override
	public List<Resource> queryAllResource(String hql, int page, int pagecount) {
		return rd.findAll(hql, page, pagecount);
	}

	@Override
	public int getTotalCount(String hql) {
		return rd.getTotalCount(hql);
	}


	@Override
	public List<Resourcetype> queryAllResourcetype() {
		return rtd.findAll();
	}

	@Override
	public Resourcetype queryResourcetypeById(int id) {
		return rtd.findById(id);
	}
	
}
