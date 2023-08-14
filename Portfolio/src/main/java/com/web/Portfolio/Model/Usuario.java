
package com.web.Portfolio.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

/**
 * Class Usuario
 */
@Getter
@Setter
@Entity
public class Usuario {

  //
  // Fields
  //
  @Id
  // @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id = 151297;

  @OneToMany(mappedBy = "usuario")
  private List<Experiencia> experiencias;

  @OneToMany(mappedBy = "usuario")
  private List<Proyecto> proyectos;

  @OneToMany(mappedBy = "usuario")
  private List<Educacion> educaciones;

  @OneToMany(mappedBy = "usuario")
  private List<SkillCategory> categoriasHabilidad;

  @OneToMany(mappedBy = "usuario")
  private List<RedSocial> redSocial;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "sobreMi_id")
  private SobreMi sobreMi;


  @OneToMany(mappedBy = "usuario")
  private List<Message> mensajes;

  private String email;
  private String nombre;

  private String contraseña;
  private Boolean estaLoggeado;

  //
  // Constructors
  //
  public Usuario(String nombre, String email, String pw) {
    this.nombre = nombre;
    this.email = email;
    this.contraseña = pw;

  };

  public Usuario() {

  }

  public Usuario(String nombre, String email, String pw, List<Experiencia> experiencia,
      List<Educacion> educacion, List<Proyecto> proyecto, List<SkillCategory> categoriaHabilidad,
      SobreMi sobreMi) {
    this.nombre = nombre;
    this.email = email;
    this.contraseña = pw;
    this.experiencias = experiencia;
    this.educaciones = educacion;
    this.proyectos = proyecto;
    this.categoriasHabilidad = categoriaHabilidad;
    this.sobreMi = sobreMi;
  }

  // Other methods
  public void iniciarSesion(String email, String pw) {
    if (email == getEmail() && pw == this.contraseña) {
      this.estaLoggeado = true;
    }
  }

  public void cerrarSesion() {
    this.estaLoggeado = false;

  }

  public void agregarEducacion(Educacion newEducation) {
    educaciones.add(newEducation);
  }

  public void agregarProyecto(Proyecto newProyecto) {
    proyectos.add(newProyecto);

  }

  public void agregarCategoriaHabilidad(SkillCategory newSkillCategory) {
    categoriasHabilidad.add(newSkillCategory);

  }

  public void agregarExperiencia(Experiencia newExperiencia) {
    experiencias.add(newExperiencia);
  }

 

  public void editExperiencia(Long idExperiencia, Experiencia experiencia) {

  }

  public void editProyectos(Long idProyecto, Proyecto proyecto) {
  }

  public void editEducacion(Long idEducacion, Educacion educacion) {
    for (Educacion educacionItem : educaciones) {
      if (educacionItem.getId() == idEducacion) {

      }
    }
  }

  public void borrarExperiencia(int idExp) {
  }

  public void borrarProyecto(int idProyecto) {
  }

  public void borrarEducacion(int idEducacion) {
  }

}
