package com.example.scoop.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.scoop.config.auth.dto.SessionUser;
import com.example.scoop.domain.Goal;
import com.example.scoop.domain.Workspace;
import com.example.scoop.service.GoalService;
import com.example.scoop.service.WorkspaceService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("goalView")
@RequiredArgsConstructor
@Controller
public class GoalController {

	private static final String Workspace = null;
	private final HttpSession httpSession;
	@Autowired
	private GoalService service;

	@GetMapping("goal")
	public String goal(Model model) {
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		log.debug("email:{}", user.getEmail());
		log.debug("wsid:{}", httpSession.getAttribute("wsid"));
		String email = user.getEmail();
		// 전체값 가져오기
		// ArrayList<Goal> goallist = service.selectOne1Goal();
		int wsid = (int) httpSession.getAttribute("wsid");
		log.debug("wsid1:{}", wsid);
		ArrayList<Goal> goallist1 = service.selectOne1(wsid);
		log.debug("goallist1:{}", goallist1);
		model.addAttribute("goallist1", goallist1);
		log.debug("wsidlog2:{}", wsid);
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

	@PostMapping("insertgoal")
	public String insertgoal(Goal goal, String gstartdate, String genddate) {
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		goal.setGcreator(user.getEmail());
		service.insertgoal(goal);
		log.debug("goal11:{}", goal);
		return "redirect:/goalView/goal";
	}

	@GetMapping("goalvyu")
	public String goalvyu() {
		return "redirect:/goalView/goalvyu";
	}

	// @PostMapping("insert")
	// public String insert(Goal goal) {
	// SessionUser user = (SessionUser) httpsession.getAttribute("user");
	// log.debug("목표 내용 :", goal);
	// goal.setGcreator(user.getEmail());
	// log.debug("유저 내용 :", user.getEmail());
	// service.insertgoal(goal);
	// return "/goalView/goal";
	// }

}
