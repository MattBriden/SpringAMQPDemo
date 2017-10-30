package demo;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import demo.receiver.DemoReceiver;
import demo.sender.DemoSender;

@Profile({"demo-queue"})
@Configuration
public class AppConfig {

	@Bean
	public Queue demo(){
		return new Queue("demo");
	}
	
	@Profile("receiver")
	@Bean
	public DemoReceiver receiver(){
		return new DemoReceiver();
	}
	
	@Profile("sender")
	@Bean
	public DemoSender sender(){
		return new DemoSender();
	}
}
