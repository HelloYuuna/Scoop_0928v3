package com.example.scoop.controller;

import com.example.scoop.config.auth.dto.SessionUser;
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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * projectName     :Scoop
 * fileName        :TaskRestController
 * author          :yuuna
 * since           :2022/09/23
 */

@Controller
@ResponseBody
@RequestMapping("/task")
@RequiredArgsConstructor
@Slf4j
public class TaskRestController {

    private final HttpSession httpSession;

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @PostMapping("insertCharger")
    public String insertCharger(@AuthenticationPrincipal UserDetails formUser) {
        log.debug("restController로 넘어옴");

        String userName;

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

        return userName;
    }
}
