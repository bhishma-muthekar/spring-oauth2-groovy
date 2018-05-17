package com.harman.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harman.springboot.demo.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
