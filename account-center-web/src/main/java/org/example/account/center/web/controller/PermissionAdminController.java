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

@Data
public class PermissionAdminController implements PermissionAdminApi {

    @Override
    public Response<PageResult<PermissionTreeVo>> getPermissionListPage(GetPermissionListPageReq req) {
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
