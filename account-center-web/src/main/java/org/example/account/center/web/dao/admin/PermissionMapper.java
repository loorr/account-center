package org.example.account.center.web.dao.admin;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.account.center.api.admin.entity.permission.PermissionTreeVo;
import org.example.account.center.api.admin.entity.permission.req.AddPermissionReq;
import org.example.account.center.api.admin.entity.permission.req.DeletePermissionReq;
import org.example.account.center.api.admin.entity.permission.req.GetPermissionListPageReq;
import org.example.account.center.api.admin.entity.permission.req.UpdatePermissionReq;
import org.example.account.center.web.model.Permission;

import java.util.List;

@Mapper
public interface PermissionMapper {

    @Select("select * from permission")
    List<Permission> getPermissionListPage(GetPermissionListPageReq req);


    @Insert("")
    int addPermission(AddPermissionReq req);


    @Update("")
    int removePermission(DeletePermissionReq req);


    @Update("")
    int updatePermission(UpdatePermissionReq req);
}
