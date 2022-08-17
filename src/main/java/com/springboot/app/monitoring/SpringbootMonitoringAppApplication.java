package com.springboot.app.monitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SpringbootMonitoringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMonitoringAppApplication.class, args);
	}

}
