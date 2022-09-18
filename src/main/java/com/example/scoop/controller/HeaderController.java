package com.example.scoop.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.scoop.config.auth.dto.SessionUser;
import com.example.scoop.domain.Workspace;
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
