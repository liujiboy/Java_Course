package edu.cqu.spring.ioc;

import edu.cqu.spring.ioc.annotation.Autowired;
import edu.cqu.spring.ioc.annotation.Component;

@Component
public class MessagePrinter {
	@Autowired
    private MessageService service;
    public MessagePrinter() {
    }

    public void printMessage() {
        System.out.println(this.service.getMessage());
    }
}