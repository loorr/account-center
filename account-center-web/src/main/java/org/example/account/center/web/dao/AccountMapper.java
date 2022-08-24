package org.example.account.center.web.dao;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.account.center.api.entity.UserGroupItem;
import org.example.account.center.web.model.Account;
import org.example.account.center.web.model.AccountExt;
import org.example.account.center.web.model.Permission;
import org.example.account.center.web.model.Role;

import java.util.List;

@Mapper
public interface AccountMapper {
    @Select("select * from account where uid = #{uid} and tenant_id = #{tenantId}")
    Account getAccountByUid(Long uid, Long tenantId);

    @Select("select * from account where email = #{email} and tenant_id = #{tenantId}")
    Account getAccountByEmail(String email, Long tenantId);

    @Select("select * from account where uid=#{uid}")
    AccountExt getAccountExt(Long uid);

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

    List<UserGroupItem> getUserGroups(Long uid);

    @Select("<script>" +
            "select r.name, r.id, r.parent_id from " +
            "(select r_id from  relate_account_role ra where ra.uid=#{uid}) as b " +
            "join " +
            "(select * from `role` b where b.tenant_id=#{tenantId}) as r " +
            "on r.id =b.r_id  " +
            "<if test='parentIds!=null'>" +
            "<foreach collection='parentIds' item='parentId' open=' where parent_id in (' separator=',' close=')'>#{parentId}</foreach>" +
            "</if>" +
            "<script>")
    List<Role> getUserDefaultRoles(@Param("uid") Long uid, @Param("tenantId") Long tenantId,@Param("parentIds") List<Long> parentIds);


    @Select("")
    List<Permission> getPermissionsByRoleId(@Param("roleIds") Long roleIds);

    @Select("")
    List<Permission> getPermissionsByParentId(@Param("parentIds") List<Long> parentIds);

}
