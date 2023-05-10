package com.web.Portfolio.Service;

import com.web.Portfolio.Model.SobreMi;

public interface InterSobreMiService {
    
    
    public SobreMi getAboutMe();

    public void editAboutMe(SobreMi sobreMi);

    public void addSobreMi(SobreMi sobreMi);

    
}
