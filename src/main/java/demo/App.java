package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages={"demo"})
@EnableScheduling
public class App implements CommandLineRunner {
	
	@Autowired
	AnnotationConfigApplicationContext ctx;

	@Override
	public void run(String... args){
		try{
			System.out.println("Running");
			Thread.sleep(10000);
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ctx.close();
	}

	public static void main(String[] args){
		SpringApplication.run(App.class, args);
	}
}