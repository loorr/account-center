package org.example.account.center.web;


import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@NacosPropertySource(dataId = "account-center", autoRefreshed = true)
@EnableSwagger2
@SpringBootApplication(scanBasePackages = {
        "org.example.account.center.web.service",
        "org.example.account.center.web.controller"
})
@MapperScan("org.example.account.center.web.dao")
public class WebApplication {
    public static void main( String[] args ) {
        SpringApplication.run(WebApplication.class, args);
    }
}
