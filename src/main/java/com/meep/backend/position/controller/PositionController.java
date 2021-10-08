package com.meep.backend.position.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PositionController {

	
	@RequestMapping(value = "/get-cercanos", method = RequestMethod.GET)
    public ResponseEntity<?> userById() {
        
        return new ResponseEntity<Object>("hello world", HttpStatus.OK);
    }
	
	
	
}
