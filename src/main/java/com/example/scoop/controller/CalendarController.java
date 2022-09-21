package com.example.scoop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("calendarView")
@Controller
public class CalendarController {

	@GetMapping("calendar1")
	public String calendar1() {
		return "/calendarView/calendar1";
	}

	// @GetMapping("calendar-insert")
	// public String calendar_insert() {
	// return "/calendarView/calendar-insert";
	// }

}
