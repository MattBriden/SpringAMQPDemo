package demo;

@SpringBootApplication
public class App implements CommandLineRunner {

	@Override
	public void run(String... args){
		System.out.println("Running");
	}

	public static void main(String[] args){
		SpringApplication.run(App.class, args);
	}
}