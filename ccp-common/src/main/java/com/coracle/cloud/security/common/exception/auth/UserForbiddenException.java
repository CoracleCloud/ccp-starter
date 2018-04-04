

package com.coracle.cloud.security.common.exception.auth;


import com.coracle.cloud.security.common.constant.RestCodeConstants;
import com.github.ag.core.exception.BaseException;

/**
 *
 * @author coracle
 * @version 2017/9/12
 */
public class UserForbiddenException extends BaseException {
    public UserForbiddenException(String message) {
        super(message, RestCodeConstants.EX_USER_FORBIDDEN_CODE);
    }

}
