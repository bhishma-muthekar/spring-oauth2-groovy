package com.harman.springboot.demo.domain

import static javax.persistence.GenerationType.AUTO

import java.util.Collection

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.persistence.Transient

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
@Table(name="user")
class AppUser implements UserDetails{

	@Id
	@GeneratedValue(strategy=AUTO)
	@Column(name="user_id")
	Long userId

	@Column(name="user_name")
	String username

	@JsonIgnore
	@Column(name="password")
	String password

	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinColumn(name="role_id")
	Role role

	@Transient
	Collection<GrantedAuthority> grantedAuthorities

	boolean accountNonExpired=true
	boolean accountNonLocked=true
	boolean credentialsNonExpired=true
	boolean enabled=true
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", role=" + role
		+ ", accountNonExpired=" + accountNonExpired + ", accountNonLocked=" + accountNonLocked
		+ ", credentialsNonExpired=" + credentialsNonExpired + ", enabled=" + enabled + "]"
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
}
