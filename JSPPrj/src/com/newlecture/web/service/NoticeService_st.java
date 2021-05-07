package com.newlecture.web.service;

import java.util.List;

import com.newlecture.web.entity.Notice;

public class NoticeService_st {
	public List<Notice> getNoticeList(){
			
		return getNoticeList("title","",1);
		}
	
	public List<Notice> getNoticeList(int page){
		
		return getNoticeList("title","",page);
	}
	
	public List<Notice> getNoticeList(String field, String query, int page){
		String sql = "SELECT * FROM (" + "    SELECT ROWNUM NUM, N.* " + "    FROM (" + "        SELECT * "
				+ "        FROM NOTICE" + "        WHERE " + field + " LIKE '%" + query + "%'"
				+ "        ORDER BY REGDATE DESC" + "    ) N " + ")" + "WHERE NUM BETWEEN " + startNum + " AND "
				+ endNum + "";
		
		return null;
	}
	
	public int getNoticeCount() {
		return getNoticeCount("title","");
	}
	
	public int getNoticeCount(String field, String query) {
		return 0;
	}
	
	public Notice getNotice(int id) {
		String sql = "SELECT * FROM NOTICE WHERE ID=" + id;
		return null;
	}
	
	public Notice getNextNotice(int id) {
		return null;
	}
	
	public Notice getPrevNotice(int id) {
		return null;
	}
	

}
