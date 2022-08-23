package org.example.account.center.web.dao.admin;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.account.center.api.admin.entity.role.req.DeleteRoleReq;
import org.example.account.center.api.admin.entity.usergroup.UserGroupTreeVo;
import org.example.account.center.api.admin.entity.usergroup.req.AddUserGroupReq;
import org.example.account.center.api.admin.entity.usergroup.req.GetUserGroupPageReq;
import org.example.account.center.api.admin.entity.usergroup.req.UpdateUserGroupReq;
import org.example.account.center.api.admin.entity.usergroup.req.UserGroupRelateRoleReq;
import org.example.account.center.web.model.AccountGroup;

import java.util.List;

@Mapper
public interface UserGroupMapper {


    @Select("<script></script>")
    List<AccountGroup> getUserGroupListPage(GetUserGroupPageReq req);

    @Insert("")
    int addUserGroup(AddUserGroupReq req);

    @Update("")
    int removeUserGroup(DeleteRoleReq req);

    @Update("<script></script>")
    int updateUserGroup(UpdateUserGroupReq req);


    @Insert("<script></script>")
    int userGroupRelateRole(UserGroupRelateRoleReq req);
}
