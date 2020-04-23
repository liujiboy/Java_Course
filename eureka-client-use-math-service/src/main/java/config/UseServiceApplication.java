package config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages= {"client","controller"})
@EnableFeignClients(basePackages= {"client"})
public class UseServiceApplication {
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		  return new RestTemplate();
	}

	public static void main(String[] args) { 
		SpringApplication.run(UseServiceApplication.class, args);
	}
}
