package com.harman.springboot.demo.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import com.harman.springboot.demo.domain.State
import com.harman.springboot.demo.service.StateService


@RestController
@RequestMapping("/api")
class StateController {

	@Autowired
	StateService stateService

	/*---Create a record-*/
	@PostMapping("/state")
	def create(@RequestBody State state){
		stateService.save(state)
		return ResponseEntity.status(201).body("New State has been saved with ID: "
				+ state.getStateId())
	}

	/*---Get a record list---*/
	@GetMapping("/state")
	def list(){
		return stateService.list()
	}

	/*---Get a record by id---*/
	@GetMapping("/state/{id}")
	def get(@PathVariable("id") Long id) {
		return stateService.get(id);
	}

	/*---Update a record by id---*/
	@RequestMapping(value="/state", method=RequestMethod.PUT)
	def ResponseEntity<?> update(@RequestBody State state) {
		stateService.update(state);
		return ResponseEntity.ok().body(
				"State has been updated successfully.");
	}

	/*---Delete a record by id---*/
	@DeleteMapping("/state/{id}")
	def delete(@PathVariable("id") long id) {
		stateService.delete(id);
		return ResponseEntity.status(204);
	}
}

