package com.web.Portfolio.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.web.Portfolio.Model.Educacion;
import com.web.Portfolio.Model.Proyecto;
import com.web.Portfolio.Model.SobreMi;
import com.web.Portfolio.Model.Usuario;
import com.web.Portfolio.Service.EducacionService;
import com.web.Portfolio.Service.ProyectosService;
import com.web.Portfolio.Service.SobreMiService;
import com.web.Portfolio.Service.UserService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

// en la clase controller tengo que crear todas las rest apis o rutas para responder a las peticiones 
@RestController
public class Controller {

    private List<Usuario> personas = new ArrayList<Usuario>();

    /*
     * Test getmapping
     */
    @GetMapping("/hola")
    public String sayHelloString() {
        return "hello world";
    }

    // userService

    @Autowired
    private UserService uService;

    @GetMapping("/getUser/{id}")
    public Usuario getUsuarioById(@PathVariable Long id) {
        return uService.getUser(id);
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody Usuario user) {
        uService.addUser(user);

    }

    // aboutMe Service

    @Autowired
    private SobreMiService sobreMiService;

    @PostMapping("/aboutMe")
    public void aboutMe(@RequestBody SobreMi sobreMi) {
        // ! delete this method
        sobreMiService.addSobreMi(sobreMi);
    }

    @GetMapping("/aboutMe/{id}")
    public SobreMi getSobreMi(@PathVariable Long id) {
        return sobreMiService.getAboutMe(id);
    }

    // Education service
    @Autowired
    private EducacionService educacionService;

    @PostMapping("/addEducation")
    public void addEducation(@RequestBody Educacion educacion) {
        educacionService.addEducation(educacion);
    }

    @GetMapping("/getEducation/{id}")
    public Educacion getEducation(@PathVariable Long id) {
        return educacionService.getEducation(id);

    }

    @GetMapping("/getAllEducation")
    public List<Educacion> getEducations() {
        return educacionService.getAllEducations();
    }

    @DeleteMapping("/deleteEducation/{id}")
    public void deleteEducation(@PathVariable Long id) {
        educacionService.removeEducation(id);

    }

    @PutMapping("/updateEducation/{id}")
    public void updateEducation(@PathVariable Long id, @RequestBody Educacion educacion) {

        educacionService.updateEducation(id, educacion);
    }

    // Proyect service
    @Autowired
    private ProyectosService proyectoService;

    // get mapping proyect by id
    @GetMapping("/getAllProyects")
    public List<Proyecto> getProyects() {
        return proyectoService.getAllProyects();
    }

    //get by id 
    @GetMapping("getProyect/{id}")
    public Proyecto getProyectById(@PathVariable Long id) {
        return proyectoService.getProyect(id);
    }

    @PostMapping("/addProyect")
    public void addProyect(@RequestBody Proyecto proyecto) {
        proyectoService.addProyect(proyecto);
    }

    @DeleteMapping("/deleteProyect/{id}")
    public void deleteProyect(@PathVariable Long id) {
        proyectoService.deleteProyect(id);
    }

    @PutMapping("/updateProyect/{id}")
    public void updateProyect(@PathVariable Long id, @RequestBody Proyecto proyecto) {
        proyectoService.updateProyect(id, proyecto);
    }


    

}
    


