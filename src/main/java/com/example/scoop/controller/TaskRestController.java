package com.example.scoop.controller;

import com.example.scoop.config.auth.dto.SessionUser;
import com.example.scoop.domain.Project;
import com.example.scoop.domain.Task;
import com.example.scoop.domain.User;
import com.example.scoop.service.TaskService;
import com.example.scoop.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * projectName     :Scoop
 * fileName        :TaskRestController
 * author          :yuuna
 * since           :2022/09/23
 */

@Controller

@RequestMapping("/task")
@RequiredArgsConstructor
@Slf4j
public class TaskRestController {
    private final HttpSession httpSession;

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("insertTask")
    public int insertTask(Task task
                            ,  @AuthenticationPrincipal UserDetails loginInfo) {
        log.debug("받아온 task : {}", task);

        /*
         * 구글 로그인 정보 받아오기
         */
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        log.debug("User: {}", user);

        if(user != null) {
            task.setTcreator(user.getName());

        } else {
            /*
             * 폼 로그인 정보 받아오기
             */
            String loginId = loginInfo.getUsername();
            User formLoginUser = userService.findById(loginId);
            String userName = formLoginUser.getName();

            log.info("폼로그인정보: {}", userName);

            task.setTcreator(userName);
        }

//        int res = taskService.insertTask(task);
//
//        if(res < 1) {
//            log.debug("데이터 입력 실패");
//            return 1;
//        }

        return 0;
    }
}
