package org.example.account.center.web.service.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Log4j2
@Service
public class TencentSmsService implements SmsSender{

    @Value("${tencent.sms.secretId:AKIDz8krbsJ5nIspXsMhVUWqbXI0ZvKYjIbX}")
    private String secretId;

    @Value("${tencent.secret.secretKey:XB5IY6BUAQnUYWEr7QCwQH7QSwSwzswS}")
    private String secretKey;

    @Value("${tencent.sms.templateId:SMS_172450001}")
    private String templateId;
    @Value(value = "${tencent.sms.sign:腾讯云}")
    private String sign;

    @Value("${tencent.sms.region:ap-guangzhou}")
    private String region;

    @Value("${tencent.sms.appId:Sms}")
    private String appId;

    private String getSign(){
        return new String(sign.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    }

    @Override
    public void send(String phone, String[] content) {
        Credential cred = new Credential(secretId, secretKey);
        SmsClient smsClient = new SmsClient(cred, region);
        SendSmsRequest req = new SendSmsRequest();
        req.setSmsSdkAppid(appId);
        req.setSign(getSign());
        req.setTemplateID(templateId);

        String[] phoneArr=new String[]{formatPhone(phone)};
        // 写入号码列表
        req.setPhoneNumberSet(phoneArr);
        req.setTemplateParamSet(content);
        SendSmsResponse res = null;
        try {
            res = smsClient.SendSms(req);
            log.info("res: {}", JSON.toJSONString(res));
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
    }

    private String formatPhone(String phone){
        if(phone.startsWith("+86")){
            return phone;
        }
        return "+86"+phone;
    }

}
