package com.web.Portfolio.Service;

import java.util.List;

import com.web.Portfolio.Model.RedSocial;

public interface InterRedSocialService {
    
public List<RedSocial> getSocialsNetworks();

public RedSocial getRedSocial(long id);

public void addRedSocial(RedSocial redSocial);

public void deleteRedSocial(long id);

public void updateRedSocial(RedSocial redSocial);

}
