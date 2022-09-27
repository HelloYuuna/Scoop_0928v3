package com.example.scoop.service;

import com.example.scoop.domain.User;
import com.example.scoop.domain.UserDTO;

public interface UserService {

    User findById(String email);

    int insertMember(UserDTO user);

    User findByWsid(int i);
}
