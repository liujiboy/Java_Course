package edu.cqu.ioc;

import edu.cqu.ioc.annotation.Component;

@Component
public class AnotherMessage {
	@Autowired
	private MessageService service;
	public void say()
	{
		System.out.println("another message:"+service.getMessage());
		
	}
}
