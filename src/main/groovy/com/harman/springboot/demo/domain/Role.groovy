package com.harman.springboot.demo.domain

import static javax.persistence.CascadeType.PERSIST
import static javax.persistence.FetchType.LAZY
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
@Table(name="role")
class Role {

	@Id
	@GeneratedValue(strategy=AUTO)
	@Column(name="role_id")
	Long roleId

	@Column(name="role_name")
	String roleName

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST, mappedBy="role")
	Set<User> users

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", users=" + users + "]";
	}
}
