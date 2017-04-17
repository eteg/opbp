package br.com.eteg.opbp;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
public class RestDataConfig extends RepositoryRestMvcConfiguration {

  @Override
  public RepositoryRestConfiguration config() {
    RepositoryRestConfiguration configuration = super.config();
    return configuration.setBasePath("/rest");
  }
}
