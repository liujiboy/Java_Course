package config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"controller"})
public class ServiceApplication {

	public static void main(String[] args) { 
		SpringApplication.run(ServiceApplication.class, args);
	}
}
