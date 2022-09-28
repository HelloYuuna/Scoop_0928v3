package com.example.scoop.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.scoop.domain.Goal;

@Mapper
public interface GoalDAO {

	public int insertgoal(Goal goal);

	// public ArrayList<Goal> selectme(String email, int ws);

	public ArrayList<Goal> selectOne1Goal(int wsid);

	public ArrayList<Goal> selectOne1(Goal goal);

}
