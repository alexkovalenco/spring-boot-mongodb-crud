package com.spring.mongo.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeDTO {

	@NotNull
	private String userId;
	@NotNull
	private String noteId;
}
