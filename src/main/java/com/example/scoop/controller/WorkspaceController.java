package com.example.scoop.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
public class WorkspaceController {
	
	private final HttpSession httpSession;

	@Autowired
	WorkspaceService service;
	
	@GetMapping("workspaceHome")
	public String workspaceHome(Model model) { // , Workspace workspace

		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		
		Workspace latelyWorkspace = service.selectLately(user.getEmail());
		log.debug("Lately Workspace:{}", latelyWorkspace);
		
		service.updateLately(latelyWorkspace);
		
		model.addAttribute("latelyWorkspace", latelyWorkspace);
		
		ArrayList<Workspace> ownerWorkspaceList = service.selectOwner(user.getEmail());
		model.addAttribute("ownerWorkspaceList", ownerWorkspaceList);
		
		return "/workspaceView/workspaceHome";
	}
	
	@GetMapping("moveToWorkspaceHome")
	public String moveToWorkspaceHome(Model model, Workspace workspace, int wsid) {
		log.debug("wsid:{}", wsid);
		
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		
		workspace = service.selectOne(wsid);
		log.debug("Workspace:{}",workspace);
		
		service.updateLately(workspace);
		
		model.addAttribute("workspace", workspace);

		return "/workspaceView/workspaceHome";
	}
	
	@GetMapping("workspaceMessage")
	public String workspaceMessage() {
		return "/workspaceView/workspaceMessage";
	}

	@GetMapping("workspaceCalender")
	public String workspaceCalender() {
		return "/workspaceView/workspaceCalender";
	}
	
	@PostMapping("newWorkspace")
	public String newWorkspace(Model model, Workspace workspace) {

		LocalDate now = LocalDate.now();
		
		int monthValue = now.getMonthValue();
		int dayOfMonth = now.getDayOfMonth();
		String dayOfWeek= now.getDayOfWeek().toString();
		
		model.addAttribute("month", monthValue);
		model.addAttribute("dayOfMonth", dayOfMonth);
		model.addAttribute("dayOfWeek", dayOfWeek);
		
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		log.debug("User: {}", user);
		
		if(user != null) {
			model.addAttribute("userName", user.getName());
			workspace.setWsowner(user.getEmail());
		}

		// insert
		service.insertWorkspace(workspace);
		
//		int wsid = workspace.getWsid();
//		log.debug("wsid:{}", wsid);
//		
//		Workspace workspaceOne = service.selectOne(wsid);
//		
//		
//		workspaceOne.setWsid(wsid);
		
		
		log.debug("Workspace:{}", workspace); // ajax
		
//		return "redirect:/?wsid=" + workspace.getWsid() + "&wsname=" + workspace.getWsname() + "&wsowner=" + workspace.getWsowner(); // "workspace?wsid=" + wsid; // return "redirect:/boardView/read?boardnum=" + reply.getBoardnum();
//		return "redirect:/workspaceHome?wsid=" + workspace.getWsid();
		return "redirect:/wsid=" + workspace.getWsid();
	}
	

}
