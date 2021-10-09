package com.meep.backend.position.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.meep.backend.position.model.*;

public interface PositionRepository extends MongoRepository<Position, String> {
	
	
}
