package com.example.scoop.service;

import com.example.scoop.dao.TaskDAO;
import com.example.scoop.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * projectName     :Scoop
 * fileName        :TaskServiceImpl
 * author          :yuuna
 * since           :2022/09/23
 */

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDAO taskDAO;

    @Override
    public int insertTask(Task task) {
        return taskDAO.insertTask(task);
    }
}
