package org.example.account.center.web.controller;

import com.tove.web.infra.common.Response;
import org.example.account.center.api.admin.RoleAdminApi;
import org.example.account.center.api.admin.entity.role.RoleTreeVo;
import org.example.account.center.api.admin.entity.role.req.*;
import org.example.account.center.web.common.BaseController;
import org.example.account.center.web.service.admin.RoleAdminService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RoleAdminController extends BaseController implements RoleAdminApi {

    @Resource
    private RoleAdminService roleAdminService;


    @Override
    public Response<List<RoleTreeVo>> getRoleListPage(GetRoleListPageReq req) {
        req.setTenantId(getTenantId());
        List<RoleTreeVo> result = roleAdminService.getRoleListPage(req);
        return Response.getOk(result);
    }

    @Override
    public Response<Boolean> addRole(AddRoleReq req) {
        Boolean result =  roleAdminService.addRole(req);
        return Response.getOk(result);
    }

    @Override
    public Response<Boolean> removeRole(DeleteRoleReq req) {
        Boolean result = roleAdminService.removeRole(req);
        return Response.getOk(result);
    }

    @Override
    public Response<Boolean> updateRole(UpdateRoleReq req) {
        Boolean result = roleAdminService.updateRole(req);
        return Response.getOk(result);
    }

    @Override
    public Response<Boolean> roleRelatePermission(RoleRelatePermissionReq req) {
        Boolean result = roleAdminService.roleRelatePermission(req);
        return Response.getOk(result);
    }
}
