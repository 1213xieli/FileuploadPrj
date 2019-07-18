package com.xieli.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import javax.servlet.MultipartConfigElement;

//上传配置类
//图片放到/F:/fileUpload/后，从磁盘读取的图片数据scr将会变成images/picturename.jpg的格式
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    /**
     * 在配置文件中配置的文件保存路径
     */
    @Value("${fileUpload.path}")
    private String fileUploadPath;

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("500MB");//文件最大KB,MB
        factory.setMaxRequestSize("1024MB");//设置总上传数据总大小
        return factory.createMultipartConfig();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/fileFolder/**").addResourceLocations(fileUploadPath);
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController( "/file" ).setViewName( "file" );
        registry.addViewController( "/filelist" ).setViewName( "filelist" );
        registry.addViewController( "/index" ).setViewName( "index" );
        registry.addViewController( "/" ).setViewName( "index" );
        registry.addViewController( "/info" ).setViewName( "info" );
        registry.addViewController( "/searchClient" ).setViewName( "searchClient");
        registry.addViewController( "/searchServer" ).setViewName( "searchServer");
    }
}
