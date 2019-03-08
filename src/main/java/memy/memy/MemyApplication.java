package memy.memy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MemyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemyApplication.class, args);
	}
}
