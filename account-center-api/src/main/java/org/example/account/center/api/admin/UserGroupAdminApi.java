package org.example.account.center.api.admin;

import com.tove.web.infra.common.PageResult;
import com.tove.web.infra.common.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.account.center.api.admin.entity.role.req.DeleteRoleReq;
import org.example.account.center.api.admin.entity.usergroup.UserGroupTreeVo;
import org.example.account.center.api.admin.entity.usergroup.req.AddUserGroupReq;
import org.example.account.center.api.admin.entity.usergroup.req.GetUserGroupPageReq;
import org.example.account.center.api.admin.entity.usergroup.req.UpdateUserGroupReq;
import org.example.account.center.api.entity.AccountVo;
import org.example.account.center.api.entity.req.LoginReq;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value ="用户组管理")
@FeignClient(value = "account-center", url = "${feign.account-center.url}")
@RequestMapping("/account/admin/user-group")
public interface UserGroupAdminApi {

    @ApiOperation("分页查询用户组列表")
    @PostMapping(value = "/get-user-group-list-page", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<PageResult<UserGroupTreeVo>> getUserGroupListPage(@Validated @RequestBody GetUserGroupPageReq req);

    @ApiOperation("新增用户组")
    @PostMapping(value = "/add-user-group", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<Boolean> addUserGroup(@Validated @RequestBody AddUserGroupReq req);

    @ApiOperation("删除用户组")
    @PostMapping(value = "/remove-user-group", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<Boolean> removeUserGroup(@Validated @RequestBody DeleteRoleReq req);

    @ApiOperation("更新用户组")
    @PostMapping(value = "/update-user-group", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<Boolean> updateUserGroup(@Validated @RequestBody UpdateUserGroupReq req);

}
