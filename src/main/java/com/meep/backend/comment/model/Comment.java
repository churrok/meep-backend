package com.meep.backend.comment.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Comment {
	@Id
	private String id;
	
	private String emitterId;
	private String receiverId;
	private String message;
	private LocalDateTime date;
	

}
