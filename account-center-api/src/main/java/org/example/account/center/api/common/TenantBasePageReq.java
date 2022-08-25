package org.example.account.center.api.common;

import com.tove.web.infra.common.Page;
import lombok.Data;

@Data
public class TenantBasePageReq extends Page {
    private Long tenantId;
}
