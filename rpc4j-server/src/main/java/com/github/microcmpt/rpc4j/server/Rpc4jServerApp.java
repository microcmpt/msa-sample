package com.github.microcmpt.rpc4j.server;

import com.msa.rpc4j.annotation.EnableRpc4jServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * The type Rpc 4 j server app.
 */
@EnableRpc4jServer
@SpringBootApplication
public class Rpc4jServerApp {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder();
        builder.sources(Rpc4jServerApp.class)
        .run(args);
    }

}
