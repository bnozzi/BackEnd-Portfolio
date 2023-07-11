package com.web.Portfolio.Service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.web.Portfolio.Model.SkillCategory;

import com.web.Portfolio.Model.Usuario;
import com.web.Portfolio.Repository.SkillCategoryRepository;
import com.web.Portfolio.Repository.UserRepository;

@Service
public class SkillCategoryService implements InterSkillCategoryService {

    @Autowired
    public SkillCategoryRepository skillCategoryRepository;

    @Autowired
    public UserRepository userRepo;

    @Override
    public List<SkillCategory> getAllSkillCategories() {
        try {
            return skillCategoryRepository.findAll();
        } catch (Exception ex) {
            // Manejo de la excepción
            ex.printStackTrace();
            return Collections.emptyList(); // O devuelve una lista vacía, dependiendo de tus requisitos
        }
    }

    @Override
    public SkillCategory getSkillCategoryById(Long id) {
        try {
            return skillCategoryRepository.findById(id).orElse(null);
        } catch (Exception ex) {
            // Manejo de la excepción
            ex.printStackTrace();
            return null; // O devuelve un objeto nulo, dependiendo de tus requisitos
        }
    }

    @Override
    public void addSkillCategory(SkillCategory skillCategory) {
        try {
            Usuario user = userRepo.findById((long) 151297).orElse(null);
            user.agregarCategoriaHabilidad(skillCategory);
            skillCategory.setUsuario(user);
            userRepo.flush();
            skillCategoryRepository.save(skillCategory);
        } catch (Exception ex) {
            // Manejo de la excepción
            ex.printStackTrace();
            // Otros pasos de manejo de excepciones, como devolver una respuesta de error
        }
    }

    @Override
    public void deleteSkillCategory(Long id) {
        try {
            skillCategoryRepository.deleteById(id);
        } catch (Exception ex) {
            // Manejo de la excepción
            ex.printStackTrace();
            // Otros pasos de manejo de excepciones, como devolver una respuesta de error
        }
    }

    @Override
    public void updateSkillCategory(SkillCategory skillCategory, Long id) {
        try {
            SkillCategory oldSkillCategory = skillCategoryRepository.findById(id).orElse(null);
            if (oldSkillCategory != null) {
                oldSkillCategory.setNombre(skillCategory.getNombre());
                oldSkillCategory.setHabilidades(skillCategory.getHabilidades());
                skillCategoryRepository.flush();
                skillCategoryRepository.save(oldSkillCategory);
            }
        } catch (Exception ex) {
            // Manejo de la excepción
            ex.printStackTrace();
            // Otros pasos de manejo de excepciones, como devolver una respuesta de error
        }
    }

}
