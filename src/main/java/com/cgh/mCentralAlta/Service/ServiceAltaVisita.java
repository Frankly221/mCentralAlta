package com.cgh.mCentralAlta.Service;

import com.cgh.mCentralAlta.Entity.AltaVisita;

public interface ServiceAltaVisita {

    AltaVisita save(AltaVisita altaVisita, String user, String password);
    AltaVisita update(AltaVisita altaVisita, String user, String password);



    
} 