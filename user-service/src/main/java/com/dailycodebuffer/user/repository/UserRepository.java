package com.dailycodebuffer.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailycodebuffer.user.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

}
