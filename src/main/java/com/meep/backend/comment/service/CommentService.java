package com.meep.backend.comment.service;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meep.backend.comment.model.Comment;
import com.meep.backend.comment.repository.CommentRepository;
import com.meep.backend.position.repository.PositionRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private PositionRepository positionRepository;
	
	public List<Comment> getMessagesByEmitter(String id) {
		
	return	this.commentRepository.findByEmitterId(id);
	
	}
	
	public Comment saveComment(Comment comment) {
		
		comment.setDate(LocalDateTime.now());
		return this.commentRepository.save(comment);
		
	}

}
