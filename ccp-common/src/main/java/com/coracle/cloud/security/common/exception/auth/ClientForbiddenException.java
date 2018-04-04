

package com.coracle.cloud.security.common.exception.auth;


import com.coracle.cloud.security.common.constant.RestCodeConstants;
import com.github.ag.core.exception.BaseException;

/**
 * Created by ace on 2017/9/12.
 */
public class ClientForbiddenException extends BaseException {
    public ClientForbiddenException(String message) {
        super(message, RestCodeConstants.EX_CLIENT_FORBIDDEN_CODE);
    }

}
