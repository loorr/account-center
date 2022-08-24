package org.example.account.center.web.service.admin;

import com.tove.web.infra.common.BaseException;
import org.example.account.center.api.admin.entity.role.req.DeleteRoleReq;
import org.example.account.center.api.admin.entity.usergroup.UserGroupTreeVo;
import org.example.account.center.api.admin.entity.usergroup.req.AddUserGroupReq;
import org.example.account.center.api.admin.entity.usergroup.req.GetUserGroupPageReq;
import org.example.account.center.api.admin.entity.usergroup.req.UpdateUserGroupReq;
import org.example.account.center.api.admin.entity.usergroup.req.UserGroupRelateRoleReq;
import org.example.account.center.api.common.AccountErrorCode;
import org.example.account.center.web.dao.admin.UserGroupMapper;
import org.example.account.center.web.model.AccountGroup;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserGroupService {

    @Resource
    private UserGroupMapper userGroupMapper;

    public List<UserGroupTreeVo> getUserGroupListPage(GetUserGroupPageReq req) {
        List<AccountGroup> list = userGroupMapper.getUserGroupListPage(req);
        Map<Long, UserGroupTreeVo> map = list.stream().map(e -> {
            UserGroupTreeVo vo = new UserGroupTreeVo();
            BeanUtils.copyProperties(e, vo);
            return vo;
        }).collect(Collectors.toMap(UserGroupTreeVo::getId, e -> e));
        for (UserGroupTreeVo userGroupTreeVo : map.values()) {
            if (userGroupTreeVo.getParentId() != null) {
                map.get(userGroupTreeVo.getParentId()).getChildren().add(userGroupTreeVo);
            }
        }
        return map.values().stream().filter(e -> e.getParentId() == null).collect(Collectors.toList());
    }

    public Boolean addUserGroup(AddUserGroupReq req) {
        try {
            userGroupMapper.addUserGroup(req);
            return true;
        } catch (DuplicateKeyException e) {
            throw new BaseException(AccountErrorCode.DUPLICATE_KEY);
        }
    }


    public Boolean removeUserGroup(DeleteRoleReq req) {
        try {
            userGroupMapper.removeUserGroup(req);
            return true;
        } catch (DuplicateKeyException e) {
            throw new BaseException(AccountErrorCode.DUPLICATE_KEY);
        }
    }


    public Boolean updateUserGroup(UpdateUserGroupReq req) {
        try {
            userGroupMapper.updateUserGroup(req);
            return true;
        } catch (DuplicateKeyException e) {
            throw new BaseException(AccountErrorCode.DUPLICATE_KEY);
        }
    }


    public Boolean userGroupRelateRole(UserGroupRelateRoleReq req) {
        try {
            userGroupMapper.userGroupRelateRole(req);
            return true;
        } catch (DuplicateKeyException e) {
            throw new BaseException(AccountErrorCode.DUPLICATE_KEY);
        }
    }

}
