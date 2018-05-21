package com.harman.springboot.demo.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

import com.harman.springboot.demo.domain.AppUser

@Repository
interface UserRepository extends JpaRepository<AppUser, Long> {
	AppUser findByUsername(String username);
}
