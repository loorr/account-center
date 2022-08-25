package org.example.account.center.api.admin;

import com.tove.web.infra.common.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.account.center.api.admin.entity.permission.PermissionTreeVo;
import org.example.account.center.api.admin.entity.permission.req.AddPermissionReq;
import org.example.account.center.api.admin.entity.permission.req.DeletePermissionReq;
import org.example.account.center.api.admin.entity.permission.req.GetPermissionListPageReq;
import org.example.account.center.api.admin.entity.permission.req.UpdatePermissionReq;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Api(value ="权限管理")
@FeignClient(value = "account-center", url = "${feign.account-center.url}")
@RequestMapping("/account/admin/permission")
public interface PermissionAdminApi {

    @ApiOperation("分页查询权限列表")
    @PostMapping(value = "/get-list-page", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<List<PermissionTreeVo>> getPermissionListPage(@Validated @RequestBody GetPermissionListPageReq req);

    @ApiOperation("新增权限")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<Boolean> addPermission(@Validated @RequestBody AddPermissionReq req);

    @ApiOperation("删除权限")
    @PostMapping(value = "/remove", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<Boolean> removePermission(@Validated @RequestBody DeletePermissionReq req);

    @ApiOperation("更新权限")
    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<Boolean> updatePermission(@Validated @RequestBody UpdatePermissionReq req);

}
