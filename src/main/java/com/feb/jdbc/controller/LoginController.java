package com.feb.jdbc.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.feb.jdbc.service.LoginService;

@Controller
public class LoginController {
//	value 넘겨주기 위해서 호출해야함.
	@Autowired
	private LoginService loginService;

    @GetMapping("/loginPage.do")
    public String loginForm() {
        return "login"; // 뷰 이름을 반환합니다.
    }
    
//    Controller는 파라미터만 받음 
    @PostMapping("login.do")
    public ModelAndView login(@RequestParam HashMap<String, String> params) {
    	ModelAndView mv = new ModelAndView();
    	System.out.println("111111111111111");
    	System.out.println("params fdjskfklsdfjnlj 111111111111111 " + params);
    	boolean result = loginService.login(params);
    	if (result) {
    		mv.addObject("resultMsg", "로그인 성공");
    		mv.addObject("resultCode", "loginOk");
    	}else {
    		mv.addObject("resultMsg", "로그인 실패");
    		mv.addObject("resultCode", "loginFail");
    	}
    	mv.setViewName("login");
    	return mv;
    }

}
