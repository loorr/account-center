package org.example.account.center.web.controller;

import com.tove.web.infra.common.PageResult;
import com.tove.web.infra.common.Response;
import lombok.extern.slf4j.Slf4j;
import org.example.account.center.api.admin.UserAdminApi;
import org.example.account.center.api.admin.entity.user.req.*;
import org.example.account.center.api.entity.AccountVo;
import org.example.account.center.web.common.BaseController;
import org.example.account.center.web.service.admin.UserAdminService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class UserAdminController extends BaseController implements UserAdminApi {

    @Resource
    private UserAdminService userAdminService;

    @Override
    public Response<Boolean> resetPassword(ResetPasswordReq req) {
        req.setTenantId(getTenantId());
        Boolean result = userAdminService.resetPassword(req);
        return Response.getOk(result);
    }

    @Override
    public Response<Boolean> updateUser(UpdateUserReq req) {
        Boolean result = userAdminService.updateUser(req);
        return Response.getOk(result);
    }

    @Override
    public Response<Boolean> addUser(AddUserReq req) {
        Boolean result = userAdminService.addUser(req);
        return Response.getOk(result);
    }

    @Override
    public Response<Boolean> removeUser(RemoveUserReq req) {
        Boolean result = userAdminService.removeUser(req);
        return Response.getOk(result);
    }

    @Override
    public Response<PageResult<AccountVo>> getUserListPage(GetUserPageListReq req) {
        PageResult<AccountVo> result = userAdminService.getUserListPage(req);
        return Response.getOk(result);
    }

    @Override
    public Response<Boolean> accountRelateUserGroup(AccountRelateUserGroupReq req) {
        return null;
    }
}
