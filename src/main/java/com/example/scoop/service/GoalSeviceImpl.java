package com.example.scoop.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scoop.domain.Goal;
import com.example.scoop.service.dao.GoalDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class GoalSeviceImpl implements GoalService {

    @Autowired
    GoalDAO boardDAO;

    public int insertgoal(Goal goal) {
        int result = boardDAO.insertgoal(goal);
        return result;
    };

}
