package com.harman.springboot.demo.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import com.harman.springboot.demo.domain.AppUser
import com.harman.springboot.demo.repository.UserRepository

@Service
class AppUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		AppUser user = userRepository.findByUsername(s);

		if(user == null) {
			throw new UsernameNotFoundException(String.format("The username %s doesn't exist", s));
		}

		List<GrantedAuthority> authorities = new ArrayList<>()
		//As of now allowed only one role per user in future we can maintain many to many relationship between user and role
		/*def filterRole= {role ->
		 authorities.add(new SimpleGrantedAuthority(role.getRoleName()))
		 }
		 user.getRole().forEach(filterRole);*/
		authorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName()))

		UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities)

		return userDetails;
	}
}
