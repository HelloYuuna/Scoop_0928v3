package com.example.scoop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scoop.dao.CalendarDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CalendarSeviceImpl implements CalendarService {

    @Autowired
    CalendarDAO calendardao;

    public void insert(String title, String text, String star, String end, String startday, String endday,
            String allday, int wsid) {
        calendardao.insert(title, text, star, end, startday, endday, allday, wsid);
    };

}
