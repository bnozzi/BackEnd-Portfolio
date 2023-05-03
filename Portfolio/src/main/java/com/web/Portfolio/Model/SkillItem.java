package com.web.Portfolio.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * Class SkillItem
 */
@Getter
@Setter

@Entity
public class SkillItem {

  //
  // Fields
  //
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String nombre;

  @ManyToOne
  @JsonIgnore
  private SkillCategory categoria;

  //
  // Constructors
  //
  public SkillItem() {
  };

}
