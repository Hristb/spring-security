package com.hristbartra.springsecurity.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	@GetMapping("/getGreet")
	public String showDemo() {
		var auth = SecurityContextHolder.getContext().getAuthentication();
		logger.info("user: "+auth.getPrincipal());
		logger.info("daot2: "+auth.getCredentials());
		logger.info("dato3: "+auth.getAuthorities());
		logger.info("dato4: "+auth.getName());
		
		return "Hello world ";
	}
	
	@GetMapping("/userAdmin")
	public String showAdmin() {
		var auth = SecurityContextHolder.getContext().getAuthentication();
		logger.info("user: "+auth.getPrincipal());
		logger.info("daot2: "+auth.getCredentials());
		logger.info("dato3: "+auth.getAuthorities());
		logger.info("dato4: "+auth.getName());
		
		return "Hello Admin ";
	}
	
	@GetMapping("/public")
	public String showPublic() {
		var auth = SecurityContextHolder.getContext().getAuthentication();
		logger.info("user: "+auth.getPrincipal());
		logger.info("daot2: "+auth.getCredentials());
		logger.info("dato3: "+auth.getAuthorities());
		logger.info("dato4: "+auth.getName());
		
		return "Hello Public ";
	}
	
}
