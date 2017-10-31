package demo;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import demo.receiver.DemoReceiver;
import demo.receiver.DemoReceiver2;
import demo.sender.DemoSender;
import demo.sender.DemoSender2;

@Profile({"demo-queue"})
@Configuration
public class AppConfig {

	@Bean
	public Queue demo(){
		return new Queue("demo");
	}
	
	@Profile("demo-receiver-1")
	@Bean
	public DemoReceiver receiver(){
		return new DemoReceiver();
	}
	
	@Profile("demo-receiver-2")
	@Bean
	public DemoReceiver2 receiver2(){
		return new DemoReceiver2();
	}
	
	@Profile("demo-sender-1")
	@Bean
	public DemoSender sender(){
		return new DemoSender();
	}
	
	@Profile("demo-sender-2")
	@Bean
	public DemoSender2 sender2(){
		return new DemoSender2();
	}
}
