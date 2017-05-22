package br.com.eteg.opbp.configs

import com.mongodb.Mongo
import com.mongodb.MongoClient
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@Configuration
@EnableMongoRepositories("br.com.eteg.opbp.repositories")
class MongoConfiguration : AbstractMongoConfiguration() {
    override fun mongo(): Mongo = MongoClient()

    override fun getDatabaseName(): String = "opbp"
}