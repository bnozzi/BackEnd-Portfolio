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

import com.web.Portfolio.Model.Educacion;
import com.web.Portfolio.Service.EducacionService;

import io.jsonwebtoken.JwtException;

@RestController
public class EducacionController {
    
    @Autowired
    private EducacionService educacionService;
    
    @Autowired
    private AuthUser auth;
    @PostMapping("/addEducation")
    public ResponseEntity<Map<String, String>> addEducation(@RequestBody Educacion educacion,
            @RequestHeader("Authorization") String authorizationHeader) {
        Map<String, String> response = new HashMap<>();
        String jwt = authorizationHeader.substring(7);
        if (auth.isJwtValid(jwt, auth.getSecretKey())) {
            educacionService.addEducation(educacion);
            response.put("mensaje", "Educacion agregada");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new JwtException("JWT no válido");
        }
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
    public ResponseEntity<Map<String, String>> deleteEducation(@PathVariable Long id,
            @RequestHeader("Authorization") String authorizationHeader) {
        Map<String, String> response = new HashMap<>();
        String jwt = authorizationHeader.substring(7);
        if (auth.isJwtValid(jwt, auth.getSecretKey())) {
            educacionService.removeEducation(id);
            response.put("mensaje", "educacion eliminada");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new JwtException("JWT no válido");
        }
    }

    @PutMapping("/updateEducation/{id}")
    public ResponseEntity<Map<String, String>> updateEducation(@PathVariable Long id, @RequestBody Educacion educacion,
            @RequestHeader("Authorization") String authorizationHeader) {
        Map<String, String> response = new HashMap<>();
        String jwt = authorizationHeader.substring(7);
        if (auth.isJwtValid(jwt, auth.getSecretKey())) {
            educacionService.updateEducation(id, educacion);
            response.put("mensaje", "educacion actualizada");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new JwtException("JWT no válido");
        }
    }

}
