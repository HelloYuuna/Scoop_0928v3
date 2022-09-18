package com.example.scoop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.scoop.config.dto.SessionUser;
import com.example.scoop.domain.Goal;
import com.example.scoop.service.GoalService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("goalView")
@RequiredArgsConstructor
@Controller
public class GoalController {

	private final HttpSession httpsession;

	@Autowired
	private GoalService service;

	@GetMapping("goal")
	public String goal() {
		return "/goalView/goal";
	}

	@GetMapping("teamgoal")
	public String teamgoal() {
		return "/goalView/teamgoal";
	}

	@GetMapping("goalgaip")
	public String goalgaip() {
		return "/goalView/goalgaip";
	}

	@PostMapping("insert")
	public String insert(Goal goal) {
		SessionUser user = (SessionUser) httpsession.getAttribute("user");
		log.debug("목표 내용 :", goal);
		goal.setGcreator(user.getEmail());
		log.debug("유저 내용 :", user.getEmail());
		service.insertgoal(goal);
		return "/goalView/goal";
	}

}
