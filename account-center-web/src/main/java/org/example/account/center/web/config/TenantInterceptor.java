package org.example.account.center.web.config;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.example.account.center.web.service.TenantService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Slf4j
@Component
public class TenantInterceptor implements HandlerInterceptor {

    @Resource
    private TenantService tenantService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        Map pathVariables = (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        System.out.printf("pathVariables: %s\n", JSON.toJSONString(pathVariables));
        //String tenantCode = (String) pathVariables.get("tenantCode");
        //Long tenantId = tenantService.getTenantId(tenantCode);
        // request..setTenantId(tenantId);
        return true;
    }
}
