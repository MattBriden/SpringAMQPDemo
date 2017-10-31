package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

import demo.sender.DemoSender2;

@SpringBootApplication(scanBasePackages={"demo"})
@EnableScheduling
public class App {

	@Autowired
	AnnotationConfigApplicationContext ctx;
	
	@Profile("sender-1")
	@Bean
	public CommandLineRunner demo1() {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) {
				try {
					System.out.println("Running");
					Thread.sleep(10000);
					System.out.println("Done");
				} catch (Exception e) {
					e.printStackTrace();
				}
				ctx.close();
			}
		};
	}
	
	@Profile("sender-2")
	@Bean
	public CommandLineRunner demo2() {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {

				DemoSender2 demoSender2 = ctx.getBean(DemoSender2.class);
				System.out.println("Ready to send messages");
				while (demoSender2.isRunning()) {
					// wait for all messages to be sent
				}
				System.out.println("All messages sent");
				ctx.close();
			}
		};
	}
	
	public static void main(String[] args){
		SpringApplication.run(App.class, args);
	}
}