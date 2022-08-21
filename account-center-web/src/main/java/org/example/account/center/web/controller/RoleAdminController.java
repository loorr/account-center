package org.example.account.center.web.controller;

import com.tove.web.infra.common.PageResult;
import com.tove.web.infra.common.Response;
import org.example.account.center.api.admin.RoleAdminApi;
import org.example.account.center.api.admin.entity.role.RoleTreeVo;
import org.example.account.center.api.admin.entity.role.req.*;
import org.example.account.center.web.service.TenantService;
import org.example.account.center.web.service.admin.RoleAdminService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RoleAdminController implements RoleAdminApi {

    @Resource
    private RoleAdminService roleAdminService;

    @Resource
    private TenantService tenantService;


    @Override
    public Response<List<RoleTreeVo>> getRoleListPage(GetRoleListPageReq req, String tenantCode) {
        // 从数据库 通过 tenantCode 查询到底是哪一个租户
        Long tenantId = tenantService.getTenantId(tenantCode);
        req.setTenantId(tenantId);
        List<RoleTreeVo> result = roleAdminService.getRoleListPage(req);
        return Response.getOk(result);
    }

    @Override
    public Response<Boolean> addRole(AddRoleReq req, String tenantCode) {
        return null;
    }

    @Override
    public Response<Boolean> removeRole(DeleteRoleReq req, String tenantCode) {
        return null;
    }

    @Override
    public Response<Boolean> updateRole(UpdateRoleReq req, String tenantCode) {
        return null;
    }

    @Override
    public Response<Boolean> roleRelatePermission(RoleRelatePermissionReq req, String tenantCode) {
        return null;
    }
}
