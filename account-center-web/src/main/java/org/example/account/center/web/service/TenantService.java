package org.example.account.center.web.service;

import com.tove.web.infra.common.BaseException;
import org.example.account.center.web.common.AccountErrorCode;
import org.example.account.center.web.dao.TenantMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TenantService {

    @Resource
    private TenantMapper tenantMapper;

    public Long getTenantId(String tenantCode) {
        if (tenantCode == null) {
            throw new BaseException(AccountErrorCode.TENANT_CODE_NOT_NULL);
        }
        Long tenantId = tenantMapper.getTenantId(tenantCode);
        if (tenantId == null) {
            throw new BaseException(AccountErrorCode.TENANT_CODE_NOT_NULL);
        }
        return tenantId;
    }

}
