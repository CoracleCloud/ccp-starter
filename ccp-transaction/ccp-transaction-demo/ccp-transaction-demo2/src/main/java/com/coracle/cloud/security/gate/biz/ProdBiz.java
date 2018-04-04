

package com.coracle.cloud.security.gate.biz;

import com.coracle.cloud.security.common.biz.BaseBiz;
import com.coracle.cloud.security.gate.entity.Prod;
import com.coracle.cloud.security.gate.mapper.ProdMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 *
 * @author coracle
 * @email coracle@coracle.com
 * @version 2018-01-18 11:11:06
 */
@Service
public class ProdBiz extends BaseBiz<ProdMapper,Prod> {
    @Transactional
    public void test(){
        Prod prod = mapper.selectByPrimaryKey(1);
        prod.setNum(prod.getNum()-2);
        mapper.updateByPrimaryKey(prod);
    }
}
