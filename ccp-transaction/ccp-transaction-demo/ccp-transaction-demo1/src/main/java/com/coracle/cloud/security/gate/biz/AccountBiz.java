
package com.coracle.cloud.security.gate.biz;

import com.codingapi.tx.annotation.TxTransaction;
import com.coracle.cloud.security.common.biz.BaseBiz;
import com.coracle.cloud.security.gate.feign.IProdFeign;
import com.coracle.cloud.security.gate.entity.Account;
import com.coracle.cloud.security.gate.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 *
 * @author croacle
 * @email crocle@coracle.com
 * @version 2018-01-18 11:02:17
 */
@Service
public class AccountBiz extends BaseBiz<AccountMapper,Account> {
    @Autowired
    private IProdFeign prodFeign;
    @TxTransaction
    @Transactional
    public void test(){
        prodFeign.test();
        Account account = mapper.selectByPrimaryKey(1);
        Integer balance = account.getBalance();
        account.setBalance(balance-100);
        mapper.updateByPrimaryKey(account);
        int i =  1/0;
    }
}
