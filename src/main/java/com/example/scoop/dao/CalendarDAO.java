package com.example.scoop.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.scoop.domain.Calendar;

@Mapper
public interface CalendarDAO {
    public void insert(Map<String, Calendar> param);
}
