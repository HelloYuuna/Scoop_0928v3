package com.example.scoop.repository;

import com.example.scoop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * projectName     :Scoop
 * fileName        :MemberRepository
 * author          :yuuna
 * since           :2022/09/21
 */
public interface MemberRepository extends JpaRepository<User, String> {
}
