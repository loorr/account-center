package org.example.account.center.web.dao.admin;

import org.apache.ibatis.annotations.*;
import org.example.account.center.api.admin.entity.role.req.GetRoleListPageReq;
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
    @Results(id="groupWithUsers",value = {
        @Result(property = "parentId", column = " parent_id"),
    })
    List<Role> getRole(GetRoleListPageReq req);
}
