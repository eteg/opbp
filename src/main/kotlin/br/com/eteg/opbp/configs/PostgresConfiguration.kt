package br.com.eteg.opbp.configs

import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories(basePackages = arrayOf("br.com.eteg.opbp.repositories.postgres"))
class PostgresConfiguration