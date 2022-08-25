package org.example.account.center.web.config;

import cn.dev33.satoken.interceptor.SaAnnotationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.*;

import javax.annotation.Resource;

@Configuration
public class RestWebMvcConfigurer extends WebMvcConfigurationSupport{

    @Resource
    private TenantInterceptor interceptor;

    // 注册Sa-Token的注解拦截器，打开注解式鉴权功能
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(interceptor).addPathPatterns("/**");
        // 注册注解拦截器，并排除不需要注解鉴权的接口地址 (与登录拦截器无关)
        registry.addInterceptor(new SaAnnotationInterceptor()).addPathPatterns("/**");
    }

    /**
     *  允许跨域访问
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 可限制哪个请求可以通过跨域
                .allowedHeaders("*")  // 可限制固定请求头可以通过跨域
                .allowedMethods("*") // 可限制固定methods可以通过跨域
                .allowedOriginPatterns("*")  // 可限制访问ip可以通过跨域,SpringBoot2.4.0 [allowedOriginPatterns]代替[allowedOrigins]
                .allowCredentials(true) // 是否允许发送cookie
                .exposedHeaders(HttpHeaders.SET_COOKIE);
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}