package com.example.scoop.service;

import com.example.scoop.dao.UserDAO;
import com.example.scoop.domain.Role;
import com.example.scoop.domain.User;
import com.example.scoop.domain.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findById(String email) {
        return userDAO.findById(email);
    }

    /**
     * 데이터베이스의 데이터 변질을 막기위해
     * USERDTO 객체로 우회하여 저장
     *
     * @param user DTO 객체
     * @return 회원가입 결과값
     */
    @Override
    public int insertMember(UserDTO user) {

        User persistentUser = new User();
        persistentUser.setEmail(user.getEmail());                           // 이메일 저장

        // 비밀번호 인코딩
        log.info("인코딩전: {}", user.getPassword());

        String encodedPW = passwordEncoder.encode(user.getPassword());
        persistentUser.setPassword(encodedPW);                              // 비번 저장

        log.info("인코딩후: {}", encodedPW);

        persistentUser.setName(user.getName());                             // 이름 저장
        persistentUser.setRole(Role.USER);                                  // 롤 USER로 박아버리기!

        return userDAO.insertUser(persistentUser);
    }

    @Override
    public User findByWsid(int i) {
        return userDAO.fingfindByWsid(i);
    }

}
