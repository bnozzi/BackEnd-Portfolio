package com.web.Portfolio.Service;

import java.util.List;

import com.web.Portfolio.Model.SkillCategory;
import com.web.Portfolio.Model.SkillItem;

public interface InterSkillItemService {

    public List<SkillItem> getAllSkillItems();
    
    public SkillItem getSkillById(long id);


    public void deleteSkillItem(long id);

    public void updateSkillItem(long id, SkillItem skillItem);

    public void addSkillItem(long categoria, SkillItem skillItem);
    
}
