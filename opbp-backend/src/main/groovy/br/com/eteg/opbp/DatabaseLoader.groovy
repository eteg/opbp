package br.com.eteg.opbp

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

import br.com.eteg.opbp.entities.Todo
import br.com.eteg.opbp.repository.TodoRepository

@Component
class DatabaseLoader implements CommandLineRunner {

	@Autowired
	private TodoRepository todoRepository

	@Override
	void run(String... args) throws Exception {
		5.times {
			todoRepository.save new Todo(text: "Todo ${it+1}", completed: false)
		}
	}
}
