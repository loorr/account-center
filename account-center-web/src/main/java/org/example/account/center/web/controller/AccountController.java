package org.example.account.center.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.tove.web.infra.common.Response;
import lombok.extern.slf4j.Slf4j;
import org.example.account.center.api.AccountApi;
import org.example.account.center.api.entity.AccountVo;
import org.example.account.center.api.entity.req.LoginReq;
import org.example.account.center.api.entity.req.ModifyUserInfoReq;
import org.example.account.center.web.service.AccountService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class AccountController implements AccountApi {

    @Resource
    private AccountService accountService;
    @Override
    public Response<AccountVo> login(LoginReq req) {
        System.out.printf("login: %s\n", JSON.toJSONString(req));
        AccountVo result = accountService.login(req);
        return Response.getOk(result);
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
