package br.com.eteg.opbp.configs

import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@Configuration
@EnableMongoRepositories(basePackages = arrayOf("br.com.eteg.opbp.repositories.mongodb"))
class MongoConfiguration