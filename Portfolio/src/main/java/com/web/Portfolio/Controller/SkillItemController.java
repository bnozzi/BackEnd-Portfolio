package com.web.Portfolio.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.Portfolio.Model.SkillCategory;
import com.web.Portfolio.Model.SkillItem;
import com.web.Portfolio.Service.SkillItemService;

@RestController
public class SkillItemController {

    @Autowired
    private SkillItemService skillItemService;

    @GetMapping("/skillitems")
    public List<SkillItem> getAllSkillItems() {
        return skillItemService.getAllSkillItems();
    }

    @GetMapping("/skillitems/{id}")
    public SkillItem getSkillItemById(@PathVariable Long id) {
        return skillItemService.getSkillById(id);
    }

    @PostMapping("/addSkillitem/{idCategory}")
    public void saveSkillItem(@PathVariable long idCategory, @RequestBody SkillItem skillItem) {
        skillItemService.addSkillItem(idCategory, skillItem);
        
    }

    @DeleteMapping("/skillitems/{id}")
    public void deleteSkillItem(@PathVariable Long id) {
        skillItemService.deleteSkillItem(id);
    }

}