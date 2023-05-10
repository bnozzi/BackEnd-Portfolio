package com.web.Portfolio.Controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.Portfolio.Model.Proyecto;
import com.web.Portfolio.Service.ProyectosService;

import io.jsonwebtoken.JwtException;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ProyectoController {
    
    @Autowired
    private ProyectosService proyectoService;

    @Autowired
    private AuthUser auth;

    @PostMapping("/addProyect")
    public ResponseEntity<Map<String, String>> addProyect(@RequestBody Proyecto proyecto,
            @RequestHeader("Authorization") String authorizationHeader) {
        Map<String, String> response = new HashMap<>();
        String jwt = authorizationHeader.substring(7);
        if (auth.isJwtValid(jwt, auth.getSecretKey())) {
            proyectoService.addProyect(proyecto);
            response.put("mensaje", "Proyecto agregado");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new JwtException("JWT no válido");
        }
    }

    @GetMapping("/getProyect/{id}")
    public Proyecto getProyectById(@PathVariable Long id) {
        return proyectoService.getProyect(id);
    }

    @GetMapping("/getAllProyects")
    public List<Proyecto> getProyects() {
        return proyectoService.getAllProyects();
    }

    @DeleteMapping("/deleteProyect/{id}")
    public ResponseEntity<Map<String, String>> deleteProyect(@PathVariable Long id,
            @RequestHeader("Authorization") String authorizationHeader) {
        Map<String, String> response = new HashMap<>();
        String jwt = authorizationHeader.substring(7);
        if (auth.isJwtValid(jwt, auth.getSecretKey())) {
            proyectoService.deleteProyect(id);
            response.put("mensaje", "Proyecto eliminado");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new JwtException("JWT no válido");
        }
    }

    @PutMapping("/updateProyect/{id}")
    public ResponseEntity<Map<String, String>> updateProyect(@PathVariable Long id, @RequestBody Proyecto proyecto,
            @RequestHeader("Authorization") String authorizationHeader) {
        Map<String, String> response = new HashMap<>();
        String jwt = authorizationHeader.substring(7);
        if (auth.isJwtValid(jwt, auth.getSecretKey())) {
            proyectoService.updateProyect(id, proyecto);
            response.put("mensaje", "Proyecto actualizado");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new JwtException("JWT no válido");
        }
    }

}
