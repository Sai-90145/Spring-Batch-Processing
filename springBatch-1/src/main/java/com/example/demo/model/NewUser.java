package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("collection = newUsers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewUser {
	
	
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private long phoneNo;
	

}
