package br.com.eteg.opbp.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Todo {
  @Id @GeneratedValue Integer id
  String text
  Boolean completed
}
