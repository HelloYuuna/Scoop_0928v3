package com.example.scoop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.scoop.domain.Project;
import com.example.scoop.domain.User;
import com.example.scoop.service.ProjectService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("projectView")
@ResponseBody
public class ProjectRestController {

	@Autowired
	ProjectService service;
	
//	@PostMapping("insert")
//	public void insert(String input, HttpSession session) {
//		log.debug("ajax에서 넘어 온 값:{}", input);
//		session.setAttribute("reid", input);
//	}
	//공지사항 생성
	@PostMapping("insert")
	public void insert(Project pproject) {
		log.debug("ajax에서 넘어 온 값:{}", pproject);
		int result = service.updateContent(pproject);
		//select를 해야함
		log.debug("입력된 결과:{}", result);
		//ArrayList<Project> list = service.selectContent();
	}

	//참여 멤버 업데이트
	@PostMapping("updatemember")
	public void updatemember(User user, int pnum) {
		log.debug("ajax에서 넘어 온 멤버:{}", user);
		log.debug("넘어온 pnum:{}",pnum);
		int result = service.updatemember(pnum,user);
		log.debug("입력된 멤버:{}", result);
	}
	
//	@PostMapping("set")
//	public void set(String str) {
//		log.debug("ajax에서 넘어간 값:{} ", str);	
//		
//		
//	}
	
	
//	@PostMapping("insert")
//	public void insert(String pnotice) {
//		log.debug("ajax에서 넘어 온 값:{}", pnotice);
//		int result = service.updateContent(pnotice);
//		
//		log.debug("입력된 결과:{}", result);
//		
//	}
	
//	public ArrayList<Project> insert(Project project) {
//		log.debug("ajax에서 넘어 온 값:{}", project);
//		String result = service.updateContent(project);
//		//select를 해야함
//		log.debug("입력된 결과:{}", result);
//		ArrayList<Project> list = service.selectContent();
//		return list;
//	}
	
//	@PostMapping("insert2")
//	public void insert2(String context, HttpSession session) {
//		log.debug("ajax에서 넘어 온 값:{}",context);
//		
//		session.setAttribute("id", context);
//		
//	}
	
	
}
