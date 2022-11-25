package com.pywzzz.graduation_practice.config;

import com.pywzzz.graduation_practice.interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 创建配置类，在MVC模块中，配置拦截器的处理
 * @author: hy
 * @create: 2022-11-25 08:25:25
 */
@Configuration //添加配置类注解，让spring容器加载该配置类对象
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //将我们自己创建的拦截器，注册到mvc模块中
        registry.addInterceptor(new LoginCheckInterceptor()) //配置拦截器
                //针对所有请求进行拦截
                .addPathPatterns("/**")
                //配置放行的请求路径
                .excludePathPatterns("/","/login.html","/forward/toLogin","/emp/login","/img/*","/layui/**");
    }
}
