

package com.coracle.cloud.security.auth.feign;

import com.coracle.cloud.security.auth.configuration.FeignConfiguration;
import com.coracle.cloud.security.common.msg.ObjectRestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


/**
 * ${DESCRIPTION}
 *
 * @author coracle
 * @version 2017-06-21 8:11
 */
@FeignClient(value = "${jwt.user-service}",configuration = FeignConfiguration.class)
public interface IUserService {
  /**
   * 通过账户\密码的方式登陆
   * @param username
   * @param password
   * @return
     */
  @RequestMapping(value = "/user/validate", method = RequestMethod.POST)
  public ObjectRestResponse<Map<String,String>> validate(@RequestParam("username") String username, @RequestParam("password") String password);
}
