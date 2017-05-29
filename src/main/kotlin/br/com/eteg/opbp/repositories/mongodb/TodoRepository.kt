package br.com.eteg.opbp.repositories.mongodb

import br.com.eteg.opbp.entities.todo.Todo
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.CrossOrigin

@CrossOrigin
@Repository
interface TodoRepository : MongoRepository<Todo, String>