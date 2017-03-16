package br.com.eteg.opbp.entities

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import scala.beans.BeanProperty

@Entity
class Todo {

  @Id
  @GeneratedValue
  @BeanProperty
  var id: Long = _

  @BeanProperty
  var text: String = _

  @BeanProperty
  var completed: Boolean = _
}