package com.example.demo.BatchConfig;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.NewUser;
@Component
public class Processor implements ItemProcessor<NewUser, NewUser> {
	
	@Override
	public NewUser process(NewUser item) throws Exception {
		// TODO Auto-generated method stub
		//System.out.println(item);
		if(item.getUserId()<=1001) {
			item.setPhoneNo(100001);
		}
		return item;
	}

}
