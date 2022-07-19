package fastcampus.spring.batch.springbatchlevel;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class SpringBatchLevelApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchLevelApplication.class, args);
	}

}
