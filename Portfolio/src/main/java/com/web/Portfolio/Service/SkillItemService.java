package com.web.Portfolio.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.Portfolio.Model.SkillCategory;
import com.web.Portfolio.Model.SkillItem;
import com.web.Portfolio.Repository.SkillCategoryRepository;
import com.web.Portfolio.Repository.SkillItemRepository;

@Service
public class SkillItemService implements InterSkillItemService {

    @Autowired
    public SkillItemRepository skillItemRepository;

    @Autowired
    public SkillCategoryRepository skillCategoryRepository;
    
    @Override
    public void addSkillItem(long idCategoria, SkillItem skillItem) {
        SkillCategory categoria = skillCategoryRepository.findById(idCategoria).orElse(null);
        if (categoria != null) {
            categoria.getHabilidades().add(skillItem);
            skillItem.setCategoria(categoria);

            skillItemRepository.save(skillItem);
            skillCategoryRepository.save(categoria);
        }
    }

    @Override
    public List<SkillItem> getAllSkillItems() {
        return skillItemRepository.findAll();
    }

    @Override
    public SkillItem getSkillById(long id) {
        return skillItemRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteSkillItem(long id) {
        skillItemRepository.deleteById(id);

    }

    @Override
    public void updateSkillItem(long id, SkillItem skillItem) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSkillItem'");
    }

  

}
