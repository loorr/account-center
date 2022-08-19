package org.example.account.center.web.service.impl;


import org.checkerframework.checker.units.qual.A;
import org.example.account.center.api.entity.AccountVo;
import org.example.account.center.api.entity.req.LoginReq;
import org.example.account.center.api.entity.req.ModifyUserInfoReq;
import org.example.account.center.web.dao.AccountMapper;
import org.example.account.center.web.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public AccountVo login(LoginReq req) {
        AccountVo result = new AccountVo();
        result.setEmail("test");
        return result;
    }

    @Override
    public Boolean isLogin() {
        return null;
    }

    @Override
    public Boolean logout() {
        return null;
    }

    @Override
    public Boolean modifyUserInfo(ModifyUserInfoReq req) {
        return null;
    }
}
