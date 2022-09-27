package com.example.scoop.controller;

import com.example.scoop.domain.User;
import com.example.scoop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * projectName     :Scoop
 * fileName        :TaskController
 * author          :yuuna
 * since           :2022/09/19
 */
// TODO: 디비에 task 넣기
@Controller
@RequestMapping("/task")
@Slf4j
public class TaskController {

    @Autowired
    private UserService userService;

    @GetMapping("/myTask")
    public String taskHome(Model model) {
        // 등록된 태스크 리스트업8

        // 해당 워크스페이스의 멤버 가져오기
        User user = userService.findByWsid(1);
        model.addAttribute("members", user);

        // 해당 워크스페이스의 프로젝트 가져오기


        return "/myTaskView/myTask";
    }
}
