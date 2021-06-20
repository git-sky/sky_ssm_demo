package cn.com.sky.src.service.interfaces;

import java.util.List;

import entity.Resourcetype;

public interface ResourcetypeService {
	
	public void addResourcetype(Resourcetype resourcetype);

	public void deleteResourcetype(int id);

	public void updateResourcetype(Resourcetype resourcetype);

	public List<Resourcetype> queryAllResourcetype();

	public Resourcetype queryResourcetypeByName(String name);

	public Resourcetype queryResourcetypeById(int id);
}
