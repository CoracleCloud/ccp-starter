

package com.coracle.cloud.security.monitor.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ${DESCRIPTION}
 *
 * @author coracle
 * @version 2017-06-02 13:43
 */
@Controller
public class SecurityController {
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login() {
        return "login";
    }
}
