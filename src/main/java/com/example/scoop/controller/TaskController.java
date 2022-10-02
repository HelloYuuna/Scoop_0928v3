package com.example.scoop.controller;

import com.example.scoop.config.auth.dto.SessionUser;
import com.example.scoop.domain.Project;
import com.example.scoop.domain.User;
import com.example.scoop.service.ProjectService;
import com.example.scoop.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * projectName     :Scoop
 * fileName        :TaskController
 * author          :yuuna
 * since           :2022/09/19
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/task")
@Slf4j
public class TaskController {

    private final HttpSession httpSession;

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    /**
     * 내작업 첫화면
     * @param model 타임리프용
     * @param formUser 폼로그인유저
     * @return 내작업 홈
     */
    @GetMapping("/myTask")
    public String taskHome(Model model
                           , @AuthenticationPrincipal UserDetails formUser) {
        
        // 로그인한 유저 정보 가져오기
        log.debug("restController로 넘어옴");

        String userName;

        // TODO: 클래스화 할 것 (리팩토링)
        // 구글 로그인과 폼 로그인은 유저를 받아오는 방식이 다름
        SessionUser user = (SessionUser) httpSession.getAttribute("user");   // 구글 로그인 유저 찾기
        log.debug("User: {}", user);

        if(user != null) {
            userName = user.getName();

        } else {                                                                    // 폼 로그인 유저 찾기
            String loginId = formUser.getUsername();
            User findUserName = userService.findById(loginId);
            userName = findUserName.getName();

            log.info("폼로그인정보: {}", userName);
        }

        model.addAttribute("userName", userName);                     // 태스크 생성자 및 담당자
        
        // TODO: 등록된 태스크 리스트업


        int wsid = 1;                                       // 테스트용 0번
        model.addAttribute("wsid", wsid);

        // 해당 워크스페이스의 멤버 가져오기
        List<User> users = userService.findByWsid(wsid);
        log.debug("가져온 멤버 리스트: {}", users);
        model.addAttribute("members", users);

        // 해당 워크스페이스의 프로젝트 가져오기
        List<Project> projects = projectService.findByWsid(wsid);
        log.debug("가져온 프로젝트 리스트: {}", projects);
        model.addAttribute("projects", projects);

        return "/myTaskView/myTask";
    }

    @GetMapping("/test")
    public String test() {
        return "/myTaskView/test";
    }

}
