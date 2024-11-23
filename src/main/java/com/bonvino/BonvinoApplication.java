package com.bonvino;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.bonvino")
public class BonvinoApplication {
	//

	public static void main(String[] args) {
		SpringApplication.run(BonvinoApplication.class, args);
	}

}
