package com.example.scoop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class Scoophome {
	
	@GetMapping({"","/"})
	public String scoophome() {
		return "scoophome";
	}

	
}