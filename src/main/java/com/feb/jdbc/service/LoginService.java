package com.feb.jdbc.service;

import java.util.HashMap;

import org.springframework.util.StringUtils;

import com.feb.jdbc.dao.LoginDao;
import com.feb.jdbc.entity.Member;
import com.feb.jdbc.util.Sha512Encoder;

public class LoginService {
	private LoginDao loginDao;
	
	public LoginService() {}
	public LoginService(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
//	Dao 호출할 때만 멤버아이디 
	public boolean login(HashMap<String, String> params) {
		String memberId = params.get("memberId");
		System.out.println("member printfnksfdnnls " + memberId);
		
//		그냥 멤버 아이디만 가져오는 거임 .
		Member member = loginDao.login(memberId);
		System.out.println("mememmememe " + member);
		String memberPw = member.getPasswd(); // db 에 있는 값 
		
		Sha512Encoder encoder = Sha512Encoder.getInstance();
		String passwd = params.get("pwd"); // 사용자가 입력한 값 
		String encodeTxt = encoder.getSecurePassword(passwd);	// 사용자가 입력한 값을 암호화 한 것. 
		
		// boolean
		return (StringUtils.pathEquals(memberPw, encodeTxt)); // db 받아온 값- memberPw, 입력 암호화 - encodeTxt
		
		
//		비밀번호를 직접적으로 비교하면 안 됨. 아이디로 비교해야 함. 
	}
}
