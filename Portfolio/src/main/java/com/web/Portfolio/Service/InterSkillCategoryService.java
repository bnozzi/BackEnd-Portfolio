package com.web.Portfolio.Service;

import java.util.List;

import com.web.Portfolio.Model.SkillCategory;

public interface InterSkillCategoryService {
    
    public List<SkillCategory> getAllSkillCategories();

    public  SkillCategory getSkillCategoryById(Long id);

    public void addSkillCategory(SkillCategory skillCategory);

    public void deleteSkillCategory(Long id);

    public void updateSkillCategory(List<SkillCategory> skillCategory);
    
    

}
