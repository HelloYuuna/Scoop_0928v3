package com.example.scoop.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.scoop.domain.Calendar;

@Mapper
public interface CalendarDAO {
    public int insert(Calendar calendar);
}
