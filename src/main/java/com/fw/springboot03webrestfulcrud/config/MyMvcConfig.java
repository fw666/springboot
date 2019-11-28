package com.fw.springboot03webrestfulcrud.config;

import com.fw.springboot03webrestfulcrud.component.MyLocaleResolve;
import com.fw.springboot03webrestfulcrud.component.loginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Configuration 表示这个类是配置类，可以添加一些其他的配置信息
 */
@Configuration//所有的组件都会一起起作用
public class MyMvcConfig implements WebMvcConfigurer {
    /**
     * 设置项目初始化访问路径
     */
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("login.html");
//        registry.addViewController("/index.html").setViewName("login");
//    }

    /**
     * 设置项目初始化访问路径（第二种方式）
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index").setViewName("login");
                registry.addViewController("/success.html").setViewName("success");
            }

            /**
             * 注册拦截器
             * super.addInterceptors(registry);
             * 静态资源 *.css,*.js 能够访问，因为springboot已经做好了静态资源映射
             * .addPathPatterns("/**") 添加要拦截的页面， /** 代表所有
             * .excludePathPatterns("/","/index","/user/login");让哪些资源不被拦截
             */
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new loginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/","/index","/user/login");
            }
        };
        return webMvcConfigurer;
    }

    /**
     * 配置区域化信息，使用自己编写的区域化信息
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolve();
    }
}
