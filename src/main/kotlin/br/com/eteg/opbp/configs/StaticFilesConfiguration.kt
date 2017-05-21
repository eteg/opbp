package br.com.eteg.opbp.configs

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@Configuration
class StaticFilesConfiguration : WebMvcConfigurerAdapter() {
    override fun addViewControllers(registry: ViewControllerRegistry) {
        registry.addViewController("/").setViewName("forward:/app/index.html")
    }

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/app/**").addResourceLocations(
                "classpath:/META-INF/resources/webjars/opbp-frontend/")
    }
}
