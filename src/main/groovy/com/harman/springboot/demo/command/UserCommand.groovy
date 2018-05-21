package com.harman.springboot.demo.command

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

import org.springframework.stereotype.Component

@Component
class UserCommand {
	
	Long userId;

	@NotNull
	@Size(min=2, max=30)
	String username;
	
	@NotNull
	@Size(min=4, max=30)
	String password;
}
