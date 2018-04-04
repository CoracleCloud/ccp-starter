

package com.coracle.cloud.security.gate;


import com.coracle.cloud.gate.ratelimit.EnableAceGateRateLimit;
import com.coracle.cloud.gate.ratelimit.config.IUserPrincipal;
import com.coracle.cloud.security.auth.client.EnableAceAuthClient;
import com.coracle.cloud.security.gate.config.UserPrincipal;
import com.coracle.cloud.security.gate.utils.DBLog;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Ace on 2017/6/2.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients({"com.coracle.cloud.security.auth.client.feign","com.coracle.cloud.security.gate.feign"})
@EnableZuulProxy
@EnableScheduling
@EnableAceAuthClient
@EnableAceGateRateLimit
@EnableSwagger2Doc
public class GateBootstrap {
    public static void main(String[] args) {
        DBLog.getInstance().start();
        SpringApplication.run(GateBootstrap.class, args);
    }

    @Bean
    @Primary
    IUserPrincipal userPrincipal(){
        return new UserPrincipal();
    }
}
