package com.example.scoop.service;

import java.util.ArrayList;

import com.example.scoop.domain.Goal;

public interface GoalService {

	public int insertgoal(Goal goal);

	// public ArrayList<Goal> selectme();

	public ArrayList<Goal> selectOne1Goal(int wsid);

	public ArrayList<Goal> selectOne1(Goal goal);

}
