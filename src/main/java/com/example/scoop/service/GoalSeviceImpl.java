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

    public ArrayList<Goal> selectOne1(Goal goal) {
        ArrayList<Goal> result = boardDAO.selectOne1(goal);

        for (Goal goal1 : result) {
            log.debug("처음값 : {}", goal1);
            if (goal1.getGstartdate() != "" && goal1.getGenddate() != "" &&
                    goal1.getGstartdate() != null && goal1.getGenddate() != null) {
                String goal2 = goal1.getGstartdate() + "~" + goal1.getGenddate();
                goal1.setCalendar(goal2);
                log.debug("Calendar1 : {}", goal1);
            } else if (goal1.getGstartdate() == "" || goal1.getGenddate() == "" &&
                    goal1.getGstartdate() == null || goal1.getGenddate() == null) {
                String goal2 = "";
                goal.setCalendar(goal2);
                log.debug("Calendar2 : {}", goal);
            }
            if (goal1.getGstatus() == 0) {
                goal1.setGstatus1("진행중");
            }
            if (goal1.getGstatus() == 1) {
                goal1.setGstatus1("위험");
            }
            if (goal1.getGstatus() == 2) {
                goal1.setGstatus1("기간지남");
            }
            if (goal1.getGstatus() == 3) {
                goal1.setGstatus1("완료");
            }
            if (goal1.getGstatus() == 4) {
                goal1.setGstatus1("보류");
            }
            if (goal1.getGstatus() == 5) {
                goal1.setGstatus1("목표완성");
            }
            if (goal1.getGstatus() == 6) {
                goal1.setGstatus1("목표미완성");
            }
            if (goal1.getGstatus() == 7) {
                goal1.setGstatus1("목표중지");
            }
        }
        // 이걸 적으니 2개씩 출력됨
        // result = returnGList;
        return result;
    };

    public ArrayList<Goal> selectOne1Goal(int wsid) {
        ArrayList<Goal> result = boardDAO.selectOne1Goal(wsid);

        for (Goal goal : result) {
            log.debug("처음값 : {}", goal);
            if (goal.getGstartdate() != "" && goal.getGenddate() != "" &&
                    goal.getGstartdate() != null && goal.getGenddate() != null) {
                String goal1 = goal.getGstartdate() + "~" + goal.getGenddate();
                goal.setCalendar(goal1);
                log.debug("Calendar1 : {}", goal);
            } else if (goal.getGstartdate() == "" || goal.getGenddate() == "" &&
                    goal.getGstartdate() == null || goal.getGenddate() == null) {
                String goal1 = "";
                goal.setCalendar(goal1);
                log.debug("Calendar2 : {}", goal);
            }
            if (goal.getGstatus() == 0) {
                goal.setGstatus1("진행중");
            }
            if (goal.getGstatus() == 1) {
                goal.setGstatus1("위험");
            }
            if (goal.getGstatus() == 2) {
                goal.setGstatus1("기간지남");
            }
            if (goal.getGstatus() == 3) {
                goal.setGstatus1("완료");
            }
            if (goal.getGstatus() == 4) {
                goal.setGstatus1("보류");
            }
            if (goal.getGstatus() == 5) {
                goal.setGstatus1("목표완성");
            }
            if (goal.getGstatus() == 6) {
                goal.setGstatus1("목표미완성");
            }
            if (goal.getGstatus() == 7) {
                goal.setGstatus1("목표중지");
            }
        }
        return result;
    };

}
