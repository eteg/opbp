package br.com.eteg.opbp

import org.springframework.stereotype.Component

import br.com.eteg.opbp.repository.TodoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import br.com.eteg.opbp.entities.Todo

@Component
class DatabaseLoader @Autowired() (private val todoRepository: TodoRepository) extends CommandLineRunner {
  
  def run(args: String*) = {
    for (i <- 1 to 10) {
      val todo = new Todo()

      todo.text = s"Tarefa #$i"
      todo.completed = false

      todoRepository.save(todo)
    }
  }
}