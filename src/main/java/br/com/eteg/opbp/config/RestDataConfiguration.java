package br.com.eteg.opbp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
public class RestDataConfiguration extends RepositoryRestMvcConfiguration {
  @Override
  public RepositoryRestConfiguration config() {
    final RepositoryRestConfiguration configuration = super.config();
    return configuration.setBasePath("/rest");
  }
}