package org.example.account.center.api.admin;

import com.tove.web.infra.common.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.account.center.api.admin.entity.user.req.GetUserPageListReq;
import org.example.account.center.api.entity.AccountVo;
import org.example.account.center.api.entity.req.LoginReq;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value ="账户管理")
@RequestMapping("/account/admin/user")
public interface UserAdminApi {

    @ApiOperation("重置密码")
    @PostMapping(value = "/reset-password", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<AccountVo> resetPassword(@Validated @RequestBody LoginReq req);

    @ApiOperation("新建用户")
    @PostMapping(value = "/add-user", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<AccountVo> addUser(@Validated @RequestBody LoginReq req);

    @ApiOperation("删除用户")
    @PostMapping(value = "/remove-user", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<AccountVo> removeUser(@Validated @RequestBody LoginReq req);

    @ApiOperation("分页查询用户")
    @PostMapping(value = "/get-user-list-page", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<AccountVo> getUserListPage(@Validated @RequestBody GetUserPageListReq req);
}
