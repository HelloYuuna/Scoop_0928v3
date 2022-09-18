package com.example.scoop.controller;

import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.qos.logback.classic.Logger;
// import service.CalendarService;

@Controller
@RequestMapping("/calendarcrud")
public class Calendar1Controller {

    // private static final Logger log =
    // LoggerFactory.getLogger(Calendar1Controller.class);

    // private final CalendarService calendarservice;

    // public Calendar1Controller(CalendarService calendarservice) {
    // this.calendarservice = calendarservice;
    // }

//    @RequestMapping(value = "/insert", method = RequestMethod.GET)
//    @ResponseBody
//    public List<Map<String, Object>> insert() {
        // List<Map<String, Object>> list = CalendarService.getCalendarList();

//        JSONObject jsonObj = new JSONObject();
//        JSONArray jsonArr = new JSONArray();
//        HashMap<String, Object> hash = new HashMap<String, Object>();

        // for (int i = 0; i < list.size(); i++) {
        // hash.put("title", list.get(i).get("detailed_categorized_name")); // 제목
        // hash.put("start", list.get(i).get("expected_production_start_date")); // 시작일자
        // hash.put("end", list.get(i).get("expected_production_end_date")); // 종료일자

        // jsonObj = new JSONObject(hash); // 중괄호 {key:value , key:value, key:value}
        // jsonArr.add(jsonObj); // 대괄호 안에 넣어주기[{key:value , key:value,
        // key:value},{key:value , key:value,
        // // key:value}]
        // }

        // log.info("jsonArrCheck: {}", jsonArr);

//        return jsonArr;
//    }
}