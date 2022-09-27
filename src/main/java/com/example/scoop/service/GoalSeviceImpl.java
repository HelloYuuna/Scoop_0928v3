package com.example.scoop.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scoop.dao.GoalDAO;
import com.example.scoop.domain.Goal;

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

    public ArrayList<Goal> selectOne1(int wsid) {
        ArrayList<Goal> result = boardDAO.selectOne1(wsid);
        ArrayList<Goal> returnGList = new ArrayList<Goal>();

        for (Goal goal : result) {
            log.debug("처음값 : {}", goal);
            if (goal.getGstartdate() != "" && goal.getGenddate() != "" &&
                    goal.getGstartdate() != null && goal.getGenddate() != null) {
                String goal1 = goal.getGstartdate() + "~" + goal.getGenddate();
                goal.setCalendar(goal1);
                returnGList.add(goal);
                log.debug("Calendar1 : {}", goal);
                result = returnGList;
            } else if (goal.getGstartdate() == "" || goal.getGenddate() == "" &&
                    goal.getGstartdate() == null || goal.getGenddate() == null) {
                String goal1 = "";
                goal.setCalendar(goal1);
                returnGList.add(goal);
                log.debug("Calendar2 : {}", goal);
                result = returnGList;
            }

        }
        return result;
    };

    public ArrayList<Goal> selectOne1Goal() {
        ArrayList<Goal> result = boardDAO.selectOne1Goal();
        ArrayList<Goal> returnGList = new ArrayList<Goal>();

        for (Goal goal : result) {
            log.debug("처음값 : {}", goal);
            if (goal.getGstartdate() != "" && goal.getGenddate() != "" &&
                    goal.getGstartdate() != null && goal.getGenddate() != null) {
                String goal1 = goal.getGstartdate() + "~" + goal.getGenddate();
                goal.setCalendar(goal1);
                returnGList.add(goal);
                log.debug("Calendar3 : {}", goal);
                result = returnGList;
            } else if (goal.getGstartdate() == "" || goal.getGenddate() == "" &&
                    goal.getGstartdate() == null || goal.getGenddate() == null) {
                String goal1 = "";
                goal.setCalendar(goal1);
                returnGList.add(goal);
                log.debug("Calendar4 : {}", goal);
                result = returnGList;
            }

        }
        return result;
    };

}
