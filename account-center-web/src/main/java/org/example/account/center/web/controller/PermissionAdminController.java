package org.example.account.center.web.controller;

import com.tove.web.infra.common.Response;
import org.example.account.center.api.admin.PermissionAdminApi;
import org.example.account.center.api.admin.entity.permission.PermissionTreeVo;
import org.example.account.center.api.admin.entity.permission.req.AddPermissionReq;
import org.example.account.center.api.admin.entity.permission.req.DeletePermissionReq;
import org.example.account.center.api.admin.entity.permission.req.GetPermissionListPageReq;
import org.example.account.center.api.admin.entity.permission.req.UpdatePermissionReq;
import org.example.account.center.web.common.BaseController;
import org.example.account.center.web.service.admin.PermissionAdminService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class PermissionAdminController extends BaseController implements PermissionAdminApi {

    @Resource
    private PermissionAdminService permissionAdminService;

    @Override
    public Response<List<PermissionTreeVo>> getPermissionListPage(GetPermissionListPageReq req) {
        req.setTenantId(getTenantId());
        List<PermissionTreeVo> result = permissionAdminService.getPermissionListPage(req);
        return Response.getOk(result);
    }

    @Override
    public Response<Boolean> addPermission(AddPermissionReq req) {
        req.setTenantId(getTenantId());
        Boolean result = permissionAdminService.addPermission(req);
        return Response.getOk(result);
    }

    @Override
    public Response<Boolean> removePermission(DeletePermissionReq req) {
        req.setTenantId(getTenantId());
        Boolean result = permissionAdminService.removePermission(req);
        return Response.getOk(result);
    }

    @Override
    public Response<Boolean> updatePermission(UpdatePermissionReq req) {
        req.setTenantId(getTenantId());
        Boolean result = permissionAdminService.updatePermission(req);
        return Response.getOk(result);
    }
}
