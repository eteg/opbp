package br.com.eteg.opbp

import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration

@Configuration
class RestDataConfig extends RepositoryRestMvcConfiguration {
  @Override
  RepositoryRestConfiguration config() {
    RepositoryRestConfiguration configuration = super.config()
    configuration.setBasePath("/rest")
  }
}
