package org.example.account.center.api;


import com.tove.web.infra.common.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.account.center.api.entity.AccountVo;
import org.example.account.center.api.entity.req.LoginReq;
import org.example.account.center.api.entity.req.ModifyUserInfoReq;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "账户")
@FeignClient(value = "account-center", url = "${feign.account-center.url}")
@RequestMapping("/account")
public interface AccountApi {
    @ApiOperation("登陆接口")
    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<AccountVo> login(@Validated @RequestBody LoginReq req);

    @ApiOperation("是否登陆")
    @GetMapping(value = "/is-login", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<Boolean> isLogin();

    @ApiOperation("登出")
    @GetMapping(value = "/login-out", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<Boolean> logout();

    @ApiOperation("修改密码")
    @PostMapping(value = "/modify-user-info", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<Boolean> modifyUserInfo(@Validated @RequestBody ModifyUserInfoReq req);

}
