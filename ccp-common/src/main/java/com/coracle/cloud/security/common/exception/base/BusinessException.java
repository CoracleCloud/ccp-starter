

package com.coracle.cloud.security.common.exception.base;

import com.coracle.cloud.security.common.constant.RestCodeConstants;
import com.github.ag.core.exception.BaseException;

/**
 * 业务异常基础类
 * @author coracle
 * @version 2018/1/13.
 */
public class BusinessException extends BaseException {
    public BusinessException(String message) {
        super(message, RestCodeConstants.EX_BUSINESS_BASE_CODE);
    }
}
