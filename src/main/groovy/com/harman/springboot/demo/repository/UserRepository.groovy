package com.harman.springboot.demo.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

import com.harman.springboot.demo.domain.User

@Repository
interface UserRepository extends JpaRepository<User, Long> {
	User findByUserName(String username);
}
