package edu.cqu.ioc;

import edu.cqu.ioc.annotation.Component;

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