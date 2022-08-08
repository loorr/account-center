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

@Api(value ="角色管理")
@RequestMapping("/account/admin/role")
public interface RoleAdminApi {

    @ApiOperation("分页查询角色列表")
    @PostMapping(value = "/get-role-list-page", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<AccountVo> getRoleListPage(@Validated @RequestBody LoginReq req);

    @ApiOperation("新增角色")
    @PostMapping(value = "/add-role", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<AccountVo> addRole(@Validated @RequestBody LoginReq req);

    @ApiOperation("删除角色")
    @PostMapping(value = "/remove-role", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<AccountVo> removeRole(@Validated @RequestBody LoginReq req);

    @ApiOperation("更新角色")
    @PostMapping(value = "/update-role", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<AccountVo> updateRole(@Validated @RequestBody LoginReq req);

}
