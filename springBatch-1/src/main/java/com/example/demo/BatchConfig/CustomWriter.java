package com.example.demo.BatchConfig;

import java.util.List;


import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.example.demo.Repo.Repository;
import com.example.demo.model.NewUser;
@Lazy

@Component
public class CustomWriter implements ItemWriter<NewUser>{
	@Autowired
	Repository repository;
	@Override
	public void write(List<? extends NewUser> items) throws Exception {
	repository.saveAll(items);
		
	}
	
	 
}
