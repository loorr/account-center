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

@Api(value ="权限管理")
@RequestMapping("/account/admin/permission")
public interface PermissionAdminApi {

    @ApiOperation("分页查询权限列表")
    @PostMapping(value = "/get-permission-list-page", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<AccountVo> getPermissionListPage(@Validated @RequestBody LoginReq req);

    @ApiOperation("新增权限")
    @PostMapping(value = "/add-permission", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<AccountVo> addPermission(@Validated @RequestBody LoginReq req);

    @ApiOperation("删除权限")
    @PostMapping(value = "/remove-permission", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<AccountVo> removePermission(@Validated @RequestBody LoginReq req);

    @ApiOperation("更新权限")
    @PostMapping(value = "/update-permission", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<AccountVo> updatePermission(@Validated @RequestBody LoginReq req);

}
