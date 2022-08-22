package org.example.account.center.web.service;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.tove.web.infra.common.BaseException;
import org.example.account.center.web.common.AccountErrorCode;
import org.example.account.center.web.dao.TenantMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class TenantService {

    @Resource
    private TenantMapper tenantMapper;

    private final LoadingCache<String, Long> tenantIdCache = Caffeine.newBuilder()
            .maximumSize(100)
            .expireAfterWrite(24, TimeUnit.HOURS)
            .build(tenantCode -> {
                if (tenantCode == null) {
                    throw new BaseException(AccountErrorCode.TENANT_CODE_NOT_NULL);
                }
                Long tenantId = tenantMapper.getTenantId(tenantCode);
                if (tenantId == null) {
                    throw new BaseException(AccountErrorCode.TENANT_CODE_NOT_CORRECT);
                }
                return tenantId;
            });

    public Long getTenantId(String tenantCode) {
        return tenantIdCache.get(tenantCode);
    }

}
