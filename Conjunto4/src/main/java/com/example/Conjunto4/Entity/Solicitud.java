package com.example.Conjunto4.Entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "solicitud")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solicitud {

    // Atributos de la entidad Solicitud

    // Identificador único solicitud_id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solicitud_id")
    private Long id;

    // Fecha y hora de creación de la solicitud
    @NotNull(message = "La fecha y hora de la solicitud no puede estar vacía")
    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHoraCreacion = LocalDateTime.now();

    // Descripción de la solicitud
    @NotBlank(message = "La descripción no puede estar vacía")
    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;

    // Tipode la solicitud
    @NotNull(message = "El tipo de solicitud no puede estar vacío")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_solicitud", nullable = false, length = 50)
    private Enums.SolicitudTipo tipoSolicitud;

    // Estado de la solicitud
    @NotNull(message = "El estado de la solicitud no puede estar vacío")
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_solicitud", nullable = false, length = 50)
    private Enums.SolicitudEstado estadoSolicitud;

    // Relaciones

    // Relación con Usuario 
    @NotNull(message = "El usuario no puede estar vacío")
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    private Usuario usuario;

    // Relación con Apartamento
    @NotNull(message = "El apartamento no puede estar vacío")
    @ManyToOne
    @JoinColumn(name = "id_apartamento", referencedColumnName = "id_apartamento", nullable = false)
    private Apartamento apartamento;

    // Relación con AreaConjunto (opcional, solo si la solicitud es para reservar un área)
    @ManyToOne
    @JoinColumn(name = "area_conjunto_id", referencedColumnName = "id")
    private AreaConjunto areaConjunto;
}
