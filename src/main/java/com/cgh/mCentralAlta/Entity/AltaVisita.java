package com.cgh.mCentralAlta.Entity;

import java.time.LocalDateTime;

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
@Table(name = "ALTA_VISITA")
public class AltaVisita {

    
    @Column(name = "CD_LEITO")
    private Long cdLeito;

    @Id
    @Column(name = "CD_ATENDIMENTO")
    private Long cdAtendimento;

    @Column(name = "CD_UNID_INT")
    private Long cdUnidInt;

    @Column(name = "CD_USUARIO")
    private String cdUsuario;

    @Column(name = "DS_OBSERVACION")
    private String dsObservacion;

    @Column(name = "SN_ACTIVO")
    private String snActivo;

    @Column(name = "DH_VISITA")
    private LocalDateTime dhVisita;

    @Column(name = "DH_REABIERTO")
    private LocalDateTime dhReabierto;
}