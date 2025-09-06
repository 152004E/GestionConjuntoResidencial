package com.miapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "correspondencias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Correspondencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private String fechaRecepcion;
    private String entregadoA;

    @ManyToOne
    @JoinColumn(name = "apartamento_id")
    private Apartamento apartamento;
}
