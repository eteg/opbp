package br.com.eteg.opbp.configs

import com.mongodb.*
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoConfiguration

@Configuration
class MongoConfiguration : AbstractMongoConfiguration() {
    override fun mongo(): Mongo {
        val serverAddress = ServerAddress("localhost", 27017)
        val mongoClientOptions = MongoClientOptions.Builder().writeConcern(WriteConcern.ACKNOWLEDGED).build()
        val mongoClient = MongoClient(serverAddress, mongoClientOptions)

        return mongoClient
    }

    override fun getDatabaseName(): String = "opbp"
}