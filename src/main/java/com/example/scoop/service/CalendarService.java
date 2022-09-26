package com.example.scoop.service;

import java.util.Map;

import com.example.scoop.domain.Calendar;

public interface CalendarService {

    // public void insert(String title, String text, String star, String end, String
    // startday, String endday,
    // String allday, int wsid);

    public void insert(String title, String text, String star, String end, String startday, String endday,
            String allday, int wsid);

}
