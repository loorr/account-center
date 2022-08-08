package org.example.account.center.web.service;

import cn.dev33.satoken.stp.StpInterface;
import org.example.account.center.web.dao.AccountMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class StpInterfaceService implements StpInterface {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return new ArrayList<>();
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        //        Long uid = Long.valueOf(String.valueOf(loginId));
        //        List<UserRole> roles = accountMapper.getRoles(uid);
        //        return roles.stream().map(o->o.getRole()).collect(Collectors.toList());
        return null;
    }

}
