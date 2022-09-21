package com.example.scoop.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("calendarView1")
@Controller
public class Calendar1Controller {

        @GetMapping("calendar11")
        public String calendar11() {
                return "/goalView/calendar11";
        }
}