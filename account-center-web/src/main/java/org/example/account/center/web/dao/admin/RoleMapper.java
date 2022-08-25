package org.example.account.center.web.dao.admin;

import org.apache.ibatis.annotations.*;
import org.example.account.center.api.admin.entity.role.req.*;
import org.example.account.center.web.model.Role;

import java.util.List;

@Mapper
public interface RoleMapper {
    @Select("<script>" +
            "select * from role " +
            "<where>" +
            "tenant_id= #{tenantId}" +
            "<if test='id!=null'> and id = #{id} </if>"+
            "<if test='parentId!=null'> and parent_id = #{parentId} </if>"+
            "<if test='name!=null and name!=\"\"'> and name like concat('%', #{name}, ‘%’) </if>"+
            "<if test='remark!=null and remark!=\"\"'> and remark like concat('%', #{remark}, ‘%’) </if>"+
            "<if test='valid!=null'> and valid = #{valid} </if>"+
            "</where>" +
            "</script>")
    @Results(id="getRole",value = {
        @Result(property = "parentId", column = "parent_id"),
    })
    List<Role> getRole(GetRoleListPageReq req);

    @Insert("insert into role(tenant_id, parent_id, name, remark, valid) values(#{tenantId}, #{parentId}, #{name}, #{remark}, #{valid})")
    int addRole(AddRoleReq req);

    @Update("update role set valid = 0 where id = #{id} and tenant_id = #{tenantId}")
    int removeRole(DeleteRoleReq req);

    @Update("<script>" +
            "update role " +
            "<set> " +
            "<if test='parentId!=null'>parent_id=#{parentId}, </if>"+
            "<if test='name!=null and name!=\"\"'>name=#{name}, </if>"+
            "<if test='remark!=null and remark!=\"\"'>remark=#{remark}, </if>"+
            "<if test='valid!=null'>valid = #{valid} </if>"+
            "</set>"+
            " where id = #{id} and tenant_id = #{tenantId}"+
            "</script>")
    int updateRole(UpdateRoleReq req);

    @Insert("<script>" +
            "insert into relate_role_permission(r_id, p_id) values " +
            "<foreach collection='permissionIds' item='permissionId' separator=','>" +
            "(#{roleId}, #{permissionId})" +
            "</foreach>" +
            "</script>")
    int batchInsertRolePermission(RoleRelatePermissionReq req);


}
