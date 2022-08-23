package org.example.account.center.web.controller;

import com.tove.web.infra.common.Response;
import org.example.account.center.api.admin.PermissionAdminApi;
import org.example.account.center.api.admin.entity.permission.PermissionTreeVo;
import org.example.account.center.api.admin.entity.permission.req.AddPermissionReq;
import org.example.account.center.api.admin.entity.permission.req.DeletePermissionReq;
import org.example.account.center.api.admin.entity.permission.req.GetPermissionListPageReq;
import org.example.account.center.api.admin.entity.permission.req.UpdatePermissionReq;
import org.example.account.center.web.service.admin.PermissionAdminService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class PermissionAdminController implements PermissionAdminApi {

    @Resource
    private PermissionAdminService permissionAdminService;

    @Override
    public Response<List<PermissionTreeVo>> getPermissionListPage(GetPermissionListPageReq req) {
        List<PermissionTreeVo> result = permissionAdminService.getPermissionListPage(req);
        return Response.getOk(result);
    }

    @Override
    public Response<Boolean> addPermission(AddPermissionReq req) {
        Boolean result = permissionAdminService.addPermission(req);
        return Response.getOk(result);
    }

    @Override
    public Response<Boolean> removePermission(DeletePermissionReq req) {
        Boolean result = permissionAdminService.removePermission(req);
        return Response.getOk(result);
    }

    @Override
    public Response<Boolean> updatePermission(UpdatePermissionReq req) {
        Boolean result = permissionAdminService.updatePermission(req);
        return Response.getOk(result);
    }
}
