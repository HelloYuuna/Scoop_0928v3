package com.example.scoop.service;

import com.example.scoop.domain.Task;

import java.util.List;

/**
 * projectName     :Scoop
 * fileName        :TaskService
 * author          :yuuna
 * since           :2022/09/23
 */
public interface TaskService {
    int insertTask(Task task);

    List<Task> selectAll(Task task);
}
