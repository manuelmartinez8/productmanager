package com.web;

import com.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.web.entity.EUser;

import java.text.SimpleDateFormat;
import java.util.Date;


@Configuration
@EnableAutoConfiguration
@ComponentScan
@EntityScan("org.web.entity")
@EnableJpaRepositories("com.web.repository") 
@SpringBootApplication
public class SpringBootThymeleafApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootThymeleafApplication.class, args);
	}

	@Autowired
	private UserRepository repository;
	@Override
	public void run(String... args) throws Exception {

		EUser user = new EUser();
		user.setNombre("Manuel Martinez");
		user.setDocumento(6565687);
		user.setEmail("manuelon_8");

		String pattern = "MM-dd-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date date = simpleDateFormat.parse("06-10-1981");
		user.setFechaNacimiento(date);
		user.setPassword("123");
	//	repository.save(user);

		EUser user2 = new EUser();
		user2.setNombre("Adriana Martinez");
		user2.setDocumento(6565687);
		user2.setEmail("Adri_8");


		Date date2 = simpleDateFormat.parse("26-06-2015");
		user2.setFechaNacimiento(date2);
		user2.setPassword("123");
		//repository.save(user2);


	}
}
