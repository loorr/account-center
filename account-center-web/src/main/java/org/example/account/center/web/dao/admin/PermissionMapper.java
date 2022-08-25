package org.example.account.center.web.dao.admin;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.account.center.api.admin.entity.permission.req.AddPermissionReq;
import org.example.account.center.api.admin.entity.permission.req.DeletePermissionReq;
import org.example.account.center.api.admin.entity.permission.req.GetPermissionListPageReq;
import org.example.account.center.api.admin.entity.permission.req.UpdatePermissionReq;
import org.example.account.center.web.model.Permission;

import java.util.List;

@Mapper
public interface PermissionMapper {

    @Select("<script>" +
            "select * from `permission` " +
            "<where>" +
            "tenant_id = #{tenantId} " +
            "<if test='id!=null'>and id=#{id} </if>"+
            "<if test='parentId!=null'>and parent_id=#{parentId} </if>"+
            "<if test='name!=null and name!=\"\"'>and `name`=#{name} </if>"+
            "<if test='code!=null and code!=\"\"'>and `code`=#{code} </if>"+
            "<if test='url!=null and url!=\"\"'>and `url`=#{url} </if>"+
            "<if test='type!=null and type!=\"\"'>and `type`=#{type} </if>"+
            "<if test='remark!=null and remark!=\"\"'>and `remark` like concat(%,#{remark},%) </if>"+
            "<if test='valid!=null'>and `valid`=#{valid} </if>"+
            "</where>" +
            "</script>")
    List<Permission> getPermissionListPage(GetPermissionListPageReq req);


    @Insert("insert into `permission`(`parent_id`, `name`,`code`,`url`,`type`,`remark`,`valid`,`tenant_id`) " +
            "values(#{parentId}, #{name},#{code},#{url},#{type},#{remark},#{valid},#{tenantId})")
    int addPermission(AddPermissionReq req);


    @Update("update `permission set `vaild` = 0 where id = #{id} and tenant_id = #{tenantId}")
    int removePermission(DeletePermissionReq req);


    @Update("<script>" +
            "update permission " +
            "<set>" +
            "<if test='id!=null'>id=#{id} </if>"+
            "<if test='parentId!=null'>,parent_id=#{parentId} </if>"+
            "<if test='name!=null and name!=\"\"'>,`name`=#{name} </if>"+
            "<if test='code!=null and code!=\"\"'>,`code`=#{code} </if>"+
            "<if test='url!=null and url!=\"\"'  >,`url`=#{url} </if>"+
            "<if test='type!=null and type!=\"\"'>,`type`=#{type} </if>"+
            "<if test='remark!=null and remark!=\"\"'>,`remark`=#{remark} </if>"+
            "<if test='valid!=null'>,`valid`=#{valid} </if>"+
            "</set> " +
            "where id = #{id} and tenant_id = #{tenantId}" +
            "</script>")
    int updatePermission(UpdatePermissionReq req);
}
