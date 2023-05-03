package com.web.Portfolio.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.Portfolio.Model.RedSocial;
import com.web.Portfolio.Service.RedSocialService;

@RestController
public class RedSocialController {
    

    @Autowired
    private RedSocialService redSocialService;

    @GetMapping("/getRedesSociales")
    public List<RedSocial> getAllRedSocial() {
        return redSocialService.getSocialsNetworks();
    }

    @GetMapping("/getRedSocial/{id}")
    public RedSocial getSkillItemById(@PathVariable Long id) {
        return redSocialService.getRedSocial(id);
    }

    @PostMapping("/addRedSocial")
    public void saveSkillItem(@RequestBody RedSocial redSocial) {
        redSocialService.addRedSocial(redSocial);
        
    }

    @DeleteMapping("/deleteRedSocial/{id}")
    public void deleteSkillItem(@PathVariable Long id) {
        redSocialService.deleteRedSocial(id);
    }

}
