package com.feb.jdbc.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.feb.jdbc.dao.LoginDao;
import com.feb.jdbc.entity.Member;
import com.feb.jdbc.entity.MemberRowMapper;

public class LoginDaoImpl extends JdbcDaoSupport implements LoginDao{

	@Override
	public Member login(String memberId) {
//		줄바꿈 할 때는 공백을 꼭 넣어줘야 함. 
//		
//		String sql = "select * from lecture.member where member_id = '"+memberId +"'" ;
//		Java 표준 출력에 원래 ? 있음. 무언가를 치환해서 넣어주겠다는 뜻 
//		비밀번호를 직접적으로 비교하면 안 됨. 아이디로 비교해야 함. 
		String sql = "select * from lecture.member where member_id = ?" ;
		
		System.out.println("SQL printfnksfdnnls " + sql);
		@SuppressWarnings("deprecation")
//		여기서 memberId 는 0번째임. 
		Member member = getJdbcTemplate().queryForObject(sql, new Object[] { memberId }, new MemberRowMapper());
		System.out.println("memememeemmememe printfnksfdnnls " + member);
		return member;
	}

	
}
