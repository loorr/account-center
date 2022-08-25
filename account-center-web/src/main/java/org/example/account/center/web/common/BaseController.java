package org.example.account.center.web.common;


import org.example.account.center.web.service.TenantService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

public abstract class BaseController {

    @Resource
    private HttpServletRequest httpServletRequest;

    @Resource
    private TenantService tenantService;

    protected Long getTenantId() {
        String tenantCode = httpServletRequest.getHeader(CommonConstant.TENANT_CODE_HEADER);
        return tenantService.getTenantId(tenantCode);
    }
}
