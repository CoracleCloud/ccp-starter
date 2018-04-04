

package com.coracle.cloud.security.gate.feign;

import com.coracle.cloud.security.gate.config.FeignConfiguration;
import com.coracle.cloud.security.api.vo.authority.PermissionInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * ${DESCRIPTION}
 *
 * @author coracle
 * @version 2017-06-21 8:11
 */
@FeignClient(value = "ccp-admin",configuration = FeignConfiguration.class)
public interface IUserFeign {
  /**
   * 获取用户的菜单和按钮权限
   * @return
     */
  @RequestMapping(value="/api/user/permissions",method = RequestMethod.GET)
  public List<PermissionInfo> getPermissionByUsername();

  /**
   * 获取所有菜单和按钮权限
   * @return
     */
  @RequestMapping(value="/api/permissions",method = RequestMethod.GET)
  List<PermissionInfo> getAllPermissionInfo();
}
