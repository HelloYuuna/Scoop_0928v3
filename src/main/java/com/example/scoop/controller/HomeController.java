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

	@GetMapping({"", "/"})
	public String scoophome(Model model, @AuthenticationPrincipal UserDetails loginInfo) {

		/*
		 * 유저 별 워크스페이스 불러오기
		 */
//		int wsid = (int)httpSession.getAttribute("wsid");
		int wsid = 1;
		log.debug("Home__wsid:{}", wsid);
		
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

		if(user != null) {
			model.addAttribute("userName", user.getName());

		} else {
			/*
			 * 폼 로그인 정보 받아오기
			 */
			String loginId = loginInfo.getUsername();
			User formLoginUser = userService.findById(loginId);
			String userName = formLoginUser.getName();

			log.info("폼로그인정보: {}", userName);

			model.addAttribute("userName",userName);
		}

		// wsowner의 워크스페이스 전체 가져오기
		ArrayList<Workspace> ownerWorkspaceList = workspaceService.selectOwner(user.getEmail());
		log.debug("Owner Workspace List: {}", ownerWorkspaceList);
		model.addAttribute("ownerWorkspaceList", ownerWorkspaceList);
		
		int countOwner = workspaceService.countOwner(user.getEmail());
		log.debug("Count Owner Workspace: {}", countOwner);
		
		if(countOwner == 0) {
			return "/workspaceView/newWorkspace";
		}
		
//		model.addAttribute("userName", "김혜민");

//		ArrayList<Workspace> ownerWorkspaceList = workspaceService.selectOwner("khyemin0005@gmail.com");
//		model.addAttribute("ownerWorkspaceList", ownerWorkspaceList);


		// 로그인하고 들어올 경우 최근에 접속한 워크스페이스 번호에 해당하는 워크 스페이스로
//		Workspace workspace = workspaceService.selectLately(user.getEmail());

		// 접속한 워크스페이스의 lately 업데이트
//		workspaceService.updateLately(workspace);
//		Workspace workspace = workspaceService.selectLately(user.getEmail());
		com.example.scoop.domain.Workspace workspace = workspaceService.selectOne(wsid);
		log.debug("Home_Workspace:{}",workspace);
		model.addAttribute("workspace", workspace);

		// session // set을 HomeController? WorkspaceController?
		httpSession.setAttribute("wsid", workspace.getWsid());
		httpSession.setAttribute("wsname", workspace.getWsname());
		httpSession.setAttribute("wsowner", workspace.getWsowner());

//		int wsid = (int)session.getAttribute("wsid");
//		String wsname = (String)httpSession.getAttribute("wsname");
//		String wsowner = (String)httpSession.getAttribute("wsowner");

		log.debug("Home_wsid:{}", wsid);

		// session에 담으면 selectOne 할 필요가 없나?
//		model.addAttribute("workspace", workspace);
		
		
		ArrayList<Project> plist = service.selectProject();
		log.debug("넘어온 프로젝트 리스트:{}", plist);
		model.addAttribute("projectlist", plist);

		return "scoophome";
	}

}