package com.example.Conjunto4.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "area_conjunto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AreaConjunto {

    // Atributos de la entidad AreaConjunto

    // Identificador único id 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // Nombre del área
    @NotBlank(message = "El nombre del área no puede estar vacío")
    @Size(max = 100, message = "El nombre del área no puede tener más de 100 caracteres")
    @Column(name = "nombre_area", nullable = false, length = 100, unique = true)
    private String nombreArea;

    // Descripción
    @Size(max = 255, message = "La descripción no puede tener más de 255 caracteres")
    @Column(name = "descripcion", length = 255)
    private String descripcion;

    // Capacidad
    @NotNull(message = "La capacidad no puede estar vacía")
    @Min(value = 1, message = "La capacidad mínima es 1")
    @Column(name = "capacidad", nullable = false)
    private Integer capacidad;

    // Tipo de área
    @NotNull(message = "El tipo de área no puede estar vacío")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_area", nullable = false)
    private Enums.AreaTipo tipoArea;  // Social u Operativa (archivo Enums.java)

   //Reservable
    @NotNull(message = "El campo reservable no puede estar vacío")
    @Column(name = "reservable", nullable = false)
    private Boolean reservable; // true = se puede reservar, false = no
}