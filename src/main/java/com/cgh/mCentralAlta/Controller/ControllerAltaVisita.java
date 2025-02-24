package com.cgh.mCentralAlta.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgh.mCentralAlta.Entity.AltaVisita;
import com.cgh.mCentralAlta.ServiceImpl.ServiceImplAltaVisita;

@RestController
@RequestMapping("/v1/altavisita")
public class ControllerAltaVisita {

    @Autowired
    private ServiceImplAltaVisita serviceImplAltaVisita;

    @PostMapping("/{user}/{password}")
    public ResponseEntity<?> guardarAltaVisita(@RequestBody AltaVisita altaVisita,
                                              @PathVariable("user") String user,
                                              @PathVariable("password") String password) {
        try {
            return ResponseEntity.ok(serviceImplAltaVisita.save(altaVisita, user, password));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al guardar AltaVisita: " + e.getMessage());
        }
    }

    @PutMapping("/{activo}")
    public ResponseEntity<?> actualizarAltaVisita(@RequestBody AltaVisita altaVisita,                                              
                                                 @PathVariable("activo") String activo
) {
        try {
            AltaVisita resultado = serviceImplAltaVisita.update(altaVisita,activo);
            if (resultado != null) {
                return ResponseEntity.ok(resultado);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No se encontró la AltaVisita para actualizar");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar AltaVisita: " + e.getMessage());
        }
    }
}