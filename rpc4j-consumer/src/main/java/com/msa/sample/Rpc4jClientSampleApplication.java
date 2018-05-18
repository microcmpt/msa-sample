package com.msa.sample;

import com.msa.rpc4j.annotation.EnableRpc4jClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The type Msa sample application.
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.msa.sample")
@EnableRpc4jClients(basePackages = "com.msa.sample.api")
public class Rpc4jClientSampleApplication {
	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(Rpc4jClientSampleApplication.class, args);
	}
}
