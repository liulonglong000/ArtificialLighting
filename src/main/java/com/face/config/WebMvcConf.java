package com.face.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.face.common.WebInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebMvcConf extends WebMvcConfigurerAdapter {

    @Autowired
    private WebInterceptor webInterceptor;

    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(webInterceptor).addPathPatterns("/**").excludePathPatterns(new String[]{"/user/login", "/login/doLogin", "/downloadFile/downloadFile","/swagger**", "/v2/api-docs","/configuration/**","/condition/algorithm/senderrors"});
 //       registry.addInterceptor(webInterceptor).addPathPatterns("/123");
    }

    // 使用fastjson代替jackson，并处理中文乱码的问题
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);

        FastJsonHttpMessageConverter oFastConverter = new FastJsonHttpMessageConverter();

        FastJsonConfig oFastJsonConfig = new FastJsonConfig();
        oFastJsonConfig.setSerializerFeatures(
                SerializerFeature.WriteMapNullValue
        );
        
        oFastConverter.setFastJsonConfig(oFastJsonConfig);
        //处理中文乱码问题
        List<MediaType> oFastMediaTypeList = new ArrayList<>();
        oFastMediaTypeList.add(MediaType.APPLICATION_JSON_UTF8);
        oFastConverter.setSupportedMediaTypes(oFastMediaTypeList);

        converters.add(oFastConverter);
    }

}
