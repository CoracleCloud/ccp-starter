

package com.coracle.cloud.security.auth.module.client.controller;

import com.coracle.cloud.security.auth.module.client.service.AuthService;
import com.coracle.cloud.security.auth.jwt.user.JwtAuthenticationRequest;
import com.coracle.cloud.security.auth.jwt.user.JwtAuthenticationResponse;
import com.coracle.cloud.security.common.constant.RequestHeaderConstants;
import com.coracle.cloud.security.common.msg.ObjectRestResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("jwt")
public class AuthController {
    @Value("${jwt.token-header}")
    private String tokenHeader;

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "token", method = RequestMethod.POST)
    public ObjectRestResponse<String> createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest) throws Exception {
        final String token = authService.login(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        if (StringUtils.isBlank(token)) {
            return new ObjectRestResponse<String>().data("");
        }
        return new ObjectRestResponse<String>().data(RequestHeaderConstants.JWT_TOKEN_TYPE + token);
    }

    @RequestMapping(value = "refresh", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(
            HttpServletRequest request) throws Exception {
        String token = request.getHeader(tokenHeader);
        String refreshedToken = authService.refresh(getRealToken(token));
        if (refreshedToken == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        }
    }

    @RequestMapping(value = "verify", method = RequestMethod.GET)
    public ResponseEntity<?> verify(String token) throws Exception {
        authService.validate(getRealToken(token));
        return ResponseEntity.ok(true);
    }

    @RequestMapping(value = "invalid", method = RequestMethod.POST)
    public ObjectRestResponse<Boolean> invalid(@RequestParam("token") String token) throws Exception {
        authService.invalid(getRealToken(token));
        return new ObjectRestResponse<Boolean>().data(true);
    }

    private String getRealToken(String originToken) {
        if (originToken != null && originToken.startsWith(RequestHeaderConstants.JWT_TOKEN_TYPE)) {
            originToken = originToken.substring(RequestHeaderConstants.JWT_TOKEN_TYPE.length(), originToken.length());
        }
        return originToken;
    }
}
