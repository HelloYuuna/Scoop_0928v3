package com.example.scoop.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.hibernate.annotations.Parameter;

import com.example.scoop.domain.Calendar;

public interface CalendarService {

    public int insert(Calendar calendar);

}
