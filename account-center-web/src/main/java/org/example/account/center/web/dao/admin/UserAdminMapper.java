package org.example.account.center.web.dao.admin;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.account.center.web.dao.AccountMapper;
import org.example.account.center.web.model.Account;

@Mapper
public interface UserAdminMapper extends AccountMapper {

    @Insert("insert into account(`tenant_id`,`uid`, `username`, `nickname`, `email`, `password`) " +
            "values(#{tenantId},#{uid}, #{username}, #{nickname}, #{email}, #{password})")
    int insertAccount(Account account);

}
