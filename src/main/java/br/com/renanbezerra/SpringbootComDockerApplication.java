package br.com.renanbezerra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "br.com.renanbezerra")
@EntityScan(basePackages = "br.com.renanbezerra.model")
public class SpringbootComDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootComDockerApplication.class, args);
	}

}
