package com.spring.process;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
	
	/**
	 * This will be executed when the Sprint Boot starts
	 */
	@Bean
	CommandLineRunner init(RuntimeService runtimeService) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... strings) throws Exception {
				Map<String, Object> variables = new HashMap<>();
				variables.put("applicantName", "Alexandre Gama");
				variables.put("email", "alexandre.gama.lima@gmail.com");
				variables.put("phoneNumber", "12345-7889");
				runtimeService.startProcessInstanceByKey("hireProcess", variables);
			}
		};
	}

	/**
	 * This is necessary as soon as we start using the Rest API, Activiti will requires authentication
	 */
	@Bean
	InitializingBean usersAndGroupInitializer(final IdentityService identityService) {
		return new InitializingBean() {
			
			@Override
			public void afterPropertiesSet() throws Exception {
				Group group = identityService.newGroup("user");
				group.setName("users");
				group.setType("security-groups");
				identityService.saveGroup(group);
				
				User user = identityService.newUser("admin");
				user.setPassword("admin");
				identityService.saveUser(user);
			}
		};
	}
	
}
