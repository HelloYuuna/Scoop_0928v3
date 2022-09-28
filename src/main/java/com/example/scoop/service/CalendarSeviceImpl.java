package com.example.scoop.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scoop.dao.CalendarDAO;
import com.example.scoop.domain.Calendar;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CalendarSeviceImpl implements CalendarService {

    @Autowired
    CalendarDAO calendardao;

    @Override
    public int insert(Calendar calendar) {
        int result = calendardao.insert(calendar);
        log.debug("result2  :", result);
        return result;
    }
}
