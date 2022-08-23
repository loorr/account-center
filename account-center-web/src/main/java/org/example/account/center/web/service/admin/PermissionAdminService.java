package org.example.account.center.web.service.admin;

import com.tove.web.infra.common.BaseException;
import org.example.account.center.api.admin.entity.permission.PermissionTreeVo;
import org.example.account.center.api.admin.entity.permission.req.AddPermissionReq;
import org.example.account.center.api.admin.entity.permission.req.DeletePermissionReq;
import org.example.account.center.api.admin.entity.permission.req.GetPermissionListPageReq;
import org.example.account.center.api.admin.entity.permission.req.UpdatePermissionReq;
import org.example.account.center.web.common.AccountErrorCode;
import org.example.account.center.web.dao.admin.PermissionMapper;
import org.example.account.center.web.model.Permission;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PermissionAdminService {

    @Resource
    private PermissionMapper permissionMapper;

    public List<PermissionTreeVo> getPermissionListPage(GetPermissionListPageReq req) {
        List<Permission> list = permissionMapper.getPermissionListPage(req);
        Map<Long, PermissionTreeVo> map = list.stream().map(e -> {
            PermissionTreeVo vo = new PermissionTreeVo();
            BeanUtils.copyProperties(e, vo);
            return vo;
        }).collect(Collectors.toMap(PermissionTreeVo::getId, e -> e));
        for (PermissionTreeVo permissionTreeVo : map.values()) {
            if (permissionTreeVo.getParentId() != null) {
                map.get(permissionTreeVo.getParentId()).getChildren().add(permissionTreeVo);
            }
        }
        return map.values().stream().filter(e -> e.getParentId() == null).collect(Collectors.toList());
    }


    public Boolean addPermission(AddPermissionReq req) {
        try {
            permissionMapper.addPermission(req);
            return true;
        } catch (DuplicateKeyException e) {
            throw new BaseException(AccountErrorCode.DUPLICATE_KEY);
        }
    }


    public Boolean removePermission(DeletePermissionReq req) {
        try {
            permissionMapper.removePermission(req);
            return true;
        } catch (DuplicateKeyException e) {
            throw new BaseException(AccountErrorCode.DUPLICATE_KEY);
        }
    }


    public Boolean updatePermission(UpdatePermissionReq req) {
        try {
            permissionMapper.updatePermission(req);
            return true;
        } catch (DuplicateKeyException e) {
            throw new BaseException(AccountErrorCode.DUPLICATE_KEY);
        }
    }
}
