

package com.coracle.cloud.security.auth.module.client.biz;

import com.alibaba.fastjson.JSON;
import com.coracle.cloud.security.auth.module.client.mapper.GatewayRouteMapper;
import com.coracle.cloud.security.common.constant.RedisKeyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.coracle.cloud.security.auth.module.client.entity.GatewayRoute;
import com.coracle.cloud.security.common.biz.BusinessBiz;

import java.util.List;

/**
 * @author coracle
 * @version 2018-02-25 12:04:28
 * @email coracle@coracle.com
 */
@Service
public class GatewayRouteBiz extends BusinessBiz<GatewayRouteMapper, GatewayRoute> {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void updateSelectiveById(GatewayRoute entity) {
        super.updateSelectiveById(entity);
        updateGatewayRoute();
    }

    @Override
    public void insertSelective(GatewayRoute entity) {
        super.insertSelective(entity);
        updateGatewayRoute();
    }

    @Override
    public void deleteById(Object id) {
        GatewayRoute gatewayRoute = this.selectById(id);
        gatewayRoute.setEnabled(false);
//        super.deleteById(id);
        this.updateSelectiveById(gatewayRoute);
    }

    @Override
    public void updateById(GatewayRoute entity) {
        super.updateById(entity);
        updateGatewayRoute();
    }

    public void updateGatewayRoute() {
        List<GatewayRoute> gatewayRoutes = this.selectListAll();
        redisTemplate.opsForValue().set(RedisKeyConstants.ZUUL_ROUTE_KEY, JSON.toJSONString(gatewayRoutes));
    }


}
