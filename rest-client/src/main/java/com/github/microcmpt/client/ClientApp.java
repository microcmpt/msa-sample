package com.github.microcmpt.client;

import com.msa.api.gateway.registry.EnableApiGatewayRegistryClient;
import com.msa.rpc4j.annotation.EnableRpc4jClients;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * The type Client app.
 */
@EnableRpc4jClients
@SpringBootApplication
@EnableApiGatewayRegistryClient
public class ClientApp {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplicationBuilder appBuilder=new SpringApplicationBuilder();
        appBuilder.sources(ClientApp.class);
        appBuilder.run(args);
    }
}
