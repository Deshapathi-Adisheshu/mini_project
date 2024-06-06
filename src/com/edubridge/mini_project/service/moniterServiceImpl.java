package com.edubridge.mini_project.service;

import java.util.List;
import com.edubridge.mini_project.dao.moniterDao;
import com.edubridge.moniter.dao.moniterDaoImpl;
import com.edubridge.mini_project.model.moniter;



public class moniterServiceImpl implements moniterService {
	private moniterDaoImpl dao = new moniterDaoImpl();

	@Override
	public int addmoniter(moniter m) {
		// TODO Auto-generated method stub
		return dao.addmoniter(m);
	}

	@Override
	public List<moniter> findmoniters() {
		// TODO Auto-generated method stub
		return dao.findmoniters();
	}

	@Override
	public  moniter findmoniterByName(String Brand) {
		// TODO Auto-generated method stub
		return dao.findmoniterByName(Brand);
	}

	@Override
	public int updatemoniter(moniter m) {
		// TODO Auto-generated method stub
		return dao.updatemoniter(m);
	}

	@Override
	public int deletemoniterByName(String Brand) {
		// TODO Auto-generated method stub
		return dao.deletemoniterByName(Brand);
	}

	@Override
	public void deleteallmoniter() {
		// TODO Auto-generated method stub
		dao.deleteallmoniter();

	}

	
}
