package com.example.scoop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class Goalcontroll {
	
	@GetMapping({"goal"})
	public String goal() {
		return "goal";
	}

	
}