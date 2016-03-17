package net.javabeat.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestModel {
  private static final Logger logger = LoggerFactory.getLogger(TestModel.class);
  
  public TestModel(){
    logger.debug("Log message at DEBUG level from TestModel constructor");
    logger.info("Log message at INFO level from TestModel constructor");
  }
}
