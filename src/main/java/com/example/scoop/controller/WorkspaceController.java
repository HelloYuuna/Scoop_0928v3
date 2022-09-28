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
	
	/**
	 * 워크스페이스 홈으로 이동
	 * @param model
	 * @return
	 */
	@GetMapping("workspaceHome")
	public String workspaceHome(Model model) {

		int wsid = (int)httpSession.getAttribute("wsid");
		log.debug("WH__wsid:{}", wsid);
		
		Workspace workspace = service.selectOne(wsid);
		log.debug("WH_Workspace:{}",workspace);
		model.addAttribute("workspace", workspace);
		
		httpSession.setAttribute("wsname", workspace.getWsname());
		httpSession.setAttribute("wsowner", workspace.getWsowner());
		
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		
		ArrayList<Workspace> ownerWorkspaceList = service.selectOwner(user.getEmail());
		model.addAttribute("ownerWorkspaceList", ownerWorkspaceList);
		
		return "/workspaceView/workspaceHome";
	}
	
	/**
	 * 워크스페이스 변경
	 * @param model
	 * @param wsid
	 * @return
	 */
	@PostMapping("switchWorkspace")
	public String switchWorkspace(Model model, int wsid) {
		log.debug("Switch__wsid:{}", wsid);
		
		Workspace workspace = service.selectOne(wsid);
		log.debug("Switch__Workspace:{}",workspace);
		model.addAttribute("workspace", workspace);
		
		httpSession.setAttribute("wsid", workspace.getWsid());
		httpSession.setAttribute("wsname", workspace.getWsname());
		httpSession.setAttribute("wsowner", workspace.getWsowner());
		
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
	public String newWorkspace(Model model, Workspace workspace) {
		
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		log.debug("User: {}", user);
		
		if(user != null) {
			model.addAttribute("userName", user.getName());
			workspace.setWsowner(user.getEmail());
		}
		log.debug("Insert Workspace:{}", workspace);


		ArrayList<Workspace> ownerWorkspaceList = service.selectOwner(user.getEmail());
		log.debug("Owner Workspace List: {}", ownerWorkspaceList);
		model.addAttribute("ownerWorkspaceList", ownerWorkspaceList);
		
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
		
		return "scoophome";
	}
	
	@GetMapping("inviteWorkspace")
	public String inviteWorkspace(Model model, Workspace workspace) {
		
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		log.debug("User: {}", user);
		
		if(user != null) {
			
			model.addAttribute("userName", user.getName());
			workspace.setWsowner(user.getEmail());
		}
		log.debug("Invite Workspace:{}", workspace);

		
		// 저장한 후, 저장된 값 리턴받기
		service.selectKey(workspace);
		
		httpSession.setAttribute("wsid", workspace.getWsid());
		httpSession.setAttribute("wsname", workspace.getWsname());
		httpSession.setAttribute("wsowner", workspace.getWsowner());
		
//		Workspace workspaceOne = service.selectOne(wsid);
//		
//		workspaceOne.setWsid(wsid);
		
		log.debug("Workspace:{}", workspace); // ajax
		
		// 로그인한 사용자의 모든 워크스페이스 불러오기
		ArrayList<Workspace> ownerWorkspaceList = service.selectOwner(user.getEmail());
		log.debug("Owner Workspace List: {}", ownerWorkspaceList);
		model.addAttribute("ownerWorkspaceList", ownerWorkspaceList);
		
		// 날짜
		LocalDate now = LocalDate.now();
		
		int monthValue = now.getMonthValue();
		int dayOfMonth = now.getDayOfMonth();
		String dayOfWeek = now.getDayOfWeek().toString();
		
		model.addAttribute("month", monthValue);
		model.addAttribute("dayOfMonth", dayOfMonth);
		model.addAttribute("dayOfWeek", dayOfWeek);
		
		return "scoophome";
	}
	
//	@GetMapping("inviteWorkspace")
//	public String inviteWorkspace(Model model, int wsid) { // , HttpSession session
//		log.debug("Invite wsid:{}", wsid);
//		
//		// 전달받은 parameter wsid의 값을 세션에 저장
//		httpSession.setAttribute("wsid", wsid);
//		
//		// 1. 계정이 있으면 로그인과 동시에 워크스페이스에 참여
//		// 2. 계정이 없으면 회원가입을 거쳐서 로그인을 하고 워크스페이스에 참여 
//		
//		// 로그인
//
//		// 처리할 거 있으면 하기
////		service.inviteWorkspace(wsid, user.getEmail());
//		
//		// 그 워크스페이스 주소로 이동
//		return "scoophome";
//	}
	
//	@GetMapping("removeWorkspace")
//	public String removeWorkspace(Model model, Workspace workspace) {
//		
//		return "home";
//	}

}
