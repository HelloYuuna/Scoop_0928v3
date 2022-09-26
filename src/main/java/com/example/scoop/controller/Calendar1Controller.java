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

        // private static final Logger log =
        // LoggerFactory.getLogger(Calendar1Controller.class);

        // private final CalendarService calendarservice;

        // public Calendar1Controller(CalendarService calendarservice) {
        // this.calendarservice = calendarservice;
        // }

        // @RequestMapping(value = "/insert", method = RequestMethod.GET)
        // @ResponseBody
        // public List<Map<String, Object>> insert() {
        // List<Map<String, Object>> list = CalendarService.getCalendarList();

        // JSONObject jsonObj = new JSONObject();
        // JSONArray jsonArr = new JSONArray();
        // HashMap<String, Object> hash = new HashMap<String, Object>();

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

        // return jsonArr;
        // }

}