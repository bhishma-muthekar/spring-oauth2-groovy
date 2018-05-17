package com.harman.springboot.demo.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import com.harman.springboot.demo.domain.Country
import com.harman.springboot.demo.service.CountryService

@RestController
@RequestMapping("/api")
class CountryController {

	@Autowired
	CountryService countryService

	/*---Create a record-*/
	@PostMapping("/country")
	def create(@RequestBody Country country){
		countryService.saveCountry(country)
		return ResponseEntity.status(201).body("New Country has been saved with ID: "
				+ country.getCountryId())
	}

	/*---Get a record list---*/
	@GetMapping(value="/country", produces=MediaType.APPLICATION_JSON_VALUE)
	def List<Country> list(){		
		return countryService.list()
	}

	/*---Get a record by id---*/
	@GetMapping("/country/{id}")
	def get(@PathVariable("id") Long id) {
		return countryService.get(id);
	}

	/*---Update a record by id---*/
	@RequestMapping(value="/country", method=RequestMethod.PUT)
	def ResponseEntity<?> update(@RequestBody Country country) {
		countryService.update(country);
		return ResponseEntity.ok().body(
				"Country has been updated successfully.");
	}

	/*---Delete a record by id---*/
	@DeleteMapping("/country/{id}")
	def delete(@PathVariable("id") long id) {
		countryService.delete(id);
		return ResponseEntity.status(204);
	}
}
