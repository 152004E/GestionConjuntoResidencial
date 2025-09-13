package com.example.Conjunto4.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "asignacion_vigilante")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignacionVigilante {

    // Atributos de la entidad AsignacionVigilante

    // Identificador único id
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    // Turno asignado
    @NotBlank(message = "El turno no puede estar vacío")
    @Column(name = "turno", nullable = false)
    private String turno;

    //Fecha y hora de ingreso
    @NotBlank(message = "La fecha y hora de ingreso no puede estar vacía")
    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDateTime fechaIngreso;

    //Fecha y hora de salida
    @NotBlank(message = "La fecha y hora de salida no puede estar vacía")
    @Column(name = "fecha_salida", nullable = false)
    private LocalDateTime fechaSalida;

    //Relaciones 

    // Relación con Vigilante (Muchos a Uno)
    @ManyToOne
    @JoinColumn(name = "vigilante_id", referencedColumnName = "id", nullable = false)
    private Usuario vigilante;

    // Relación con AreaConjunto (Muchos a Uno)
    @ManyToOne
    @JoinColumn(name = "area_conjunto_id", referencedColumnName = "id", nullable = false)
    private AreaConjunto areaConjunto;



}
