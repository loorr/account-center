package org.example.account.center.web.service.common;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TencentSmsServiceTest {

    @Resource
    private TencentSmsService tencentSmsService;

    @Test
    void send() {
        tencentSmsService.send("18384362500", new String[]{"123456"});
    }
}