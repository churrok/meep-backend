package com.meep.backend.position.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meep.backend.position.model.*;
import com.meep.backend.position.repository.PositionRepository;

@Service
public class PositionService {
	
	@Autowired
	private PositionRepository positionRepository;
	
	
	public List<Position> getCloseMeepers(Position position){
		List<Position> closeMeepers = this.positionRepository.findAll();
		closeMeepers.removeIf(n -> (distance(n,position,"K")>5 ));
		
		return closeMeepers;
	}
	public Position guardar(Position position) {
		return this.positionRepository.save(position);
	}
	public void delete(String id) {
		this.positionRepository.deleteById(id);;
	}
	
	
	private static double distance(Position positionA,Position positionB, String unit) {
		if ((positionA.getLatitude() == positionB.getLatitude()) && (positionA.getLongitud() == positionB.getLongitud())) {
			return 0;
		}
		else {
			double theta = positionA.getLongitud() - positionB.getLongitud();
			double dist = Math.sin(Math.toRadians(positionA.getLatitude())) * Math.sin(Math.toRadians(positionB.getLatitude())) + Math.cos(Math.toRadians(positionA.getLatitude())) * Math.cos(Math.toRadians(positionB.getLatitude())) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			if (unit.equals("K")) {
				dist = dist * 1.609344;
			} else if (unit.equals("N")) {
				dist = dist * 0.8684;
			}
			return (dist);
		}
		
	
	}
}
