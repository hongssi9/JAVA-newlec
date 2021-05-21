package com.newlecture.web.service;

import java.sql.SQLException;
import java.util.List;

import com.newlecture.web.entity.Notice;

public interface NoticeService {

	List<Notice> getList() throws ClassNotFoundException, SQLException;
	List<Notice> getList(int page);
	List<Notice> getList(String field, String query, int page);
	
	int getCounut();
	int getCouunt(String field, String qery);
	
	int update(Notice notice) throws ClassNotFoundException, SQLException;
	int hitUp();
}
