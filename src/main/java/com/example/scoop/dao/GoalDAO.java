package com.example.scoop.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.scoop.domain.Goal;

@Mapper
public interface GoalDAO {

	public int insertgoal(Goal goal);
}
