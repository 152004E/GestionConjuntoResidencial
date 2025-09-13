package com.example.Conjunto4.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "parqueaderos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parqueadero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;
    private String tipo;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "apartamento_id")
    private Apartamento apartamento;
}
