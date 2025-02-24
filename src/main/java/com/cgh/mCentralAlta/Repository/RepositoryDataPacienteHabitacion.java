package com.cgh.mCentralAlta.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cgh.mCentralAlta.Entity.DataPacienteHabitacion;

@Repository

public interface RepositoryDataPacienteHabitacion extends JpaRepository<DataPacienteHabitacion, String> {

    @Query(value = "SELECT DISTINCT V.CD_ATENDIMENTO, " +
            "       V.CD_UNID_INT, " +
            "       V.CD_PACIENTE, " +
            "       V.NM_PACIENTE, " +
            "       V.NRO_DOC, " +
            "       V.FECHA_NAC, " +
            "       V.EDAD, " +
            "       CASE WHEN V.TP_SEXO = 'M' THEN 'MASCULINO' ELSE 'FEMENINO' END AS SEXO, " +
            "       V.CD_ESPECIALID, " +
            "       V.DS_ESPECIALID, " +
            "       V.DS_UNID_INT, " +
            "       V.HAB, " +
            "       L.CD_LEITO, " +
            "       V.MEDICO, " +
            "       V.FECHA_INT, " +
            "       V.NM_CONVENIO, " +
            "       V.DIAS_HOSPI, " +
            "       AV.SN_ACTIVO AS ALTA_VISITA, " +
            "       AV.CD_USUARIO AS ALTA_USUARIO, " +
            "       AV.DS_OBSERVACION, " +
            "       TO_CHAR(AV.DH_VISITA, 'DD/MM/YYYY HH24:MI') AS DH_VISITA " +
            "FROM DBAADV.LISTA_HOSP V " +
            "INNER JOIN DBAMV.ATENDIME A ON A.CD_ATENDIMENTO = V.CD_ATENDIMENTO " +
            "INNER JOIN DBAMV.LEITO L ON L.CD_LEITO = A.CD_LEITO " +
            "LEFT JOIN DBAADV.ALTA_VISITA AV ON AV.CD_ATENDIMENTO = V.CD_ATENDIMENTO AND AV.SN_ACTIVO = 'S' " +
            "WHERE L.CD_LEITO = :cdLeito", nativeQuery = true)
            List<Object[]> findHospitalizedPatient(@Param("cdLeito") Integer cdLeito);
    // List<Object[]> findHospitalizedPatients(@Param("cdLeito") Integer cdLeito);

}
