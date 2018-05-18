package com.msa.sample;

import com.msa.rpc4j.annotation.EnableRpc4jClients;
import com.msa.sample.api.HelloRpc4jService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * The type Msa sample application.
 */
@SpringBootApplication
@EnableRpc4jClients(basePackages = "com.msa.sample")
public class Rpc4jClientSampleApplication {
	@Autowired
	private HelloRpc4jService helloRpc4jService;

	@PostConstruct
	public void init() {
		System.out.println(helloRpc4jService.hello("sxp"));
	}
	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(Rpc4jClientSampleApplication.class, args);
	}
}
