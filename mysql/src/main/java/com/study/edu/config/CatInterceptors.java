package com.study.edu.config;

import com.study.edu.inteceptor.CatInterceptor;
import com.study.edu.inteceptor.CatMybatisPlugins;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by Administrator on 2018/3/23.
 */
@Configuration
public class CatInterceptors extends WebMvcConfigurerAdapter{

    //注册自定义拦截器
    @Bean
    public CatInterceptor getInterceptor(){
        return new CatInterceptor();
    }

    //注册mybatis拦截器
    @Bean
    public CatMybatisPlugins getCatMybatisInterceptor(){
        return new CatMybatisPlugins();
    }

    //重写addInterceptors方法
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getInterceptor());
        super.addInterceptors(registry);
    }

    //中文乱码处理
    @Bean
    public HttpMessageConverter<String> responseBodyConverter(){
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return converter;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        super.configureMessageConverters(converters);
        converters.add(responseBodyConverter());

    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }
}
