package com.harman.springboot.demo.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import com.harman.springboot.demo.domain.State

@Repository
interface StateRepository extends JpaRepository<State, Long>, PagingAndSortingRepository<State, Long>{
	State findByStateId(Long stateId);
}
