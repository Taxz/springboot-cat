package com.study.edu.config;

import com.dianping.cat.servlet.CatFilter;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/3/14.
 */
//@Configuration
public class CatFilterConfgi {
    //@Bean
    public FilterRegistrationBean catFilter(){
        FilterRegistrationBean register = new FilterRegistrationBean();
        CatFilter filter1 = new CatFilter();
        register.setFilter(filter1);
        register.addUrlPatterns("/*");
        register.setName("cat-filter");
        register.setOrder(2);
        return register;
    }

}
