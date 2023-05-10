
package com.web.Portfolio.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

/**
 * Class SkillCategory
 */
@Getter @Setter
@Entity

 public class SkillCategory {

  //
  // Fields
  //
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private List<String> habilidades;
  
  @ManyToOne
  @JsonIgnore
  private Usuario usuario;
  private String nombre;

  

  public SkillCategory () { };
  
  //
  // Methods
  //
 

  //
  // Accessor methods
  //

 


}
