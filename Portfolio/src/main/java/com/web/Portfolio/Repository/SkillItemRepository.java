package com.web.Portfolio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.Portfolio.Model.SkillItem;

public interface SkillItemRepository extends JpaRepository<SkillItem,Long>{
    
}
