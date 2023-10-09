package com.example.demo.JobExecution;

import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;
@Component

public class JobExecution  implements JobExecutionListener{

	@Override
	public void beforeJob(org.springframework.batch.core.JobExecution jobExecution) {
		// TODO Auto-generated method stub
		System.out.println("jobstarted at"+jobExecution.getCreateTime());
	}

	@Override
	public void afterJob(org.springframework.batch.core.JobExecution jobExecution) {
		// TODO Auto-generated method stub
		System.out.println("job ended at"+jobExecution.getEndTime());
	}

}
