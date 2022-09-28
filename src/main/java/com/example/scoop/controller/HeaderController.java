package com.example.scoop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.scoop.service.WorkspaceService;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HeaderController {

	private final HttpSession httpSession;

	@Autowired
	WorkspaceService workspaceService;

	@GetMapping("myWorkspaceInfo")
	public String myWorkspaceInfo() {
		return "/headerView/myWorkspaceInfo";
	}

	@GetMapping("mySet")
	public String mySet() {
		return "/headerView/mySet";
	}

}
