package com.example.scoop.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.example.scoop.config.dto.SessionUser;
import com.example.scoop.domain.Project;
import com.example.scoop.service.ProjectService;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {
	
	@Autowired
	private ProjectService service;
	
	private final HttpSession httpSession;
	
	@GetMapping({"","/"})
	public String scoophome(Model model) {
		
		LocalDate now = LocalDate.now();
		
		int monthValue = now.getMonthValue();
		int dayOfMonth = now.getDayOfMonth();
		String dayOfWeek = now.getDayOfWeek().toString();
		
		model.addAttribute("month", monthValue);
		model.addAttribute("dayOfMonth", dayOfMonth);
		model.addAttribute("dayOfWeek", dayOfWeek);
		
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		log.debug("User: {}", user);
		
		if(user != null) {
			model.addAttribute("userName", user.getName());
		}
		
		ArrayList<Project> plist = service.selectProject();
		log.debug("넘어온 프로젝트 리스트:{}", plist);
		model.addAttribute("projectlist", plist);
		return "scoophome";
	}
	
}