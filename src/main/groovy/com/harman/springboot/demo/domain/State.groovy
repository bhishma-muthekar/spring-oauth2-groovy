package com.harman.springboot.demo.domain

import static javax.persistence.GenerationType.AUTO

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

import groovy.transform.Canonical

@Entity
@Table(name="STA_STATE")
class State {

	@Id
	@GeneratedValue(strategy=AUTO)
	@Column(name="state_id")
	Long stateId

	@Column(name="name")
	String name

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="country_id")
	Country country
}
