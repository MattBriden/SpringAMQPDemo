package demo.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "demo")
public class DemoReceiver {
	
	@RabbitHandler
	public void receive(String in){
		System.out.println("Recevied: " + in);
	}
}
