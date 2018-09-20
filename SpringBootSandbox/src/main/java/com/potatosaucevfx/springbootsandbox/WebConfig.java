package com.potatosaucevfx.springbootsandbox;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author PotatoSauceVFX <rj@potatosaucevfx.com>
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");  // CSS files
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");    // JS files
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/images/");    // Images
        registry.addResourceHandler("/lib/**").addResourceLocations("classpath:/static/js/lib/");   // JS Libraries
    }

}
