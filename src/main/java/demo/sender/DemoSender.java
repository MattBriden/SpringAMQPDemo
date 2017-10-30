package demo.sender;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class DemoSender {

	@Autowired
	private RabbitTemplate template;
	
	@Autowired
	private Queue queue;
	
	@Scheduled(fixedDelay = 1000, initialDelay = 500)
	public void send(){
		String message = "This is a demo message";
		this.template.convertAndSend(queue.getName(), message);
		System.out.println("Sent message: " + message );
	}
	
	public boolean isRunning(){
		return isRunning;
	}
}
