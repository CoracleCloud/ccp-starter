

package com.coracle.cloud.security.auth.runner;

import com.alibaba.fastjson.JSON;
import com.coracle.cloud.security.auth.configuration.KeyConfiguration;
import com.coracle.cloud.security.auth.jwt.AECUtil;
import com.github.ag.core.util.RsaKeyHelper;
import com.coracle.cloud.security.auth.module.client.biz.GatewayRouteBiz;
import com.coracle.cloud.security.auth.module.client.entity.GatewayRoute;
import com.coracle.cloud.security.common.constant.RedisKeyConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author coracle
 * @version 2017/12/17.
 */
@Configuration
@Slf4j
public class AuthServerRunner implements CommandLineRunner {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    private static final String REDIS_USER_PRI_KEY = "AG:AUTH:JWT:PRI";
    private static final String REDIS_USER_PUB_KEY = "AG:AUTH:JWT:PUB";
    private static final String REDIS_SERVICE_PRI_KEY = "AG:AUTH:CLIENT:PRI";
    private static final String REDIS_SERVICE_PUB_KEY = "AG:AUTH:CLIENT:PUB";

    @Autowired
    private KeyConfiguration keyConfiguration;

    @Autowired
    private AECUtil aecUtil;

    @Autowired
    private RsaKeyHelper rsaKeyHelper;

    @Autowired
    private GatewayRouteBiz gatewayRouteBiz;

    @Override
    public void run(String... args) throws Exception {
        boolean flag = false;
        if (redisTemplate.hasKey(REDIS_USER_PRI_KEY)&&redisTemplate.hasKey(REDIS_USER_PUB_KEY)&&redisTemplate.hasKey(REDIS_SERVICE_PRI_KEY)&&redisTemplate.hasKey(REDIS_SERVICE_PUB_KEY)) {
            try {
                keyConfiguration.setUserPriKey(rsaKeyHelper.toBytes(aecUtil.decrypt(redisTemplate.opsForValue().get(REDIS_USER_PRI_KEY).toString())));
                keyConfiguration.setUserPubKey(rsaKeyHelper.toBytes(redisTemplate.opsForValue().get(REDIS_USER_PUB_KEY).toString()));
                keyConfiguration.setServicePriKey(rsaKeyHelper.toBytes(aecUtil.decrypt(redisTemplate.opsForValue().get(REDIS_SERVICE_PRI_KEY).toString())));
                keyConfiguration.setServicePubKey(rsaKeyHelper.toBytes(redisTemplate.opsForValue().get(REDIS_SERVICE_PUB_KEY).toString()));
            }catch (Exception e){
                log.error("初始化公钥/密钥异常...",e);
                flag = true;
            }
        } else {
            flag = true;
        }
        if(flag){
            Map<String, byte[]> keyMap = rsaKeyHelper.generateKey(keyConfiguration.getUserSecret());
            keyConfiguration.setUserPriKey(keyMap.get("pri"));
            keyConfiguration.setUserPubKey(keyMap.get("pub"));
            redisTemplate.opsForValue().set(REDIS_USER_PRI_KEY, aecUtil.encrypt(rsaKeyHelper.toHexString(keyMap.get("pri"))));
            redisTemplate.opsForValue().set(REDIS_USER_PUB_KEY, rsaKeyHelper.toHexString(keyMap.get("pub")));
            keyMap = rsaKeyHelper.generateKey(keyConfiguration.getServiceSecret());
            keyConfiguration.setServicePriKey(keyMap.get("pri"));
            keyConfiguration.setServicePubKey(keyMap.get("pub"));
            redisTemplate.opsForValue().set(REDIS_SERVICE_PRI_KEY, aecUtil.encrypt(rsaKeyHelper.toHexString(keyMap.get("pri"))));
            redisTemplate.opsForValue().set(REDIS_SERVICE_PUB_KEY, rsaKeyHelper.toHexString(keyMap.get("pub")));
        }
        log.info("完成公钥/密钥的初始化...");
        List<GatewayRoute> gatewayRoutes = gatewayRouteBiz.selectListAll();
        redisTemplate.opsForValue().set(RedisKeyConstants.ZUUL_ROUTE_KEY, JSON.toJSONString(gatewayRoutes));
        log.info("完成网关路由的更新...");
    }
}
