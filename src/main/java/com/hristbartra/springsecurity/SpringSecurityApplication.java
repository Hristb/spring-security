package com.hristbartra.springsecurity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurityApplication  implements CommandLineRunner{

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	String password = "secreto";
	for(int i =0; i<4; i++) {
		String passwordBCrypt = bCryptPasswordEncoder.encode(password);
		System.out.println("clave"+i+" : "+ passwordBCrypt);
	}
		
	}

}
