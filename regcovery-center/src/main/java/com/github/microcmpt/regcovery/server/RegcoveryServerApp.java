package com.github.microcmpt.regcovery.server;

import com.msa.regcovery.dashboard.EnableRegcoveryDashboard;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * The type Regcovery server app.
 */
@SpringBootApplication
@EnableRegcoveryDashboard
public class RegcoveryServerApp {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder();
        builder.sources(RegcoveryServerApp.class)
        .run(args);
    }

}
