package com.example.scoop.config.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class GoalController {

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

}
