

package com.coracle.cloud.security.gate.config;

import com.coracle.cloud.security.auth.client.interceptor.ServiceFeignInterceptor;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author coracle
 * @date 2017/9/12
 */
public class FeignConfiguration {
    @Bean
    ServiceFeignInterceptor getClientTokenInterceptor(){
        return new ServiceFeignInterceptor();
    }
}
