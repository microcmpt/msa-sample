package com.msa.sample;

import com.msa.regcovery.dashboard.EnableRegcoveryDashboard;
import com.msa.rpc4j.annotation.EnableRpc4jServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Msa sample application.
 */
@SpringBootApplication
@EnableRpc4jServer
@EnableRegcoveryDashboard
public class Rpc4jServerSampleApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(Rpc4jServerSampleApplication.class, args);
	}
}
