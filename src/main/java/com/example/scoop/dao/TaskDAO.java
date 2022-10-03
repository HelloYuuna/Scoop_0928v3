package com.example.scoop.dao;

import com.example.scoop.domain.Task;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * projectName     :Scoop
 * fileName        :TaskDAO
 * author          :yuuna
 * since           :2022/09/28
 */

@Mapper
public interface TaskDAO {
    int insertTask(Task task);

    List<Task> selectAll(Task task);
}
