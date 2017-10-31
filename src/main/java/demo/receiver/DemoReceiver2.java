package demo.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "demo")
public class DemoReceiver2 {

	@RabbitHandler
	public void receive(String message){
		System.out.println("Recevied: " + message);
	}
}
