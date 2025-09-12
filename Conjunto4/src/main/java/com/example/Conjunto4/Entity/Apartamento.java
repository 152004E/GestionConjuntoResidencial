package com.example.Conjunto4.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "apartamentos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apartamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apartamento")
    private Long id;

    private String numero;

    // FK al propietario (Usuario con rol = propietario)
    @ManyToOne
    @JoinColumn(name = "id_propietario")
    private Usuario propietario;

    // FK al residente (Usuario con rol = residente)
    @ManyToOne
    @JoinColumn(name = "id_residente")
    private Usuario residente;

    // FK a Torre
    @ManyToOne
    @JoinColumn(name = "id_torre")
    private Torre torre;

    @OneToMany(mappedBy = "apartamento")
    private List<Parqueadero> parqueaderos;

    @OneToMany(mappedBy = "apartamento")
    private List<Correspondencia> correspondencias;
}