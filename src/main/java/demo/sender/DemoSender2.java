package demo.sender;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class DemoSender2 {
	
	@Autowired
	private RabbitTemplate template;
	
	@Autowired
	private Queue queue;
	
	private boolean isRunning = true;
	
	@Scheduled(fixedDelay = 1000, initialDelay = 500)
	public void send() throws Exception{
		int counter = 0;
		while(true){
			StringBuilder message = new StringBuilder("still running: ");
			message.append(counter);
			Thread.sleep(1000);
			this.template.convertAndSend(queue.getName(), message.toString());
			System.out.println("Queued message: " + message.toString());
			counter++;
		}
	}
	
	public boolean isRunning(){
		return isRunning;
	}

}
