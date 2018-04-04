
package com.coracle.cloud.security.gate.feign;

import com.coracle.cloud.security.gate.config.FeignConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author coracle
 * @version 2018/1/18.
 */
@FeignClient(value = "ccp-transaction-demo2",configuration = FeignConfiguration.class)
public interface IProdFeign {
    @RequestMapping("/prod/test")
    public void test();
}
