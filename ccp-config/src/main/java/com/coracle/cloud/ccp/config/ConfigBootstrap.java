package com.coracle.cloud.ccp.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ace
 * @version 2017/12/26.
 */
@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigBootstrap.class).web(true).run(args);    }
}
