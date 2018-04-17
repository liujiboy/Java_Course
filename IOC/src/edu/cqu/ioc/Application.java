package edu.cqu.ioc;

import edu.cqu.ioc.annotation.Bean;
import edu.cqu.ioc.annotation.ComponentScan;
import edu.cqu.ioc.annotation.Configuration;

@Configuration
@ComponentScan
public class Application {

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
              return "Hello World!";
            }
        };
    }

  public static void main(String[] args) {
      ApplicationContext context = 
          new ApplicationContext(Application.class);
      MessageService service = context.getBean(MessageService.class);
      MessagePrinter printer=context.getBean(MessagePrinter.class);
      System.out.println("service.getMessage():"+service.getMessage());
      printer.printMessage();
      AnotherMessage am=context.getBean(AnotherMessage.class);
      am.say();
  }
}