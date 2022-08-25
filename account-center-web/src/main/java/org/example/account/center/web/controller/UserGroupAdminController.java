package org.example.account.center.web.controller;

import com.tove.web.infra.common.PageResult;
import com.tove.web.infra.common.Response;
import org.example.account.center.api.admin.UserGroupAdminApi;
import org.example.account.center.api.admin.entity.role.req.DeleteRoleReq;
import org.example.account.center.api.admin.entity.usergroup.UserGroupTreeVo;
import org.example.account.center.api.admin.entity.usergroup.req.AddUserGroupReq;
import org.example.account.center.api.admin.entity.usergroup.req.GetUserGroupPageReq;
import org.example.account.center.api.admin.entity.usergroup.req.UpdateUserGroupReq;
import org.example.account.center.api.admin.entity.usergroup.req.UserGroupRelateRoleReq;
import org.example.account.center.web.common.BaseController;
import org.example.account.center.web.service.admin.UserGroupService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserGroupAdminController extends BaseController implements UserGroupAdminApi {

    @Resource
    private UserGroupService userGroupService;

    @Override
    public Response<List<UserGroupTreeVo>> getUserGroupListPage(GetUserGroupPageReq req) {
        req.setTenantId(getTenantId());
        List<UserGroupTreeVo> result = userGroupService.getUserGroupListPage(req);
        return Response.getOk(result);
    }

    @Override
    public Response<Boolean> addUserGroup(AddUserGroupReq req) {
        req.setTenantId(getTenantId());
        Boolean result = userGroupService.addUserGroup(req);
        return Response.getOk(result);
    }

    @Override
    public Response<Boolean> removeUserGroup(DeleteRoleReq req) {
        req.setTenantId(getTenantId());
        Boolean result = userGroupService.removeUserGroup(req);
        return Response.getOk(result);
    }

    @Override
    public Response<Boolean> updateUserGroup(UpdateUserGroupReq req) {
        req.setTenantId(getTenantId());
        Boolean result = userGroupService.updateUserGroup(req);
        return Response.getOk(result);
    }

    @Override
    public Response<Boolean> userGroupRelateRole(UserGroupRelateRoleReq req) {
        req.setTenantId(getTenantId());
        Boolean result = userGroupService.userGroupRelateRole(req);
        return Response.getOk(result);
    }
}
