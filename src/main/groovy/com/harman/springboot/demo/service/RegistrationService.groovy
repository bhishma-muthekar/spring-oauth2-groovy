package com.harman.springboot.demo.service


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

import com.harman.springboot.demo.command.UserCommand
import com.harman.springboot.demo.domain.AppUser
import com.harman.springboot.demo.domain.Role
import com.harman.springboot.demo.repository.RoleRepository
import com.harman.springboot.demo.repository.UserRepository

@Service
public class RegistrationService {

	@Autowired
	private UserRepository userRepository

	@Autowired
	RoleRepository roleRepository

	def UserCommand registerUser(UserCommand userCommand) {
		AppUser user = new AppUser()
		user.setUsername(userCommand.getUsername())
		user.setPassword(new BCryptPasswordEncoder().encode((userCommand
				.getPassword())))

		Role role = roleRepository.findByRoleId(1L)
		user.setRole(role)
		userRepository.save(user)

		userCommand.setUserId(user.getUserId())

		return userCommand
	}
}
