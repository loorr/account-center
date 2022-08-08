package org.example.account.center.web.controller;

import com.tove.web.infra.common.Response;
import lombok.extern.slf4j.Slf4j;
import org.example.account.center.api.AccountApi;
import org.example.account.center.api.entity.AccountVo;
import org.example.account.center.api.entity.req.LoginReq;
import org.example.account.center.api.entity.req.ModifyUserInfoReq;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AccountController implements AccountApi {


    @Override
    public Response<AccountVo> login(LoginReq req) {
        return null;
    }

    @Override
    public Response<Boolean> isLogin() {
        return null;
    }

    @Override
    public Response<Boolean> logout() {
        return null;
    }

    @Override
    public Response<Boolean> modifyUserInfo(ModifyUserInfoReq req) {
        return null;
    }
}