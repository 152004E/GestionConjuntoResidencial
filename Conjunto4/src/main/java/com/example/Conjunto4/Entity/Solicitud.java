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

    // Identificador único id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solicitud_id", nullable = false)
    private Long id;

    // Fecha y hora creación de la solicitud
    @NotNull(message = "La fecha y hora de la solicitud no puede estar vacía")
    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHoraCreacion = LocalDateTime.now();

    //Descripción de la solicitud
    @NotBlank(message = "La descripción no puede estar vacía")
    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;

    //Tipo de solicitud
    @NotNull(message = "El tipo de solicitud no puede estar vacío")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_solicitud", nullable = false)
    private Enums.SolicitudTipo tipoSolicitud;  // Mantenimiento, Queja, Reclamación, etc. (archivo Enums.java)

    //Estado de la solicitud
    @NotNull(message = "El estado de la solicitud no puede estar vacío")
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_solicitud", nullable = false)
    private Enums.SolicitudEstado estadoSolicitud;  // Pendiente, Aprobada, Rechazada (archivo Enums.java)

    //Relaciones

    // Relación con Usuario (quien hace la solicitud)
    @NotNull(message = "El usuario no puede estar vacío")
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = false)
    private Usuario usuario;

    // Relación con Apartamento
    @NotNull(message = "El apartamento no puede estar vacío")
    @ManyToOne
    @JoinColumn(name = "id_apartamento", referencedColumnName = "id", nullable = false)
    private Apartamento apartamento;

    // Relacion con AreaConjunto (solicitude de reserva de un área)
    @ManyToOne
    @JoinColumn(name = "area_conjunto_id", referencedColumnName = "id")
    private AreaConjunto areaConjunto;

    

}
