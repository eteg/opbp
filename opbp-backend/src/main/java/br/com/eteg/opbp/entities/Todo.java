package br.com.eteg.opbp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Todo {
  
  private @Id @GeneratedValue Integer id;
  private String text;
  private Boolean completed;
  
  public Integer getId() {
    return id;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
  
  public String getText() {
    return text;
  }
  
  public void setText(String text) {
    this.text = text;
  }
  
  public Boolean getCompleted() {
    return completed;
  }
  
  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }
}
