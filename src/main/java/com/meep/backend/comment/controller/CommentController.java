package com.meep.backend.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meep.backend.comment.model.Comment;
import com.meep.backend.comment.service.CommentService;
import com.meep.backend.position.model.Position;

@RestController
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	
	@RequestMapping(value = "/get-comments", method = RequestMethod.POST)
    public ResponseEntity<?> userById(@RequestBody Position position) {
        List<Comment> list = this.commentService.getMessagesByEmitter(position.getId());
        return new ResponseEntity<Object>(list, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/create-comment", method = RequestMethod.POST)
    public ResponseEntity<Comment> create(@RequestBody Comment comment) {
		Comment ret = this.commentService.saveComment(comment);
        return new ResponseEntity<Comment>(ret, HttpStatus.CREATED);
    }
	
}
