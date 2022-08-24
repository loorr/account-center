package org.example.account.center.web.service.impl;


import com.tove.web.infra.common.BaseException;
import org.example.account.center.api.entity.AccountVo;
import org.example.account.center.api.entity.req.GetAccountInfoReq;
import org.example.account.center.api.entity.req.LoginReq;
import org.example.account.center.api.entity.req.ModifyUserInfoReq;
import org.example.account.center.api.common.AccountErrorCode;
import org.example.account.center.web.dao.AccountMapper;
import org.example.account.center.web.model.Account;
import org.example.account.center.web.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public AccountVo login(LoginReq req) {
        Account account = accountMapper.getAccountByEmail(req.getEmail(), req.getTenantId());
        if (account == null) {
            throw new BaseException(AccountErrorCode.ACCOUNT_OR_PASSWORD_ERROR);
        }
        // 暂时是明文
        if (!account.getPassword().equals(req.getPassword())) {
            throw new BaseException(AccountErrorCode.ACCOUNT_OR_PASSWORD_ERROR);
        }
        return getAccountInfo(account.getUid(), req.getTenantId());
    }

    private AccountVo getAccountInfo(Long uid, Long tenantId) {
        AccountVo result = new AccountVo();
        Account account = accountMapper.getAccountByUid(uid, tenantId);
        if (account == null){
            throw new BaseException(AccountErrorCode.USER_NOT_EXIST);
        }
        result.setEmail(account.getEmail());
        result.setUid(account.getUid());
        result.setNickname(account.getNickname());
        result.setUsername(account.getUsername());



        return result;
    }

    @Override
    public AccountVo getAccountInfo(GetAccountInfoReq req) {
        return getAccountInfo(req.getUid(), req.getTenantId());
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
