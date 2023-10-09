package com.example.demo.Repo;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.example.demo.model.NewUser;

@Component
@Lazy
public interface Repository extends MongoRepository<NewUser, Integer>{

	
}
