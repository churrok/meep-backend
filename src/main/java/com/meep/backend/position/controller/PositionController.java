package com.meep.backend.position.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.meep.backend.position.model.Position;
import com.meep.backend.position.service.PositionService;

@RestController
public class PositionController {
	
	
	@Autowired
	private PositionService positionService;
	
	@RequestMapping(value = "/get-cercanos", method = RequestMethod.POST)
    public ResponseEntity<?> userById(@RequestBody Position position) {
        List<Position> list = this.positionService.getCloseMeepers(position);
        return new ResponseEntity<Object>(list, HttpStatus.OK);
    }
	@RequestMapping(value = "/create-position", method = RequestMethod.POST)
    public ResponseEntity<Position> create(@RequestBody Position position) {
		Position ret = this.positionService.guardar(position);
        return new ResponseEntity<Position>(ret, HttpStatus.CREATED);
    }
}
