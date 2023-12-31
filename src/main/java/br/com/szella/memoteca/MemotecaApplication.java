package br.com.szella.memoteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class MemotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemotecaApplication.class, args);
	}

}
