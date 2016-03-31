package net.javabeat;
import net.javabeat.jmx.SimpleBean;
import net.javabeat.jmx.SimpleNotification;
import net.javabeat.model.TestModel;
import net.javabeat.service.TestService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("net.javabeat")
@SpringBootApplication
public class SpringBootLoggingDemo implements CommandLineRunner {
 
  private static final Logger logger = LoggerFactory.getLogger(SpringBootLoggingDemo.class);
  private static final Logger special = LoggerFactory.getLogger("jfg.logger.special");

  @Autowired  SimpleBean simpleBean;
  @Autowired  SimpleNotification simpleNotification;

  @Override
  public void run(String... args) throws Exception {


//    SpringApplication springApplication = new SpringApplication(new Object[]{SpringBootLoggingDemo.class});
//    springApplication.run(args);

    special.info("This is a special MESSAGE");

    logger.error("Message logged at ERROR level");
    logger.warn("Message logged at WARN level {} {} {} {} {} {}", 1, 2, 3, 4, 5, "coucou");
    logger.info("Message logged at INFO level");
    logger.debug("Message logged at DEBUG level");
    TestModel model = new TestModel();
    TestService service = new TestService();
    service.service();

    for(;;) {
      try {
        simpleNotification.notifyAboutAction("main loop");
        Thread.sleep( 1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
//      break;
    }
  }
  public static void main(String[] args) {

    logger.info("AppMain.main() Starting");
    ApplicationContext appContext = SpringApplication.run(SpringBootLoggingDemo.class, args);
    logger.info("AppMain.main bye...");
    SpringApplication.exit(appContext);
  }

}
