package com.efrei.JPAExample.controller;

import com.efrei.JPAExample.model.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jms.*;

public class CarService {

    public static void message(Car car) {
        try{

            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");
            QueueConnectionFactory factory = (QueueConnectionFactory) applicationContext.getBean("connectionFactory");

            Queue queue = (Queue) applicationContext.getBean("queue");

            // Create a connection. See https://docs.oracle.com/javaee/7/api/javax/jms/package-summary.html
            QueueConnection queueConnection = factory.createQueueConnection();

            // Open a session without transaction and acknowledge automatic
            QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

            // Start the connection
            queueConnection.start();

            // Create a sender
            QueueSender queueSender = queueSession.createSender(queue);

            // Create a message
            ObjectMessage objectMessage = queueSession.createObjectMessage(car);

            // Send the message
            queueSender.send(objectMessage);

            // Close the session
            queueSender.close();

            // Close the connection
            queueConnection.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
