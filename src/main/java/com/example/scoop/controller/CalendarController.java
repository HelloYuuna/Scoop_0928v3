
package com.example.scoop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.scoop.domain.Calendar;
import com.example.scoop.service.CalendarService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("calendarView")
@RequiredArgsConstructor
@Controller
public class CalendarController {

	@Autowired
	private CalendarService calendarservice;

	@GetMapping("calendar1")
	public String calendar1() {
		return "/calendarView/calendar1";
	}

	@ResponseBody
	@PostMapping("callin")
	public Calendar callin(String title, String text, String star, String end,
			String allday, Integer wsid) throws Exception {
		Integer wsid1 = Integer.valueOf(wsid);
		wsid = wsid1;
		log.debug("wsid:{}", wsid);
		Calendar calendar = new Calendar();
		calendar.setTitle(title);
		calendar.setText(text);
		calendar.setStar(star);
		calendar.setEnd(end);
		calendar.setAllday(allday);
		calendar.setWsid(wsid);
		log.debug("calendar:{}", calendar);
		calendarservice.insert(calendar);
		return calendar;
	}

}
