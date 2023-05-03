package com.web.Portfolio.Service;

import com.web.Portfolio.Model.SobreMi;

public interface InterSobreMiService {
    
    
    public SobreMi getAboutMe(long id);

    public void editAboutMe(long id);

    public void addSobreMi(SobreMi sobreMi);

    
}
