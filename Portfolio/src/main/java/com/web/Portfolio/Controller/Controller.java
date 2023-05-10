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

import io.jsonwebtoken.JwtException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// en la clase controller tengo que crear todas las rest apis o rutas para responder a las peticiones 
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class Controller {

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

    @Autowired
    private AuthUser auth;

    @PostMapping("/aboutMe")
    public void aboutMe(@RequestBody SobreMi sobreMi) {
        // ! delete this method
        sobreMiService.addSobreMi(sobreMi);
    }

    @GetMapping("/aboutMe")
    public SobreMi getSobreMi() {
        return sobreMiService.getAboutMe();
    }

    @PutMapping("/updateAboutMe")
    public ResponseEntity<Map<String, String>> updateAboutMe(@RequestBody SobreMi sobreMi,
            @RequestHeader("Authorization") String authorizationHeader) {
        Map<String, String> response = new HashMap<>();
        String jwt = authorizationHeader.substring(7);
        if (auth.isJwtValid(jwt, auth.getSecretKey())) {
            sobreMiService.editAboutMe(sobreMi);
            response.put("mensaje", "Sobre mí actualizado");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new JwtException("JWT no válido");
        }
    }

}
