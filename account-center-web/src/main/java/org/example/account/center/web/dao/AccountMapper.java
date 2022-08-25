package org.example.account.center.web.dao;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;
import org.example.account.center.web.model.*;

import java.util.List;

@Mapper
public interface AccountMapper {
    @Select("select * from account where uid = #{uid} and tenant_id = #{tenantId} and valid = 1")
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

    @Select("<script>" +
            "select * from "+
            "(select * from user_group ug where tenant_id=#{tenantId} ) as a "+
            "join " +
            "(select ug_id from relate_account_user_group raug  where uid = #{uid}) as b "+
            "on a.id = b.ug_id " +
            "</script>")
    List<AccountGroup> getUserGroups(@Param("uid")Long uid, @Param("tenantId")  Long tenantId);

    @Select("<script>" +
            "select * from user_group ug where ug.tenant_id = #{tenantId}  and parent_id in " +
            "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach>" +
            "</script>")
    List<AccountGroup> getUserGroupsByParentId( @Param("ids") List<Long> parentIds, @Param("tenantId")  Long tenantId);

    @Results(id="getUserDefaultRoles",value = {
            @Result(property = "parentId", column = "parent_id"),
    })
    @Select("<script>" +
        "select r.name, r.id, r.parent_id from " +
        "(select r_id from  relate_account_role ra where ra.uid=#{uid}) as b " +
        "join " +
        "(select * from `role` b where b.tenant_id=#{tenantId}) as r " +
        "on r.id =b.r_id  " +
        "<if test='parentIds!=null'>" +
        "<foreach collection='parentIds' item='parentId' open=' where parent_id in (' separator=',' close=')'>#{parentId}</foreach>" +
        "</if>" +
        "</script>" )
    List<Role> getUserDefaultRoles(@Param("uid") Long uid, @Param("tenantId") Long tenantId, @Param("parentIds") List<Long> parentIds);


    @Results(id="getRoleByAccountGroupIds",value = {
            @Result(property = "parentId", column = "parent_id"),
    })
    @Select("<script>" +
        "select * from  " +
        "(select * from relate_user_group_role rugr where ug_id in " +
        "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach>" +
        " ) as a " +
        "join  " +
        "(select * from `role` where tenant_id = 10001) as b " +
        "on b.id = a.r_id "+
        "</script>" )
    List<Role> getRoleByAccountGroupIds(@Param("accountGroupIds") List<Long> accountGroupIds);

    @Results(id="getRoleByParentId",value = {
            @Result(property = "parentId", column = "parent_id"),
    })
    @Select("<script>" +
            "select * from role p where p.tenant_id=#{tenantId} and p.parent_id in " +
            "<foreach collection='parentIds' item='parentId' open='(' separator=',' close=')'>#{parentId}</foreach>" +
            "</script>")
    List<Role> getRoleByParentId(@Param("parentIds") List<Long> parentIds, @Param("tenantId") Long tenantId);

    @Select("<script>" +
            "select * from (select p_id from relate_role_permission rrp where r_id in " +
            "<foreach collection='roleIds' item='roleId' open='(' separator=',' close=')'>#{roleId}</foreach>" +
            ") as a join " +
            "(select * from permission p where p.tenant_id=#{tenantId}) as b " +
            "on a.p_id = b.id " +
            "</script>")
    List<Permission> getPermissionsByRoleId(@Param("roleIds") List<Long> roleIds, @Param("tenantId") Long tenantId);

    @Select("<script>" +
            "select * from permission p where p.tenant_id=#{tenantId} and p.parent_id in " +
            "<foreach collection='parentIds' item='parentId' open='(' separator=',' close=')'>#{parentId}</foreach>" +
            "</script>")
    List<Permission> getPermissionsByParentId(@Param("parentIds") List<Long> parentIds, @Param("tenantId") Long tenantId);

}
