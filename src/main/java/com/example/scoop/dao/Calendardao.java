package com.example.scoop.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CalendarDAO {
    public void insert(String title, String text, String star, String end, String startday, String endday,
            String allday, int wsid);
}
