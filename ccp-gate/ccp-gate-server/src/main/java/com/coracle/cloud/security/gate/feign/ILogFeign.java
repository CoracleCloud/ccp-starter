

package com.coracle.cloud.security.gate.feign;

import com.coracle.cloud.security.api.vo.log.LogInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ${DESCRIPTION}
 *
 * @author coracle
 * @version 2017-07-01 15:16
 */
@FeignClient("ccp-admin")
public interface ILogFeign {
  @RequestMapping(value="/api/log/save",method = RequestMethod.POST)
  public void saveLog(LogInfo info);
}
