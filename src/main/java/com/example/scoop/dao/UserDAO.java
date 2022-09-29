package com.example.scoop.dao;

import com.example.scoop.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDAO {

    User findById(String email);

    int insertUser(User persistentUser);

    List<User> findByWsid(int wsid);
}
