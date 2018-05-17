package com.harman.springboot.demo.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.harman.springboot.demo.domain.Country

@Repository
interface CountryRepository extends JpaRepository<Country, Long>{
	
	Country findByCountryId(Long countryId)
	
}
