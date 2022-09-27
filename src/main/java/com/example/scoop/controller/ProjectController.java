package com.example.scoop.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.scoop.config.auth.dto.SessionUser;
import com.example.scoop.domain.Project;
import com.example.scoop.domain.User;
import com.example.scoop.service.ProjectService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("projectView")
@Slf4j
public class ProjectController {
	
	private final HttpSession httpSession;
	
	@Autowired
	ProjectService service;

	@GetMapping("project")
	public String project(Model model,
			@RequestParam(name="pnum",defaultValue="0") int pnum) {
		//별도로 프로젝트를 생성해야한다...
		log.debug("전달될 프로젝트 번호{}:",pnum);
		//공지사항
		Project pproject = service.projectread(pnum);
		if(pproject == null) {
			return "redirect:/";
		}
		model.addAttribute("input", pproject);
		
		//멤버 리스트를 가져오는 애
		ArrayList<User> list = service.selectMember();
		model.addAttribute("memberlist", list);
		
		//선택된 멤버를 가져오는 애
		String member = service.choiceMember(pnum);
		if(member == null) {
			return "redirect:/";
		}
		log.debug("전달될 멤버:{}",member);
		model.addAttribute("choiceMember",member);
		return "projectView/project";
	}

	@GetMapping("/getmember")
	public String getlist(Model model) {
		ArrayList<User> list = service.selectMember();
		log.debug("넘어온 리스트:{}", list);
		model.addAttribute("memberlist", list);
		
//		Project pproject = service.projectread(pnum);
//		log.debug("전달된 프로젝트:{}", pproject);
//		model.addAttribute("input2", pproject);
		
		return "projectView/getlist";
	}
	
	@GetMapping("createproject")
	public String createproject() {
		return "/projectView/createproject";	
	}

	@PostMapping("createproject")
	public String createproject(
	//@AuthenticationPrincipal UserDetails user
			 Project pproject) {
//		String id = user.getUsername();
//		pproject.setUemail(id);
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		log.debug("가져온 유저 user:{}", user);
		pproject.setUemail(user.getEmail());
		pproject.setPmember(user.getName());
		pproject.setPowner(user.getEmail());
		log.debug("전달 될 값:{}", pproject);
		int result = service.projectInsert(pproject);
		log.debug("전달 결과:{}", result);
		return "redirect:/";
	}


}
