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

import com.example.scoop.config.auth.dto.SessionUser;
import com.example.scoop.domain.Project;
import com.example.scoop.domain.User;
import com.example.scoop.domain.Workspace;
import com.example.scoop.service.ProjectService;
import com.example.scoop.service.UserService;
import com.example.scoop.service.WorkspaceService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 일반 폼 회원가입 관리용 도메인
 */
@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {

	private final HttpSession httpSession;

	@Autowired
	private ProjectService service;

	@Autowired
	private WorkspaceService workspaceService;

	@Autowired
	private UserService userService;

	@GetMapping({ "", "/" })
	public String scoophome(Model model, @AuthenticationPrincipal UserDetails loginInfo) {

		LocalDate now = LocalDate.now();

		int monthValue = now.getMonthValue();
		int dayOfMonth = now.getDayOfMonth();
		String dayOfWeek = now.getDayOfWeek().toString();

		model.addAttribute("month", monthValue);
		model.addAttribute("dayOfMonth", dayOfMonth);
		model.addAttribute("dayOfWeek", dayOfWeek);

		/*
		 * 구글 로그인 정보 받아오기
		 */
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		log.debug("User: {}", user);

		if (user != null) {
			model.addAttribute("userName", user.getName());

		} else {
			/*
			 * 폼 로그인 정보 받아오기
			 */
			String loginId = loginInfo.getUsername();
			User formLoginUser = userService.findById(loginId);
			String userName = formLoginUser.getUsername();

			log.info("폼로그인정보: {}", userName);

			model.addAttribute("userName", userName);
		}

		// 로그인 했을 때 워크스페이스가 없을 경우 생성 페이지로 이동
		int countOwner = workspaceService.countOwner(user.getEmail());
		log.debug("Count Owner Workspace: {}", countOwner);

		if (countOwner == 0) {
			return "/workspaceView/newWorkspace";
		}

		// wsowner의 워크스페이스 전체 가져오기
		ArrayList<Workspace> ownerWorkspaceList = workspaceService.selectOwner(user.getEmail());
		log.debug("Owner Workspace List: {}", ownerWorkspaceList);
		model.addAttribute("ownerWorkspaceList", ownerWorkspaceList);

		// 최근에 접속한 워크스페이스로 이동
		Workspace workspace = workspaceService.selectLately(user.getEmail());
		log.debug("Home_Workspace:{}", workspace);
		model.addAttribute("workspace", workspace);

		// 접속한 워크스페이스의 lately 업데이트
		workspaceService.updateLately(workspace);

		// session에 저장
		httpSession.setAttribute("wsid", workspace.getWsid());
		httpSession.setAttribute("wsname", workspace.getWsname());
		httpSession.setAttribute("wsowner", workspace.getWsowner());

		// int wsid = (int) httpSession.getAttribute("wsid");
		// log.debug("Home_wsid:{}", wsid);

		// log.debug("Home_wsid:{}", wsid);

		// model.addAttribute("workspace", workspace);
		ArrayList<Project> plist = service.selectProject();
		log.debug("넘어온 프로젝트 리스트:{}", plist);
		model.addAttribute("projectlist", plist);

		ArrayList<User> ulist = service.selectMember();
		// 유저인게?
		log.debug("넘어온 프로젝트 리스트:{}", ulist);
		model.addAttribute("ulist", ulist);
		return "scoophome";

	}

}