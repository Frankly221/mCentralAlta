package com.cgh.mCentralAlta.ServiceImpl;


import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cgh.mCentralAlta.Entity.AltaVisita;
import com.cgh.mCentralAlta.Repository.RepositoryAltaVisita;
import com.cgh.mCentralAlta.Service.ServiceAltaVisita;
import javax.persistence.Query;

@Service
@Transactional
public class ServiceImplAltaVisita implements ServiceAltaVisita {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private RepositoryAltaVisita repositoryAltaVisita;

    @Override
    public AltaVisita save(AltaVisita altaVisita, String user, String password) {

        // Verificamos si el usuario existe y está autenticado
        String authQuery = "SELECT COUNT(*) FROM DBASGU.USUARIOS U " +
                "WHERE U.CD_USUARIO = ? AND UPPER(DBAADV.VER_CONTRASENA(U.CD_USUARIO)) = ?";

        Query authStmt = entityManager.createNativeQuery(authQuery);
        authStmt.setParameter(1, user.toUpperCase());
        authStmt.setParameter(2, password.toUpperCase());

        Long authCount = ((Number) authStmt.getSingleResult()).longValue();

        if (authCount == 0) {
            throw new RuntimeException("Autenticación fallida para el usuario: " + user);
        }

        // Si el usuario existe, procedemos con el guardado
        altaVisita.setDhVisita(LocalDateTime.now());
        return repositoryAltaVisita.save(altaVisita);
    }

    @Override
    public AltaVisita update(AltaVisita altaVisita, String user, String password) {
        // Verificamos si el usuario existe y está autenticado
        String authQuery = "SELECT COUNT(*) FROM DBASGU.USUARIOS U " +
                "WHERE U.CD_USUARIO = ? AND UPPER(DBAADV.VER_CONTRASENA(U.CD_USUARIO)) = ?";

        Query authStmt = entityManager.createNativeQuery(authQuery);
        authStmt.setParameter(1, user.toUpperCase());
        authStmt.setParameter(2, password.toUpperCase());

        Long authCount = ((Number) authStmt.getSingleResult()).longValue();

        if (authCount == 0) {
            throw new RuntimeException("Autenticación fallida para el usuario: " + user);
        }
        

        // Buscar el registro existente
        AltaVisita existingVisita = repositoryAltaVisita.findByCdAtendimentoAndCdUnidInt(
            altaVisita.getCdAtendimento(), 
            altaVisita.getCdUnidInt()
        );

        // Verificar si se encontró el registro
        if (existingVisita == null) {

            throw new RuntimeException("No se encontró la visita para actualizar");
        }

        
        // Actualizar los campos necesarios
        existingVisita.setSnActivo(altaVisita.getSnActivo());
        existingVisita.setDhReabierto(LocalDateTime.now());
        existingVisita.setCdUsuario(user.toUpperCase());
        
        // Si hay observaciones, actualizarlas
        if (altaVisita.getDsObservacion() != null && !altaVisita.getDsObservacion().isEmpty()) {
            existingVisita.setDsObservacion(altaVisita.getDsObservacion());
        }

        // Guardar los cambios
        return repositoryAltaVisita.save(existingVisita);
    }

}
