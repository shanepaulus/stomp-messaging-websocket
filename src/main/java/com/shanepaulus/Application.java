package com.shanepaulus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Shane Paulus
 * <p>
 * Date Created : 05-Sep-2020.
 */

@SpringBootApplication
@EnableScheduling
@ComponentScan({ "com.shanepaulus.api", "com.shanepaulus.config" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
