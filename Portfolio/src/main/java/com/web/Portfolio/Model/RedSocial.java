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
 * Class RedSocial
 */
@Entity
@Getter
@Setter
public class RedSocial {

  //
  // Fields
  //
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String nombre;
  private String url;
  
  @ManyToOne
  @JsonIgnore
  private Usuario usuario;
  //
  // Constructors
  //
  public RedSocial() {
  };

  //
  // Methods
  //

}
