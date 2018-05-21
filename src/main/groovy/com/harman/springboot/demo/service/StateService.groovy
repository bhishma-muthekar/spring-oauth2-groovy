package com.harman.springboot.demo.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

import com.harman.springboot.demo.domain.Country
import com.harman.springboot.demo.domain.State
import com.harman.springboot.demo.repository.StateRepository


@Service
class StateService {
	@Autowired
	StateRepository stateRepository

	def gotoPage(int page, int size) {
		PageRequest pageRequest = new PageRequest(page, size)
		return pageRequest
	}
	
	def findPage(int page, int size){
		return stateRepository.findAll(gotoPage(page, size))
	}

	def save(State state){
		stateRepository.save(state)
	}

	def list(){
		return stateRepository.findAll();
	}

	def get(Long id){
		return stateRepository.findByStateId(id)
	}

	def update(State state){
		stateRepository.save(state)
	}

	def delete(Long id){
		State state=stateRepository.findByStateId(id)
		stateRepository.delete(state)
	}
}
