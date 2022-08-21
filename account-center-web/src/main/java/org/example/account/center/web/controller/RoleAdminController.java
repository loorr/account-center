package org.example.account.center.web.controller;

import com.alibaba.fastjson.JSON;
import com.tove.web.infra.common.PageResult;
import com.tove.web.infra.common.Response;
import org.example.account.center.api.admin.RoleAdminApi;
import org.example.account.center.api.admin.entity.role.RoleTreeVo;
import org.example.account.center.api.admin.entity.role.req.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleAdminController implements RoleAdminApi {
    @Override
    public Response<PageResult<RoleTreeVo>> getRoleListPage(GetRoleListPageReq req) {
        System.out.printf("req: %s\n", JSON.toJSONString(req));
        return null;
    }

    @Override
    public Response<Boolean> addRole(AddRoleReq req) {
        return null;
    }

    @Override
    public Response<Boolean> removeRole(DeleteRoleReq req) {
        return null;
    }

    @Override
    public Response<Boolean> updateRole(UpdateRoleReq req) {
        return null;
    }

    @Override
    public Response<Boolean> roleRelatePermission(RoleRelatePermissionReq req) {
        return null;
    }
}
