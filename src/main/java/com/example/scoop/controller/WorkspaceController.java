package com.example.scoop.controller;

import java.time.LocalDate;
import java.util.ArrayList;

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
public class WorkspaceController {
	
	private final HttpSession httpSession;

	@Autowired
	WorkspaceService service;
	
	@GetMapping("workspaceHome")
	public String workspaceHome(Model model) { // , HttpSession session , Workspace workspace

		int wsid = (int)httpSession.getAttribute("wsid");
		log.debug("WH__wsid:{}", wsid);
		
		Workspace workspace = service.selectOne(wsid);
		log.debug("WH_Workspace:{}",workspace);
		model.addAttribute("workspace", workspace);
		
		httpSession.setAttribute("wsname", workspace.getWsname());
		httpSession.setAttribute("wsowner", workspace.getWsowner());
		
		// session에 담아둔 상태면 얘는 로그아웃하기 전까지 필요없나?
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		
		ArrayList<Workspace> ownerWorkspaceList = service.selectOwner(user.getEmail());
		model.addAttribute("ownerWorkspaceList", ownerWorkspaceList);
		
		return "/workspaceView/workspaceHome";
//		return "redirect:/workspaceHome?wsid=" + workspace.getWsid();
	}
	
	@PostMapping("switchWorkspace")
	public String switchWorkspace(Model model, int wsid) { // , HttpSession session
		
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		
//		int wsid = (int)session.getAttribute("wsid");
		
		// ajax에서 넘겨주는 wsid값을 받아야
		log.debug("Switch__wsid:{}", wsid);
		
		// 58에서 null이면 값 안넘어온 것
		Workspace workspace = service.selectOne(wsid);
		log.debug("Switch__Workspace:{}",workspace);
		httpSession.setAttribute("wsid", wsid);

		model.addAttribute("workspace", workspace);
		
		service.updateLately(workspace);
		
		return "scoophome";
	}
	
	@GetMapping("workspaceMessage")
	public String workspaceMessage() {
		return "/workspaceView/workspaceMessage";
	}

	@GetMapping("workspaceCalender")
	public String workspaceCalender() {
		return "/workspaceView/workspaceCalender";
	}
	
	@GetMapping("newWorkspace")
	public String newWorkspace(Model model, Workspace workspace) { // , HttpSession session
		
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		log.debug("User: {}", user);
		
		if(user != null) {
			model.addAttribute("userName", user.getName());
			workspace.setWsowner(user.getEmail());
		}
		log.debug("Insert Workspace:{}", workspace);

		// 저장한 후, 저장된 값 리턴받기
		service.selectKey(workspace);
		
		httpSession.setAttribute("wsid", workspace.getWsid());
		httpSession.setAttribute("wsname", workspace.getWsname());
		httpSession.setAttribute("wsowner", workspace.getWsowner());
		
//		Workspace workspaceOne = service.selectOne(wsid);
//		
//		workspaceOne.setWsid(wsid);
		
		log.debug("Workspace:{}", workspace); // ajax

		// 날짜
		LocalDate now = LocalDate.now();
		
		int monthValue = now.getMonthValue();
		int dayOfMonth = now.getDayOfMonth();
		String dayOfWeek = now.getDayOfWeek().toString();
		
		model.addAttribute("month", monthValue);
		model.addAttribute("dayOfMonth", dayOfMonth);
		model.addAttribute("dayOfWeek", dayOfWeek);
		//
		
		return "home";
	}
	
//	@GetMapping("removeWorkspace")
//	public String removeWorkspace(Model model, Workspace workspace) { // , HttpSession session
//		
//		return "home";
//	}
	

}
