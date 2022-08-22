package org.example.account.center.api.admin;

import com.tove.web.infra.common.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.account.center.api.admin.entity.role.RoleTreeVo;
import org.example.account.center.api.admin.entity.role.req.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Api(value ="角色管理")
@FeignClient(value = "account-center", url = "${feign.account-center.url}")
@RequestMapping("/account/admin/role")
public interface RoleAdminApi {

    @ApiOperation("查询角色列表")
    @PostMapping(value = "/get-list-page", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<List<RoleTreeVo>> getRoleListPage(@Validated @RequestBody GetRoleListPageReq req);

    @ApiOperation("新增角色")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<Boolean> addRole(@Validated @RequestBody AddRoleReq req);

    @ApiOperation("删除角色")
    @PostMapping(value = "/remove", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<Boolean> removeRole(@Validated @RequestBody DeleteRoleReq req);

    @ApiOperation("更新角色")
    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<Boolean> updateRole(@Validated @RequestBody UpdateRoleReq req);

    @ApiOperation("角色关联资源")
    @PostMapping(value = "/role-relate-rermission", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<Boolean> roleRelatePermission(@Validated @RequestBody RoleRelatePermissionReq req );

}
