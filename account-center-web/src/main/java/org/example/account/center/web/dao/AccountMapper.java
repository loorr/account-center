package org.example.account.center.web.dao;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.account.center.web.model.Account;

import java.util.List;

@Mapper
public interface AccountMapper {
    @Select("select * from account where uid = #{uid}")
    Account getAccountByUid(Long uid);

    @Update("<script>" +
            "update account " +
            "<set>" +
            "<if test='email!=null and email !=\"\"'>and email = #{email} </if>" +
            "<if test='password!=null and password !=\"\"'>and password = #{password} </if>" +
            "<if test='nickname!=null and nickname !=\"\"'>and nickname = #{nickname} </if>" +
            "<if test='username!=null and username !=\"\"'>and username = #{username} </if>" +
            "<if test='valid!=null'>and valid = #{valid} </if>" +
            "<if test='firstLogin!=null'>and first_login = #{firstLogin} </if>" +
            "</set>" +
            "where uid = #{uid}" +
            "</script>")
    int updateAccountByCondition(Account account);

    @Select("<script>" +
            "select * from account " +
            "<where>" +
            "<if test='email!=null and email !=\"\"'>and email = #{email} </if>" +
            "<if test='password!=null and password !=\"\"'>and password = #{password} </if>" +
            "<if test='nickname!=null and nickname !=\"\"'>and nickname = #{nickname} </if>" +
            "<if test='username!=null and username !=\"\"'>and username = #{username} </if>" +
            "<if test='uid!=null'>and uid = #{uid} </if>" +
            "</where>" +
            " order by db_create_time desc" +
            "</script>")
    Page<Account> getAccounts(Account account);

}
