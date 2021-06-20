package cn.com.sky.src.service;

import java.util.List;

import dao.interfaces.ResourcetypeDAO;

import entity.Resourcetype;
import service.interfaces.ResourcetypeService;

public class ResourcetypeServiceImpl implements ResourcetypeService {
	private ResourcetypeDAO rtd;

	public void setRtd(ResourcetypeDAO rtd) {
		this.rtd = rtd;
	}

	public ResourcetypeDAO getRtd() {
		return rtd;
	}

	public void addResourcetype(Resourcetype resourcetype) {
		rtd.save(resourcetype);
	}

	public void deleteResourcetype(int id) {
		rtd.delete(id);
	}

	public List<Resourcetype> queryAllResourcetype() {
		return rtd.findAll();
	}

	public Resourcetype queryResourcetypeById(int id) {
		return rtd.findById(id);
	}

	public Resourcetype queryResourcetypeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateResourcetype(Resourcetype resourcetype) {
rtd.update(resourcetype);
	}

}
