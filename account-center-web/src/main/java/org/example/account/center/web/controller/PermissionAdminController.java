package org.example.account.center.web.controller;


import com.tove.web.infra.common.PageResult;
import com.tove.web.infra.common.Response;
import lombok.Data;
import org.example.account.center.api.admin.PermissionAdminApi;
import org.example.account.center.api.admin.entity.permission.PermissionTreeVo;
import org.example.account.center.api.admin.entity.permission.req.AddPermissionReq;
import org.example.account.center.api.admin.entity.permission.req.DeletePermissionReq;
import org.example.account.center.api.admin.entity.permission.req.GetPermissionListPageReq;
import org.example.account.center.api.admin.entity.permission.req.UpdatePermissionReq;
import org.example.account.center.web.service.admin.PermissionAdminService;

import javax.annotation.Resource;
import java.util.List;

@Data
public class PermissionAdminController implements PermissionAdminApi {

    @Resource
    private PermissionAdminService permissionAdminService;

    @Override
    public Response<List<PermissionTreeVo>> getPermissionListPage(GetPermissionListPageReq req) {
        return null;
    }

    @Override
    public Response<Boolean> addPermission(AddPermissionReq req) {
        return null;
    }

    @Override
    public Response<Boolean> removePermission(DeletePermissionReq req) {
        return null;
    }

    @Override
    public Response<Boolean> updatePermission(UpdatePermissionReq req) {
        return null;
    }
}
