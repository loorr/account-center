package org.example.account.center.web.config;

import io.swagger.annotations.ApiOperation;
import org.example.account.center.web.common.CommonConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket demoApi() {
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        ticketPar.name(CommonConstant.TENANT_CODE_HEADER)
                .description("登录校验")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .defaultValue("we-tagging")
                .build();
        pars.add(ticketPar.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(pars)
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.regex("(?!/error.*).*"))
                .paths(PathSelectors.regex("(?!/actuator.*).*"))
                .build()
                ;
    }
}
