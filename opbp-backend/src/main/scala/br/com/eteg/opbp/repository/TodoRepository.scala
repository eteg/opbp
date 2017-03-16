package br.com.eteg.opbp.repository

import java.util.List

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource

import br.com.eteg.opbp.entities.Todo

@RepositoryRestResource(collectionResourceRel = "todos", path = "todos")
trait TodoRepository extends CrudRepository[Todo, java.lang.Long] {
  def findByCompleted(@Param("completed") completed: Boolean): List[Todo]

  @Query("from Todo where completed = true")
  def findCompleted(): List[Todo]

  @Query("from Todo where completed = false")
  def findIncompleted(): List[Todo]
}