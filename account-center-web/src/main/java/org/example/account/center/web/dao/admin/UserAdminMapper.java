package org.example.account.center.web.dao.admin;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.account.center.web.dao.AccountMapper;
import org.example.account.center.web.model.Account;

@Mapper
public interface UserAdminMapper extends AccountMapper {

    @Insert("insert into account (uid, email, password, nickname) values (#{uid}, #{email}, #{password}, #{nickname})")
    int insertAccount(Account account);

}
