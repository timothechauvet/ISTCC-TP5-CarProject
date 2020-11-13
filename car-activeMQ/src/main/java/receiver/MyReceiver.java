package receiver;

import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;

import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Console;

public class MyReceiver {

	public static void main(String[] args) {
		new MyReceiver().receiveMsg();
	}

	public void receiveMsg() {
		try{

			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");
			QueueConnectionFactory factory = (QueueConnectionFactory) applicationContext.getBean("connectionFactory");

			Queue queue = (Queue) applicationContext.getBean("queue");

			// Create a connection. See https://docs.oracle.com/javaee/7/api/javax/jms/package-summary.html
			QueueConnection queueConnection = factory.createQueueConnection();

			// Open a session
			QueueSession queueSession = queueConnection.createQueueSession(true, 1);

			// start the connection
			queueConnection.start();

			// Create a receiver
			QueueReceiver queueReceiver = queueSession.createReceiver(queue);

			// Receive the message
			// Works with two receiving processes
			while(true) {
				Message message = queueReceiver.receive();
				if (message != null) {
					System.out.println("\n\n\n\nRECEIVER MESSAGE : " + message.toString() + "\n\n\n");
				} else {
					System.out.println("\n\n\n\nNo message in queue !\n\n\n");
					break;
				}
			}

			queueReceiver.close();
			queueConnection.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
