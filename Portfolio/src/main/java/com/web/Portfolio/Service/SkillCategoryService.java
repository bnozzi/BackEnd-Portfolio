package com.web.Portfolio.Service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.web.Portfolio.Model.SkillCategory;
import com.web.Portfolio.Model.SkillItem;
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
        return skillCategoryRepository.findAll();
    }

    @Override
    public SkillCategory getSkillCategoryById(Long id) {
        return skillCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public void addSkillCategory(SkillCategory skillCategory) {
        Usuario user = userRepo.findById((long) 151297).orElse(null);
        user.agregarCategoriaHabilidad(skillCategory);
        skillCategory.setUsuario(user);
        userRepo.flush();
        skillCategoryRepository.save(skillCategory);
    }

    @Override
    public void deleteSkillCategory(Long id) {
        skillCategoryRepository.deleteById(id);
    }

    @Override
    public void updateSkillCategory(List<SkillCategory> skillCategory) {
        for (SkillCategory skillCategoryList : skillCategory) {
            SkillCategory oldSkillCategory = skillCategoryRepository.findById(skillCategoryList.getId()).orElse(null);
            if (oldSkillCategory != null) {
                oldSkillCategory.setNombre(skillCategoryList.getNombre());
                oldSkillCategory.setHabilidades(skillCategoryList.getHabilidades());
                skillCategoryRepository.flush();
                skillCategoryRepository.save(oldSkillCategory);
            }
        }

    }

    
    public List<SkillItem> getAllSkillItemsByCategoryId(Long categoryId) {
        return skillCategoryRepository.findById(categoryId)
            .map(SkillCategory::getHabilidades)
            .orElse(Collections.emptyList());
      }

}