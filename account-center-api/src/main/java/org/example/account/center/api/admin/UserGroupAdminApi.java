package org.example.account.center.api.admin;

import com.tove.web.infra.common.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.account.center.api.entity.AccountVo;
import org.example.account.center.api.entity.req.LoginReq;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value ="用户组管理")
@RequestMapping("/account/admin/user-group")
public interface UserGroupAdminApi {

    @ApiOperation("分页查询用户组列表")
    @PostMapping(value = "/get-user-group-list-page", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<AccountVo> getUserGroupListPage(@Validated @RequestBody LoginReq req);

    @ApiOperation("新增用户组")
    @PostMapping(value = "/add-user-group", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<AccountVo> addUserGroup(@Validated @RequestBody LoginReq req);

    @ApiOperation("删除用户组")
    @PostMapping(value = "/remove-user-group", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<AccountVo> removeUserGroup(@Validated @RequestBody LoginReq req);

    @ApiOperation("更新用户组")
    @PostMapping(value = "/update-user-group", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<AccountVo> updateUserGroup(@Validated @RequestBody LoginReq req);

}
