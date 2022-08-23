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
    @Select("<script>" +
            "select * from user_group " +
            "<where>" +
            "<if test='id!=null'>and id=#{id} </if>"+
            "<if test='parentId!=null'>and parent_id=#{parentId} </if>"+
            "<if test='name!=null and name!=\"\"'>and `name`=#{name} </if>"+
            "<if test='remark!=null and remark!=\"\"'>and `remark` like concat(%,#{remark},%) </if>"+
            "<if test='valid!=null'>and `valid`=#{valid} </if>"+
            "</where>" +
            "</script>")
    List<AccountGroup> getUserGroupListPage(GetUserGroupPageReq req);

    @Insert("insert into `user_group`(`parent_id`, `name`, remark, valid, tenant_id)" +
            " values(#{parentId}, #{name}, #{remark}, #{valid}, #{tenantId})")
    int addUserGroup(AddUserGroupReq req);

    @Update("update `user_group` set `valid`=0 where id=#{id} and tenant_id=#{tenantId}")
    int removeUserGroup(DeleteRoleReq req);

    @Update("<script>" +
            "update user_group " +
            "<set>" +
            "<if test='parentId!=null'>parent_id=#{parentId}, </if>"+
            "<if test='name!=null and name!=\"\"'>name=#{name}, </if>"+
            "<if test='remark!=null and remark!=\"\"'>remark=#{remark}, </if>"+
            "<if test='valid!=null'>valid=#{valid} </if>"+
            "</set>" +
            "</script>")
    int updateUserGroup(UpdateUserGroupReq req);


    @Insert("<script>" +
            "insert into user_group_role(ug_id, r_id) " +
            "<foreach collection='roleIds' item='roleId' separator=','>" +
            "values(#{ugId}, #{roleId})" +
            "</foreach>" +
            "</script>")
    int userGroupRelateRole(UserGroupRelateRoleReq req);
}
