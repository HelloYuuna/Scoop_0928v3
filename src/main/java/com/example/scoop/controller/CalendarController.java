
package com.example.scoop.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.scoop.domain.Calendar;
import com.example.scoop.domain.Workspace;
import com.example.scoop.service.CalendarService;
import com.example.scoop.service.WorkspaceService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("calendarView")
@RequiredArgsConstructor
@Controller
public class CalendarController {

	private final HttpSession httpSession;

	@Autowired
	private CalendarService calendarservice;

	@Autowired
	private WorkspaceService workspaceService;

	@GetMapping("calendar1")
	public String calendar1() {
		return "/calendarView/calendar1";
	}

	// @ResponseBody
	// @PostMapping("callin1")
	// public void callin1(String titl, String text, String star, String end, String
	// startday, String endday,
	// String allday,
	// int wsid) {
	// log.debug("wsid:{}", wsid);
	// calendarservice.insert(titl, text, star, end, startday, endday, allday,
	// wsid);
	// }

	@PostMapping("callin")
	public @ResponseBody void callin(String title, String text, String star, String end, String startday, String endday,
			String allday, int wsid) {
		calendarservice.insert(title, text, star, end,
				startday, endday, allday, wsid);
	}

}
