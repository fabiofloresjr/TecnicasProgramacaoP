package apresentacao;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"negocios", "repositorio", "apresentacao", "validadores"})
public class FabioApplication {

	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");
		
		SpringApplicationBuilder builder = new SpringApplicationBuilder(FabioApplication.class);

		builder.headless(false);

		ConfigurableApplicationContext context = builder.run(args);
	}

}
