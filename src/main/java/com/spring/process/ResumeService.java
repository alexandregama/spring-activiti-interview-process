package com.spring.process;

import org.springframework.stereotype.Component;

@Component
public class ResumeService {

	/**
	 * This will be the first process instance that will be run when Spring Boot starts or when is called from an API call
	 */
	public void storeResume() {
		System.out.println("Storing resume..");
	}
	
}
