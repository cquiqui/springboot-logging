package net.javabeat.jmx;

import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.stereotype.Service;

import javax.management.Notification;

/**
 * Created by jean-francois_gaucheron on 31/03/2016.
 *
 * from : https://blog.synyx.de/2012/05/how-to-monitor-and-manage-your-java-application-with-jmx/
 */
@Service
@ManagedResource(objectName = "mbeans:name=myJmxSimpleNotification", description = "My Simple Notification.")
public class SimpleNotification implements NotificationPublisherAware {

  // lot of stuff

  private NotificationPublisher notificationPublisher;

  public void notifyAboutAction(String msg) {
    notificationPublisher.sendNotification(new Notification("Simple Notification", this, 0, msg));
  }

  @Override
  public void setNotificationPublisher(NotificationPublisher notificationPublisher) {
    this.notificationPublisher = notificationPublisher;
  }

}
