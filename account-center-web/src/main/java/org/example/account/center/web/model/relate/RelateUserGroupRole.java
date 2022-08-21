package org.example.account.center.web.model.relate;

import com.tove.web.infra.common.BaseModel;
import lombok.Data;

@Data
public class RelateUserGroupRole extends BaseModel {
    private Long ugId;
    private Long rId;
}
