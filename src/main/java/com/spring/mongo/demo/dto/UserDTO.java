package com.spring.mongo.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private String firstName;
	private String lastName;
	@NotNull
	private String userName;
	@NotNull
	private String password;
}
