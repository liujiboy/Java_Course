package edu.cqu.spring.ioc;

import edu.cqu.spring.ioc.annotation.Bean;
import edu.cqu.spring.ioc.annotation.ComponentScan;
import edu.cqu.spring.ioc.annotation.Configuration;

@Configuration
@ComponentScan
public class Application {

	@Bean
	MessageService mockMessageService() {
		return new MessageService() {
			public String getMessage() {
				return "mockMessageService:Hello World!";
			}
		};
	}

	@Bean
	String buffer() {
		return "Appliccation:buffer";
	}

}