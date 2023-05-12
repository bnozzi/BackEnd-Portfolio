package com.web.Portfolio.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.web.Portfolio.Model.SkillCategory;
import com.web.Portfolio.Service.SkillCategoryService;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SkillCategoryController {

    @Autowired
    private SkillCategoryService skillCategoryService;

    @Autowired
    private AuthUser auth;

    @GetMapping("/getSkillCategory/{id}")
    public SkillCategory getSkillCategoryById(@PathVariable long id) {
        return skillCategoryService.getSkillCategoryById(id);
    }

    @GetMapping("/getAllSkillCategories")
    public List<SkillCategory> getAllSkillCategories() {
        return skillCategoryService.getAllSkillCategories();
    }

    @PostMapping("/addSkillCategory")
    public ResponseEntity<Map<String, String>> addSkillCategory(@RequestBody SkillCategory skillCategory,
            @RequestHeader("Authorization") String authorizationHeader) {
        Map<String, String> response = new HashMap<>();
        String jwt = authorizationHeader.substring(7);
        if (auth.isJwtValid(jwt, auth.getSecretKey())) {
            skillCategoryService.addSkillCategory(skillCategory);
            response.put("mensaje", "Categoría de habilidad agregada");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new JwtException("JWT no válido");
        }
    }

    @DeleteMapping("/deleteSkillCategory/{id}")
    public ResponseEntity<Map<String, String>> deleteSkillCategory(@PathVariable long id,
            @RequestHeader("Authorization") String authorizationHeader) {
        Map<String, String> response = new HashMap<>();
        String jwt = authorizationHeader.substring(7);
        if (auth.isJwtValid(jwt, auth.getSecretKey())) {
            skillCategoryService.deleteSkillCategory(id);
            response.put("mensaje", "Categoría de habilidad eliminada");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new JwtException("JWT no válido");
        }

    }

    @PutMapping("/updateSkillCategory/{id}")
    public ResponseEntity<Map<String, String>> updateSkillCategory(@RequestBody SkillCategory skillCategory,
            @PathVariable long id,
            @RequestHeader("Authorization") String authorizationHeader) {
        Map<String, String> response = new HashMap<>();
        String jwt = authorizationHeader.substring(7);
        if (auth.isJwtValid(jwt, auth.getSecretKey())) {
            skillCategoryService.updateSkillCategory(skillCategory, id);
            response.put("mensaje", "Categoría de habilidad actualizada");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new JwtException("JWT no válido");
        }
    }
}
