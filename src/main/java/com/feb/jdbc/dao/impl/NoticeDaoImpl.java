package com.feb.jdbc.dao.impl;

import java.util.HashMap;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.feb.jdbc.dao.NoticeDao;

public class NoticeDaoImpl extends JdbcDaoSupport implements NoticeDao {

	@Override
	public int write(HashMap<String, String> params) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO lecture.notice "
				+ "(author, content, wrt_dtm) "
				+ "VALUES('" + params.get("author")
				+ "', '" + params.get("content")
				+ "', to_char(now(), 'YYYYMMDDHH24MISS'))";
		return getJdbcTemplate().update(sql);
	}
	

//	@Override
//	public HashMap<String, Object> findAuthor(String author){
//		String sql = "select * from lecture.notice where author = '" + author + "'";
//		
//		HashMap<String, Object> list = (HashMap<String, Object>) 
//				getJdbcTemplate().queryForObject(sql, HashMap.class);
//		return list;
//	}
}