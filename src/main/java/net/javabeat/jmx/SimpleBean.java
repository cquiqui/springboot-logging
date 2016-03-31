package net.javabeat.jmx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jmx.export.annotation.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jean-francois_gaucheron on 31/03/2016.
 *
 * from : https://blog.synyx.de/2012/05/how-to-monitor-and-manage-your-java-application-with-jmx/
 */
@Service
@ManagedResource(objectName = "mbeans:name=myJmxSimpleBean", description = "My Simple Bean.")
public class SimpleBean {
  private static final Logger logger = LoggerFactory.getLogger(SimpleBean.class);

  private long numberOfWaitingApplications = 3;

  /**
   * Attributes
   */
  @ManagedAttribute(description = "Get the number of all waiting applications" )
  public long getNumberOfWaitingApplications() {
    return numberOfWaitingApplications;
  }

  /**
   * Operations
   */

  @ManagedOperation(description = "Shows a list of all waiting applications with some information.")
  public List<String> showWaitingApplications() {
    // do something and return a list of all waiting applications

    return new ArrayList<String>(Arrays.asList("xyz", "abc"));
  }

  @ManagedOperation(description = "Get the number of all applications that have the given status.")
  @ManagedOperationParameters({
      @ManagedOperationParameter(name = "status", description = "The status may be ok or nok.")
  })
  public long countApplicationsInStatus(String status) {
    // do something and return number of applications with the given status
    if (status == null) return -1;
    else if (status.contentEquals("ok")) return 1;
    else if (status.contentEquals("nok")) return 2;
    else return -2;
  }

  /**
   * Notifications
   */


}
