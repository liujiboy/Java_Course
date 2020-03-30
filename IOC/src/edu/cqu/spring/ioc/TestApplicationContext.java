package edu.cqu.spring.ioc;

public class TestApplicationContext {

	public static void main(String[] args) {
	      ApplicationContext context = 
	          new ApplicationContext(Application.class);
	      MessageService service = context.getBean(MessageService.class);
	      MessagePrinter printer=context.getBean(MessagePrinter.class);
	      System.out.println("service.getMessage():"+service.getMessage());
	      printer.printMessage();
	      AnotherMessage am=context.getBean(AnotherMessage.class);
	      am.say();
	      String buffer=context.getBean(String.class);
	      System.out.println(buffer);
	  }

}
