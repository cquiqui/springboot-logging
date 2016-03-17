package net.javabeat;
import net.javabeat.model.TestModel;
import net.javabeat.service.TestService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLoggingDemo {
 
  private static final Logger logger = LoggerFactory.getLogger(SpringBootLoggingDemo.class);
  
  public static void main(String[] args) {
    
    SpringApplication springApplication = new SpringApplication(new Object[]{SpringBootLoggingDemo.class});
    springApplication.run(args);
    
    logger.error("Message logged at ERROR level");
    logger.warn("Message logged at WARN level");
    logger.info("Message logged at INFO level");
    logger.debug("Message logged at DEBUG level");
    TestModel model = new TestModel();
    TestService service = new TestService();
    service.service();
       
  }

}
