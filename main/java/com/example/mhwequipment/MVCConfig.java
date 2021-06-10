package com.example.mhwequipment;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *  For custom login Page, after specify URL .loginPage("") in WebSecurityConfig
 *  Must configure Spring MVC viewResolver to top the URL with a view name
 */
@Configuration
public class MVCConfig implements WebMvcConfigurer {

    public void addViewController(ViewControllerRegistry registry){

        registry.addViewController("/login").setViewName("login");
    }
}
