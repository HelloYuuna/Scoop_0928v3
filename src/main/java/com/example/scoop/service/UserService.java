package com.example.scoop.service;

import com.example.scoop.domain.User;
import com.example.scoop.domain.UserDTO;

import java.util.List;

public interface UserService {

    User findById(String email);

    int insertMember(UserDTO user);

    List<User> findByWsid(int i);
}
