package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBatchTest
@SpringBootTest

public class SpringBatch1ApplicationTests {
	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;
	@Test
	public void test()throws Exception{ 
		org.springframework.batch.core.JobExecution jobExecution= jobLauncherTestUtils.launchJob();
		assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
	
	}
	

}
