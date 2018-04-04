
package com.coracle.cloud.security.gate.controller;

import com.coracle.cloud.security.auth.client.annotation.CheckUserToken;
import com.coracle.cloud.security.gate.biz.ProdBiz;
import com.github.ag.core.context.BaseContextHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author coracle
 * @version 2018/1/18.
 */
@RestController
@RequestMapping("/prod")
@Slf4j
@CheckUserToken
public class ProdRest {
    @Autowired
    private ProdBiz prodBiz;
    @RequestMapping("/test")
    public void test() throws InterruptedException {
        log.info(BaseContextHandler.getUserID());
        prodBiz.test();
    }
}
