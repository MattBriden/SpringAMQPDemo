package demo.receiver;

import java.util.Date;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "demo")
public class DemoReceiver {
	
	@RabbitHandler
	public void receive(Date time){
		System.out.println("Recevied: " + time.toString());
	}
}
