package com.edubridge.mini_project.dao;

import java.util.List;

import com.edubridge.mini_project.model.moniter;



public interface moniterDao {
	int addmoniter (moniter m);
	List<moniter> findmoniters();
	moniter findmoniterByName(String brand);
	int updatemoniter(moniter m);
	int deletemoniterByName(String brand);
	void deleteallmoniter();
}
