package com.spring.process;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartProcessRestController {

	@RequestMapping(value = "/start-hiring-process", method = RequestMethod.POST)
	public void startProcess(Map<String, Object> data) {
		System.out.println(data);
	}
	
}
