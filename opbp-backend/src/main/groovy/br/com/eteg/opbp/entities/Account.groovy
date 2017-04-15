package br.com.eteg.opbp.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@Entity
@JsonIgnoreProperties("password")
class Account {
  @Id @GeneratedValue Integer id
  String username
  String password
}
