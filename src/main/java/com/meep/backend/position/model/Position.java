package com.meep.backend.position.model;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Position {
	
	@Id
	private String id;
	private String nombre;
	private double latitude;
	private double longitud;
	
}
