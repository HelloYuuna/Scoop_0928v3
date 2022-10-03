package com.example.scoop.controller;

import com.example.scoop.config.auth.dto.SessionUser;
import com.example.scoop.domain.Project;
import com.example.scoop.domain.Task;
import com.example.scoop.domain.User;
import com.example.scoop.service.ProjectService;
import com.example.scoop.service.TaskService;
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
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private TaskService taskService;

    /**
     * 내작업 첫화면
     * 1. 유저정보를 가져옴
     * 2. 등록된 태스크들을 가져옴
     * 3. 등록된 프로젝트들을 가져옴
     * 4. 워크스페이스에 참여한 멤버를 불러옴
     * @param model 타임리프용
     * @param formUser 폼로그인유저
     * @return 내작업 홈
     */
    @GetMapping("/myTask")
    public String taskHome(Model model, @RequestParam("wsid") int wsid
                           , @AuthenticationPrincipal UserDetails formUser) {
        
        // 로그인한 유저 정보 가져오기
        log.debug("restController로 넘어옴");

        log.debug("넘어온 wsid값: {}", wsid);
        model.addAttribute("wsid", wsid);

        // TODO: 클래스화 할 것 (리팩토링 )
        // 구글 로그인과 폼 로그인은 유저를 받아오는 방식이 다름
        String userName;
        String loginId;
        SessionUser user = (SessionUser) httpSession.getAttribute("user");   // 구글 로그인 유저 찾기
        log.debug("User: {}", user);

        if(user != null) {
            userName = user.getName();
            loginId = user.getEmail();

        } else {                                                                    // 폼 로그인 유저 찾기
            loginId = formUser.getUsername();
            User findUserName = userService.findById(loginId);
            userName = findUserName.getName();

            log.info("폼로그인정보: {}", userName);
        }

        model.addAttribute("userName", userName);                     // 태스크 생성자 및 담당자

        // 워크스페이스에 등록된 모든 태스크 가져오기 (워크스페이스번호 + 아이디)
        Task task = new Task();
        task.setWsid(wsid);
        task.setTcharge(loginId);
        List<Task> tasks = taskService.selectAll(task);
        log.debug("등록된 작업들: {}", tasks);
        
        List<Task> today = new ArrayList<>();                               // 오늘 할 일
        List<Task> nxtwk = new ArrayList<>();                               // 다음주에 할 일
        List<Task> later = new ArrayList<>();                               // 나중에 할 일

        for (Task taskList : tasks) {
            switch (taskList.getTsession()) {
                case "0":
//                    log.debug("투데이" + tasks.get(i) + " 리스트방: " + i);
                    int tcnt = 0;
                    today.add(tcnt++, taskList);
                    break;

                case "1":
//                    log.debug("다음주" + tasks.get(i) + " 리스트방: " + i);
                    int ncnt = 0;
                    nxtwk.add(ncnt++, taskList);
                    break;

                case "2":
//                    log.debug("나중에" + tasks.get(i) + " 리스트방: " + i);
                    int lcnt = 0;
                    later.add(lcnt++, taskList);
                    break;
            }
        }

        log.debug("today사이즈: " + today.size());
        log.debug("today사이즈: " + nxtwk.size());
        log.debug("today사이즈: " + later.size());

        model.addAttribute("today", today);
        model.addAttribute("nxtwk", nxtwk);
        model.addAttribute("later", later);

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


}
