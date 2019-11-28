package com.fw.springboot03webrestfulcrud.component;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 区域化信息配置
 * 配置页面指定的语言国家信息
 */
public class MyLocaleResolve implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");//获取请求中 l 所带的语言国家信息
        Locale locale = Locale.getDefault();// 如果 l 中不带信息，那么使用SpringBoot默认的
        if(!StringUtils.isEmpty(l)){ //判断 l 是否为空
            String[] s = l.split("_"); //将语言信息分割为 两个部分 en  US  or  zh CN
            locale = new Locale(s[0], s[1]); //
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
