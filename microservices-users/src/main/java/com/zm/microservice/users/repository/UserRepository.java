package com.zm.microservice.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zm.microservice.users.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findUserById(Long userId);


}
