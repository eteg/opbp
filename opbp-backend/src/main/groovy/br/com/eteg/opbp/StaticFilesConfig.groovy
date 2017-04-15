package br.com.eteg.opbp

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@Configuration
class StaticFilesConfig extends WebMvcConfigurerAdapter {

  @Override
  void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/")
        .setViewName("forward:/app/index.html")
  }

  @Override
  void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/app/**")
        .addResourceLocations(
        "classpath:/META-INF/resources/webjars/opbp-frontend/")
  }
}
