package com.example.demo.Launcher;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class BatchLauncher implements ApplicationRunner {
	@Autowired
	public JobLauncher jobLauncher;
	@Autowired
	public Job job;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		jobLauncher.run(job, new JobParametersBuilder().addLong("time",System.currentTimeMillis())
				.toJobParameters());
		
		
	}

}
