package org.example.account.center.web.service.impl;


import com.tove.web.infra.common.BaseException;
import org.example.account.center.api.entity.AccountVo;
import org.example.account.center.api.entity.RoleItem;
import org.example.account.center.api.entity.UserGroupItem;
import org.example.account.center.api.entity.req.GetAccountInfoReq;
import org.example.account.center.api.entity.req.LoginReq;
import org.example.account.center.api.entity.req.ModifyUserInfoReq;
import org.example.account.center.api.common.AccountErrorCode;
import org.example.account.center.web.dao.AccountMapper;
import org.example.account.center.web.model.Account;
import org.example.account.center.web.model.AccountGroup;
import org.example.account.center.web.model.Permission;
import org.example.account.center.web.model.Role;
import org.example.account.center.web.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public AccountVo login(LoginReq req) {
        Account account = accountMapper.getAccountByEmail(req.getEmail(), req.getTenantId());
        if (account == null) {
            throw new BaseException(AccountErrorCode.ACCOUNT_OR_PASSWORD_ERROR);
        }
        // 暂时是明文
        if (!account.getPassword().equals(req.getPassword())) {
            throw new BaseException(AccountErrorCode.ACCOUNT_OR_PASSWORD_ERROR);
        }
        return getAccountInfo(account.getUid(), req.getTenantId());
    }

    private AccountVo getAccountInfo(Long uid, Long tenantId) {
        AccountVo result = new AccountVo();
        Account account = accountMapper.getAccountByUid(uid, tenantId);
        if (account == null){
            throw new BaseException(AccountErrorCode.USER_NOT_EXIST);
        }
        result.setEmail(account.getEmail());
        result.setUid(account.getUid());
        result.setNickname(account.getNickname());
        result.setUsername(account.getUsername());
        result = fillPermission(result, tenantId);
        return result;
    }

    private AccountVo fillPermission(AccountVo accountVo, Long tenantId) {
        Long uid = accountVo.getUid();
        List<Role> defaultRoles = getDefaultRoles(uid, tenantId);
        List<String> defaultRoleCodes = defaultRoles.stream().map(Role::getName).collect(Collectors.toList());
        List<Long> defaultRoleIds = defaultRoles.stream().map(Role::getId).collect(Collectors.toList());
        List<Permission> defaultPermissions = getPermissionByRoleIds(defaultRoleIds, tenantId);
        List<String> defaultPermissionCodes = defaultPermissions.stream().map(Permission::getCode).collect(Collectors.toList());
        accountVo.setDefaultRoles(defaultRoleCodes);
        accountVo.setDefaultPermissions(defaultPermissionCodes);

        List<UserGroupItem> userGroups = new ArrayList<>();
        List<AccountGroup> accountGroups = getAccountGroups(uid, tenantId);
        for(AccountGroup groupItem : accountGroups) {
            UserGroupItem userGroupItem = new UserGroupItem();
            userGroupItem.setName(groupItem.getName());
            List<Role> roles = getRolesByAccountGroup(Collections.singletonList(groupItem.getId()), tenantId);
            userGroupItem.setRoles(roles.stream().map(Role::getName).collect(Collectors.toList()));
            List<Permission> permissions = getPermissionByRoleIds(roles.stream().map(Role::getId).collect(Collectors.toList()), tenantId);
            userGroupItem.setPermissions(permissions.stream().map(Permission::getCode).collect(Collectors.toList()));
            userGroups.add(userGroupItem);
        }

        return accountVo;
    }

    private List<Role> getDefaultRoles(Long uid, Long tenantId) {
        List<Role> roles = accountMapper.getUserDefaultRoles(uid, tenantId, null);
        Map<Long, Role> roleMap = roles.stream().collect(Collectors.toMap(Role::getId, role -> role, (k1, k2) -> k1));

        List<Long> rootIds = roles.stream().filter(role -> role.getParentId() == null).map(Role::getId).collect(Collectors.toList());
        int i = 0;
        while (!CollectionUtils.isEmpty(rootIds) && i < 10){
            roles = accountMapper.getRoleByParentId(rootIds, tenantId);
            roleMap.putAll(roles.stream().collect(Collectors.toMap(Role::getId, role -> role, (oldValue, newValue) -> newValue)));
            rootIds = roles.stream().filter(role -> role.getParentId() == null).map(Role::getId).collect(Collectors.toList());
            i ++;
        }
        return roleMap.values().stream().collect(Collectors.toList());
    }


    private List<AccountGroup> getAccountGroups(Long uid, Long tenantId){
        List<AccountGroup> accountGroups = accountMapper.getUserGroups(uid, tenantId);
        Map<Long, AccountGroup> accountGroupMap = accountGroups.stream().collect(Collectors.toMap(AccountGroup::getId, accountGroup -> accountGroup, (k1, k2) -> k1));
        List<Long> rootIds = accountGroups.stream().filter(accountGroup -> accountGroup.getParentId() == null).map(AccountGroup::getId).collect(Collectors.toList());
        int i = 0;
        while (!CollectionUtils.isEmpty(rootIds) && i < 10){
            accountGroups = accountMapper.getUserGroupsByParentId(rootIds, tenantId);
            accountGroupMap.putAll(accountGroups.stream().collect(Collectors.toMap(AccountGroup::getId, accountGroup -> accountGroup, (oldValue, newValue) -> newValue)));
            rootIds = accountGroups.stream().filter(accountGroup -> accountGroup.getParentId() == null).map(AccountGroup::getId).collect(Collectors.toList());
            i ++;
        }
        return accountGroupMap.values().stream().collect(Collectors.toList());
    }

    private List<Role> getRolesByAccountGroup(List<Long> groupIds, Long tenantId){
        if (CollectionUtils.isEmpty(groupIds)){
            return Collections.emptyList();
        }
        List<Role> roles = accountMapper.getRoleByAccountGroupIds(groupIds);
        Map<Long, Role> roleMap = roles.stream().collect(Collectors.toMap(Role::getId, role -> role, (k1, k2) -> k1));
        List<Long> rootIds = roles.stream().filter(role -> role.getParentId() == null).map(Role::getId).collect(Collectors.toList());
        int i = 0;
        while (!CollectionUtils.isEmpty(rootIds) && i < 10){
            roles = accountMapper.getRoleByParentId(rootIds, tenantId);
            roleMap.putAll(roles.stream().collect(Collectors.toMap(Role::getId, role -> role, (oldValue, newValue) -> newValue)));
            rootIds = roles.stream().filter(role -> role.getParentId() == null).map(Role::getId).collect(Collectors.toList());
            i ++;
        }
        return roleMap.values().stream().collect(Collectors.toList());
    }

    private List<Permission> getPermissionByRoleIds(List<Long> roleIds, Long tenantId){
        if (CollectionUtils.isEmpty(roleIds)){
            return Collections.emptyList();
        }
        List<Permission> permissions = accountMapper.getPermissionsByRoleId(roleIds, tenantId);
        Map<Long, Permission> permissionMap = permissions.stream().collect(Collectors.toMap(Permission::getId, permission -> permission, (k1, k2) -> k1));
        List<Long> rootIds = permissions.stream().filter(permission -> permission.getParentId() == null).map(Permission::getId).collect(Collectors.toList());
        int i = 0;
        while (!CollectionUtils.isEmpty(rootIds) && i < 10){
            permissions = accountMapper.getPermissionsByParentId(rootIds, tenantId);
            permissionMap.putAll(permissions.stream().collect(Collectors.toMap(Permission::getId, permission -> permission, (oldValue, newValue) -> newValue)));
            rootIds = permissions.stream().filter(permission -> permission.getParentId() == null).map(Permission::getId).collect(Collectors.toList());
            i ++;
        }
        return permissionMap.values().stream().collect(Collectors.toList());
    }


    @Override
    public AccountVo getAccountInfo(GetAccountInfoReq req) {
        return getAccountInfo(req.getUid(), req.getTenantId());
    }

    @Override
    public Boolean isLogin() {
        return null;
    }

    @Override
    public Boolean logout() {
        return null;
    }

    @Override
    public Boolean modifyUserInfo(ModifyUserInfoReq req) {
        return null;
    }
}
