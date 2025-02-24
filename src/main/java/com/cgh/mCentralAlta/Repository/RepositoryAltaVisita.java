package com.cgh.mCentralAlta.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cgh.mCentralAlta.Entity.AltaVisita;

@Repository
public interface RepositoryAltaVisita extends JpaRepository<AltaVisita, Long> {

    AltaVisita findByCdAtendimentoAndCdUnidInt(Long cdAtendimento, Long cdUnidInt);
    
}
