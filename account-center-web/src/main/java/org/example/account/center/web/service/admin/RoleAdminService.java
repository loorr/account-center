package org.example.account.center.web.service.admin;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tove.web.infra.common.PageResult;
import com.tove.web.infra.common.Response;
import org.example.account.center.api.admin.entity.role.RoleTreeVo;
import org.example.account.center.api.admin.entity.role.req.*;
import org.example.account.center.web.dao.admin.RoleMapper;
import org.example.account.center.web.model.Role;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RoleAdminService {

    @Resource
    private RoleMapper roleMapper;

    public List<RoleTreeVo> getRoleListPage(GetRoleListPageReq req) {
        // 从数据库 通过 tenantCode 查询到底是哪一个租户
        List<Role> list = roleMapper.getRole(req);
        Map<Long, RoleTreeVo> roleMap = list.stream().map(
                r -> {
                    RoleTreeVo roleTreeVo = new RoleTreeVo();
                    BeanUtils.copyProperties(r, roleTreeVo);
                    roleTreeVo.setChildren(new HashSet<>());
                    return roleTreeVo;
                }
        ).collect(Collectors.toMap(RoleTreeVo::getId, r -> r));

        for (RoleTreeVo roleTreeVo : roleMap.values()) {
            if (roleTreeVo.getParentId() != null) {
                roleMap.get(roleTreeVo.getParentId()).getChildren().add(roleTreeVo);
            }
        }
        return roleMap.values().stream().filter(r -> r.getParentId() == null).collect(Collectors.toList());
    }


    public Boolean addRole(AddRoleReq req) {
        return null;
    }


    public Boolean removeRole(DeleteRoleReq req) {
        return null;
    }


    public Boolean updateRole(UpdateRoleReq req) {
        return null;
    }


    public Boolean roleRelatePermission(RoleRelatePermissionReq req) {
        return null;
    }
}
