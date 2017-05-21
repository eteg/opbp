package br.com.eteg.opbp.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration

@Configuration
class RestDataConfiguration : RepositoryRestMvcConfiguration() {
    override fun config(): RepositoryRestConfiguration {
        return super.config().setBasePath("/rest")
    }
}
