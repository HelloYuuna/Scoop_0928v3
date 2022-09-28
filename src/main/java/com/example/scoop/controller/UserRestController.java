package com.example.scoop.controller;

import com.example.scoop.domain.User;
import com.example.scoop.domain.UserDTO;
import com.example.scoop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/member")
@Slf4j
public class UserRestController {

    @Autowired
    private UserService userService;

//    private final UserService userService;
//
//    public UserRestController(UserService userService) {
//        this.userService = userService;
//    }

    /**
     * 회원가입 폼 처리 에이젝스 컨트롤러
     * 아이디 중복체크
     * @param email 회원가입폼에서 받아온 아이디
     * @return boolean 중복아이디가 존재하는지 반환
     */
    @PostMapping("/idcheck")
    public boolean idChk(String email) {
        log.info("email: {}", email);
        User user = userService.findById(email);
        return user == null;
    }

    /**
     * 회원가입
     * @param user 회원가입폼에서 넘어온 아이디 비밀번호값
     */
    @PostMapping("/signup")
    public int signup(UserDTO user) {
        log.info("user: {}", user);

        return userService.insertMember(user);
    }
}
