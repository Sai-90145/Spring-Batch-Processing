package com.example.demo.BatchConfig;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import com.example.demo.model.NewUser;
@EnableBatchProcessing
@Configuration

public class BatchConfiguration {
	@Autowired
	 public JobBuilderFactory jf;
	
	@Bean
	public Job newJob() {
		return  jf.get("newJob")
				.incrementer(new RunIdIncrementer())
				.listener(jobExecutionListener)
				
				.start(step1())
				.build();
	}
	@Autowired
	
	public StepBuilderFactory sf;
	@Bean
	public Step step1() {
		return sf.get("step1")
				.<NewUser,NewUser>chunk(150)
				.reader(reader())
				
				.processor(processor)
				.writer(customwriter)
				//.taskExecutor(taskExecutor())
				.build();
				
	}
	@Bean
	public FlatFileItemReader<NewUser> reader(){
		FlatFileItemReader<NewUser> itemReader=new FlatFileItemReader<>();
		itemReader.setResource(new FileSystemResource("src/main/resources/NewUsers1.csv"));
		itemReader.setName("csvfile");
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(LineMapper());
		return itemReader;
	}
	@Bean
	public LineMapper<NewUser> LineMapper(){
		DefaultLineMapper<NewUser> defaultMapper=new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer=new DelimitedLineTokenizer();
		lineTokenizer.setStrict(false);
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setNames("userID","firstName","lastName","email","phoneNo");
		BeanWrapperFieldSetMapper<NewUser> fieldSetMapper=new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(NewUser.class);
		defaultMapper.setLineTokenizer(lineTokenizer);
		defaultMapper.setFieldSetMapper(fieldSetMapper);
		
		return defaultMapper;
		
	}
	@Autowired
	
	private Processor processor;
	
	@Autowired
	
	private  CustomWriter customwriter;
	
	@Autowired
	
	public JobExecutionListener jobExecutionListener;
	
	
	  @Bean 
	  public TaskExecutor taskExecutor() 
	  { 
		  SimpleAsyncTaskExecutor executor = new SimpleAsyncTaskExecutor();
			executor.setConcurrencyLimit(100);
			 
			return executor;
	  }
	
}
