package org.example.account.center.web.service.common;

public interface SmsSender {
    void send(String phone, String[] content);
}
