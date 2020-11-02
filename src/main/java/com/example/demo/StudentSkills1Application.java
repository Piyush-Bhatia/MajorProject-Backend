package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;



@SpringBootApplication(scanBasePackages = "com.example.demo")
@ComponentScan(basePackages = {"com.example.demo"}) 
public class StudentSkills1Application {

	public static void main(String[] args) {
		SpringApplication.run(StudentSkills1Application.class, args);
	}
	
	@Bean
	public HibernateJpaSessionFactoryBean SessionFactory()
	{
		return new HibernateJpaSessionFactoryBean();
	}

}
