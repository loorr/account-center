package org.example.account.center.web.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TenantMapper {

    @Select("select id from tenant where tenant_code = #{tenantCode}")
    Long getTenantId(String tenantCode);
}
