package br.com.eteg.opbp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import br.com.eteg.opbp.entities.Todo;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "todos", path = "todos")
public interface TodoRepository extends CrudRepository<Todo, Integer> {
  List<Todo> findByCompleted(@Param("completed") Boolean completed);

  @Query("from Todo where completed = true")
  List<Todo> findCompleted();

  @Query("from Todo where completed = false")
  List<Todo> findIncompleted();
}
