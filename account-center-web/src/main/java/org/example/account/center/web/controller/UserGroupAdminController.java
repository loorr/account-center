package org.example.account.center.web.controller;

import com.tove.web.infra.common.PageResult;
import com.tove.web.infra.common.Response;
import org.example.account.center.api.admin.UserGroupAdminApi;
import org.example.account.center.api.admin.entity.role.req.DeleteRoleReq;
import org.example.account.center.api.admin.entity.usergroup.UserGroupTreeVo;
import org.example.account.center.api.admin.entity.usergroup.req.AddUserGroupReq;
import org.example.account.center.api.admin.entity.usergroup.req.GetUserGroupPageReq;
import org.example.account.center.api.admin.entity.usergroup.req.UpdateUserGroupReq;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserGroupAdminController implements UserGroupAdminApi {


    @Override
    public Response<PageResult<UserGroupTreeVo>> getUserGroupListPage(GetUserGroupPageReq req) {
        return null;
    }

    @Override
    public Response<Boolean> addUserGroup(AddUserGroupReq req) {
        return null;
    }

    @Override
    public Response<Boolean> removeUserGroup(DeleteRoleReq req) {
        return null;
    }

    @Override
    public Response<Boolean> updateUserGroup(UpdateUserGroupReq req) {
        return null;
    }
}
