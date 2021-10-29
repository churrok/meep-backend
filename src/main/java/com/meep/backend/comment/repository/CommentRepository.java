package com.meep.backend.comment.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.meep.backend.comment.model.Comment;

public interface CommentRepository extends MongoRepository<Comment, String> {

	public List<Comment> findByEmitterId(String emitterId);
}
