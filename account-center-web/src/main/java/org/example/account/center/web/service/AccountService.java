package org.example.account.center.web.service;

import com.tove.web.infra.common.Response;
import org.example.account.center.api.entity.AccountVo;
import org.example.account.center.api.entity.req.GetAccountInfoReq;
import org.example.account.center.api.entity.req.LoginReq;
import org.example.account.center.api.entity.req.ModifyUserInfoReq;

public interface AccountService {

    AccountVo login(LoginReq req);

    AccountVo getAccountInfo(GetAccountInfoReq req);

    Boolean isLogin();
    Boolean logout();

   Boolean modifyUserInfo(ModifyUserInfoReq req);

}
