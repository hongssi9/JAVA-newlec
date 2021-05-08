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
	
	public List<Notice> getNoticeList(String field, String query, int page){ //게시글 목록 정렬해서
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
	
	public Notice getNotice(int id) { //id받아오기 
		String sql = "SELECT * FROM NOTICE WHERE ID=" + id;
		return null;
	}
	
	public Notice getNextNotice(int id) {
		String sql = "SELECT * FROM NOTICE" +
				"WHERE ID = ( " +
				"	SELECT ID FROM NOTICE " +
				"	WHERE REGDATE > (SELECT REGDATE FROM NOTICE WHERE ID=3)" +
				"	AND ROWNUM = 1 " +
				")";
		return null;
	}
	
	public Notice getPrevNotice(int id) {
		return null;
	}
	

}
