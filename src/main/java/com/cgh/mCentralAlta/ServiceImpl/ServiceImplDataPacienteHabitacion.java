package com.cgh.mCentralAlta.ServiceImpl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgh.mCentralAlta.Repository.RepositoryDataPacienteHabitacion;
import com.cgh.mCentralAlta.Service.ServiceDataPacienteHabitacion;

@Service

public class ServiceImplDataPacienteHabitacion implements ServiceDataPacienteHabitacion {

    @Autowired
    private RepositoryDataPacienteHabitacion repositoryDataPacienteHabitacion;

    // @Override
    // public List<Map<String, Object>> findHospitalizedPatients(int cdLeito) {

    // List<Object[]> result =
    // repositoryDataPacienteHabitacion.findHospitalizedPatients(cdLeito);

    // List<Map<String, Object>> response = new ArrayList<>();
    // for (Object[] row : result) {
    // Map<String, Object> map = new HashMap<>();
    // map.put("cd_atendimento", row[0]);
    // map.put("cd_unid_int", row[1]);
    // map.put("cd_paciente", row[2]);
    // map.put("nm_paciente", row[3]);
    // map.put("nro_doc", row[4]);
    // map.put("fecha_nac", row[5]);
    // map.put("edad", row[6]);
    // map.put("sexo", row[7]);
    // map.put("cd_especialidad", row[8]);
    // map.put("ds_especialidad", row[9]);
    // map.put("ds_unid_int", row[10]);
    // map.put("hab", row[11]);
    // map.put("cd_leito", row[12]);
    // map.put("medico", row[13]);
    // map.put("fecha_int", row[14]);
    // map.put("nm_convenio", row[15]);
    // map.put("dias_hospi", row[16]);
    // map.put("alta_visita", row[17]);
    // map.put("alta_usuario", row[18]);
    // map.put("ds_observacion", row[19]);
    // map.put("dh_visita", row[20]);

    // response.add(map);
    // }

    // return response;

    // }

    @Override
    public Map<String, Object> findHospitalizedPatient(int cdLeito) {
        List<Object[]> result = repositoryDataPacienteHabitacion.findHospitalizedPatient(cdLeito);
        
        // Check if we have results
        if (result == null || result.isEmpty()) {
            return null; // or you could return an empty map
        }
        
        // Take the first result (assuming we only need one)
        Object[] row = result.get(0);
        
        // Create a map for the single patient
        Map<String, Object> patientMap = new HashMap<>();
        patientMap.put("cd_atendimento", row[0]);
        patientMap.put("cd_unid_int", row[1]);
        patientMap.put("cd_paciente", row[2]);
        patientMap.put("nm_paciente", row[3]);
        patientMap.put("nro_doc", row[4]);
        patientMap.put("fecha_nac", row[5]);
        patientMap.put("edad", row[6]);
        patientMap.put("sexo", row[7]);
        patientMap.put("cd_especialidad", row[8]);
        patientMap.put("ds_especialidad", row[9]);
        patientMap.put("ds_unid_int", row[10]);
        patientMap.put("hab", row[11]);
        patientMap.put("cd_leito", row[12]);
        patientMap.put("medico", row[13]);
        patientMap.put("fecha_int", row[14]);
        patientMap.put("nm_convenio", row[15]);
        patientMap.put("dias_hospi", row[16]);
        patientMap.put("alta_visita", row[17]);
        patientMap.put("alta_usuario", row[18]);
        patientMap.put("ds_observacion", row[19]);
        patientMap.put("dh_visita", row[20]);
        
        return patientMap;
    }
  
}
