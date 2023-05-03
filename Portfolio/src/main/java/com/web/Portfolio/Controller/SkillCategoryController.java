package com.web.Portfolio.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.web.Portfolio.Model.SkillCategory;
import com.web.Portfolio.Model.SkillItem;
import com.web.Portfolio.Service.SkillCategoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class SkillCategoryController {

    @Autowired
    private SkillCategoryService skillCategoryService;

    @GetMapping("/getSkillCategory/{id}")
    public SkillCategory getSkillCategoryById(@PathVariable long id) {
        return skillCategoryService.getSkillCategoryById(id);
    }

    @GetMapping("/getAllSkillCategories")
    public List<SkillCategory> getAllSkillCategories() {
        return skillCategoryService.getAllSkillCategories();
    }

    @PostMapping("/addSkillCategory")
    public void addSkillCategory(@RequestBody SkillCategory skillCategory) {
        skillCategoryService.addSkillCategory(skillCategory);
    }

    @DeleteMapping("/deleteSkillCategory/{id}")
    public void deleteSkillCategory(@PathVariable long id) {
        skillCategoryService.deleteSkillCategory(id);
    }

             

    @PutMapping("/updateSkillCategory")
    public void updateSkillCategory( @RequestBody List<SkillCategory> skillCategory) {
        skillCategoryService.updateSkillCategory(skillCategory);
    }


    @GetMapping("/getSkillsByCategoryId/{id}")
    public List<SkillItem> getSkillsByCategoryId(@PathVariable long id) {
        return  skillCategoryService.getAllSkillItemsByCategoryId(id);
    }
}
