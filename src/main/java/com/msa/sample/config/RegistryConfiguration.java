package com.msa.sample.config;

import com.msa.sample.registry.ServiceRegistry;
import com.msa.sample.registry.ServiceRegistryImpl;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Registry configuration.
 *
 * @class:RegistryConfiguration
 * @description:描述
 * @author:sxp
 * @date:2018/4/22 16 :15
 */
@Configuration
@ConfigurationProperties(prefix = "registry")
public class RegistryConfiguration {

    /**
     * The Servers.
     */
    private String servers;

    /**
     * Gets servers.
     *
     * @return the servers
     */
    public String getServers() {
        return servers;
    }

    /**
     * Sets servers.
     *
     * @param servers the servers
     */
    public void setServers(String servers) {
        this.servers = servers;
    }

    /**
     * Service registry service registry.
     *
     * @return the service registry
     */
    @Bean
    public ServiceRegistry serviceRegistry() {
        return new ServiceRegistryImpl(servers);
    }
}
