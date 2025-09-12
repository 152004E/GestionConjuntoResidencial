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
    private Long id;

    private String numero;
    private String torre;
    private int piso;

    @ManyToOne
    @JoinColumn(name = "propietario_id")
    private Propietario propietario;

    @OneToMany(mappedBy = "apartamento")
    private List<Residente> residentes;

    @OneToMany(mappedBy = "apartamento")
    private List<Visitante> visitantes;

    @OneToMany(mappedBy = "apartamento")
    private List<Parqueadero> parqueaderos;

    @OneToMany(mappedBy = "apartamento")
    private List<Correspondencia> correspondencias;
}
