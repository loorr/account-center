package org.example.account.center.web.service.admin;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tove.web.infra.common.PageResult;
import com.tove.web.infra.common.tool.Md5Tools;
import lombok.extern.slf4j.Slf4j;
import org.example.account.center.api.admin.entity.user.req.*;
import org.example.account.center.api.entity.AccountVo;
import org.example.account.center.web.common.CommonConstant;
import org.example.account.center.web.dao.admin.UserAdminMapper;
import org.example.account.center.web.model.Account;
import org.example.account.center.web.util.RandomUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserAdminService {

    @Resource
    private UserAdminMapper userAdminMapper;

    public boolean resetPassword(ResetPasswordReq req) {
        String defaultPassword = Md5Tools.MD5(CommonConstant.DEFAULT_PASSWORD);
        Account account = new Account();
        account.setId(req.getUid());
        account.setPassword(defaultPassword);
        int row = userAdminMapper.updateAccountByCondition(account);
        return row > 0;
    }

    
    public boolean updateUser(UpdateUserReq req) {
        Account account = new Account();
        BeanUtils.copyProperties(req, account);
        int row = userAdminMapper.updateAccountByCondition(account);
        return row > 0;
    }

   
    public boolean addUser(AddUserReq req) {
        Account account = new Account();
        BeanUtils.copyProperties(req, account);
        Long uid = RandomUtil.getRandomLong(6);
        account.setUid(uid);
        account.setPassword(Md5Tools.MD5(CommonConstant.DEFAULT_PASSWORD));
        for (int i = 0; i < 3; i++) {
            try {
                int row = userAdminMapper.insertAccount(account);
                return row > 0;
            } catch (DuplicateKeyException e) {
                log.warn("add User, duplicate key, try again: {}", account);
            }
        }
        return false;
    }

    
    public boolean removeUser(RemoveUserReq req) {
        Account account = new Account();
        account.setUid(req.getUid());
        account.setValid(false);
        int row = userAdminMapper.updateAccountByCondition(account);
        return row > 0;
    }

    
    public PageResult<AccountVo> getUserListPage(GetUserPageListReq req) {
        PageHelper.startPage(req.getPage(), req.getRows());
        Account account = new Account();
        BeanUtils.copyProperties(req, account);
        Page<Account> page =  userAdminMapper.getAccounts(account);

        List<AccountVo> list = page.getResult().stream().map(o->{
            AccountVo vo = new AccountVo();
            BeanUtils.copyProperties(o, vo);
            return vo;
        }).collect(Collectors.toList());

        PageResult<AccountVo> pageResult = new PageResult<>(page.getTotal(), list);
        return pageResult;
    }

    public Boolean accountRelateUserGroup(AccountRelateUserGroupReq req) {
        Account account = new Account();
        account.setUid(req.getUid());
        //account.setUgIds(req.getUgIds());
        int row = userAdminMapper.updateAccountByCondition(account);
        return row > 0;
    }
}
