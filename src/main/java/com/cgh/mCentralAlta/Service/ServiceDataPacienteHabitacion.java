package com.cgh.mCentralAlta.Service;

import java.util.Map;



public interface ServiceDataPacienteHabitacion {
    // List<Map<String,Object>> findHospitalizedPatients(int cdLeito);
    Map<String, Object> findHospitalizedPatient(int cdLeito);
}
