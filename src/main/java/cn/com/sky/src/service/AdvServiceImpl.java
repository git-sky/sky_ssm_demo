package cn.com.sky.src.service;

import java.util.List;

import dao.interfaces.AdvDAO;

import entity.Adv;
import service.interfaces.AdvService;

public class AdvServiceImpl implements AdvService {

	private AdvDAO avd;

	public AdvDAO getAvd() {
		return avd;
	}

	public void setAvd(AdvDAO avd) {
		this.avd = avd;
	}

	@Override
	public void addAdv(Adv adv) {
		avd.save(adv);

	}

	@Override
	public void deleteAdv(int id) {
		avd.delete(id);

	}

	@Override
	public List<Adv> queryAll() {
		return avd.findAll();
	}

	@Override
	public void updateAdv(Adv adv) {
		avd.update(adv);
	}

	@Override
	public Adv queryAdvById(int id) {
		return avd.queryAdvById(id);
	}

}
