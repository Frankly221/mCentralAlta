package com.cgh.mCentralAlta.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgh.mCentralAlta.ServiceImpl.ServiceImplDataPacienteHabitacion;



@RestController
@RequestMapping("/v1/data")
public class ControllerPacienteHabitacion {

    @Autowired
    private ServiceImplDataPacienteHabitacion serviceImplDataPacienteHabitacion;

    @GetMapping("/{cdLeito}")
    public ResponseEntity<?> getDetallesPaciente(@PathVariable int cdLeito) {
        try {
            return ResponseEntity.ok(serviceImplDataPacienteHabitacion.findHospitalizedPatient(cdLeito));


        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener datos para el cdLeito: " + cdLeito + ". " + e.getMessage());
        }
    }
}
