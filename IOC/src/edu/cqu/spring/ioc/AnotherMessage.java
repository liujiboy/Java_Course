package edu.cqu.spring.ioc;

import edu.cqu.spring.ioc.annotation.Autowired;
import edu.cqu.spring.ioc.annotation.Component;

@Component
public class AnotherMessage {
	@Autowired
	private MessageService service;
	public void say()
	{
		System.out.println("another message:"+service.getMessage());
		
	}
}
