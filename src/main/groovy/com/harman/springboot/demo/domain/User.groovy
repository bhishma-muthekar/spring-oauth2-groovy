package com.harman.springboot.demo.domain

import static javax.persistence.GenerationType.AUTO

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
@Table(name="user")
class User {

	@Id
	@GeneratedValue(strategy=AUTO)
	@Column(name="user_id")
	Long userId;

	@Column(name="user_name")
	String userName;

	@JsonIgnore
	@Column(name="password")
	String password;

	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinColumn(name="role_id")
	Role role;

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}
}
