package com.harman.springboot.demo.domain

import static javax.persistence.GenerationType.AUTO

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name="CRY_COUNTRY")
class Country {

	@Id
	@GeneratedValue(strategy=AUTO)
	@Column(name="country_id")
	Long countryId;

	@Column(name="name")
	String name

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="country")
	List<State> state

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", name=" + name + ", state=" + state + "]";
	}
}
