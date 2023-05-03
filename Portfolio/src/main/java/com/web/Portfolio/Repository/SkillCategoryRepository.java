package com.web.Portfolio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.Portfolio.Model.SkillCategory;


public interface SkillCategoryRepository extends JpaRepository<SkillCategory,Long>{
    
}
