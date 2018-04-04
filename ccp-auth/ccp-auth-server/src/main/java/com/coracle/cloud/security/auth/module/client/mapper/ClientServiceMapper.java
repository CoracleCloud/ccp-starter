

package com.coracle.cloud.security.auth.module.client.mapper;

import com.coracle.cloud.security.auth.module.client.entity.ClientService;
import com.coracle.cloud.security.common.mapper.CommonMapper;

public interface ClientServiceMapper extends CommonMapper<ClientService> {
    void deleteByServiceId(String id);
}
