

package com.coracle.cloud.security.gate.config;

import com.codingapi.tx.springcloud.feign.TransactionRestTemplateInterceptor;
import com.coracle.cloud.security.auth.client.interceptor.ServiceFeignInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

/**
 * @author coracle
 * @version 2018/1/18.
 */
public class FeignConfiguration {
    @Bean
    public RequestInterceptor requestInterceptor(){
        return new TransactionRestTemplateInterceptor();
    }

    @Bean
    public ServiceFeignInterceptor serviceFeignInterceptor(){
        return new ServiceFeignInterceptor();
    }
}
