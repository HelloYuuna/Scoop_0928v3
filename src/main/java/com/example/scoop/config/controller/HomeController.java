package com.example.scoop.config.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.scoop.config.auth.dto.SessionUser;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {

	private final HttpSession httpSession;

	@GetMapping({ "", "/" })
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

		if (user != null) {
			model.addAttribute("userName", user.getName());
		}
		return "scoophome";
	}

}