package com.edubridge.mini_project.service;

import java.util.List;

import com.edubridge.mini_project.model.moniter;

public interface moniterService {
	int addmoniter (moniter m);
	List<moniter> findmoniters();
	moniter findmoniterByName(String Brand);
	int updatemoniter(moniter m);
	int deletemoniterByName(String Brand);
	void deleteallmoniter();

}