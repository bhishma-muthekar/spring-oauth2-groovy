package com.harman.springboot.demo.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import com.harman.springboot.demo.domain.Country
import com.harman.springboot.demo.repository.CountryRepository

@Service
class CountryService {

	static final Logger logger=LoggerFactory.getLogger(CountryService.class)

	@Autowired
	CountryRepository countryRepository

	def saveCountry(Country country){
		countryRepository.save(country)
		logger.info("Saved {} record successfully",country)
	}

	def list(){
		return countryRepository.findAll();
	}

	def get(Long id){
		return countryRepository.findByCountryId(id)
	}

	def update(Country country){
		countryRepository.save(country)
	}

	def delete(Long id){
		Country country=countryRepository.findByCountryId(id)
		countryRepository.delete(country)
	}
}
