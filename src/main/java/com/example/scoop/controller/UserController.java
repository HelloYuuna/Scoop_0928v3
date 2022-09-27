package com.example.scoop.controller;

import com.example.scoop.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 로그인 및 회원가입 컨트롤러
 * projectName     :Scoop
 * fileName        :MemberController
 * author          :yuuna
 * since           :2022/09/14
 */

@Slf4j
@Controller
@RequestMapping("/member")
public class UserController {

    /**
     * 로그인 폼으로 이동
     * 로그인 상태가 아니면 여기로 항상 이동
     * @return loginForm
     */
    @GetMapping("loginForm")
    public String gotoLogin() {
        return "/loginView/loginForm";
    }

    /**
     * 회원가입 폼으로 이동
     * @return signupForm
     */
    @GetMapping("/signupForm")
    public String gotoSignup(Model model) {

        model.addAttribute("user", new User());
        return "/loginView/signupForm";
    }

}
