package com.cgh.mCentralAlta.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LISTA_HOSP")


public class DataPacienteHabitacion {


    @Id
    @Column(name = "CD_PACIENTE")
    private String cdpaciente;
    
}
