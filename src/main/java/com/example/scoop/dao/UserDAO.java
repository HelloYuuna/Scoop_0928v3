package com.example.scoop.dao;

import com.example.scoop.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {

    User findById(String email);

    int insertUser(User persistentUser);

    User fingfindByWsid(int i);
}
