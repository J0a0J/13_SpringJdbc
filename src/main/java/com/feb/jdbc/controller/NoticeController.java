package com.feb.jdbc.controller;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.feb.jdbc.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ResponseBody
	@RequestMapping("/writeNotice.do")
//	public ModelAndView write(@RequestParam HashMap<String, String> params) {
	public void write(@RequestParam HashMap<String, String> params) {
//		ModelAndView mv = new ModelAndView();
		int result = noticeService.write(params);
		System.out.println("result " + result);
		
		System.out.println("params " + params);
		
		
//		return mv;
	}
	
}