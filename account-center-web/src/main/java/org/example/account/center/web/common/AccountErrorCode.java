package org.example.account.center.web.common;

import com.tove.web.infra.common.BaseError;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountErrorCode implements BaseError {

    NO_RECORD_MATCH("400","没有对应的记录"),
    DUPLICATE_KEY("401", "记录重复"),
    NO_DATA_SAVE("402", "没有可保存的数据"),

    NO_LOGIN("406", "未登陆，请登陆"),
    USER_NOT_EXIST("407", "不存在该用户"),
    PWD_MISTAKE("408", "账户或密码错误"),
    NOT_ROLE("409", "没有权限")
            ;

    private final String code;
    private final String msg;
}
