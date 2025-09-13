package com.example.Conjunto4.Entity;

import jakarta.persistence.*; // ✅ Importa todas las anotaciones de JPA
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List; // ✅ Necesario para las listas


@Entity
@Table(name = "apartamentos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apartamento {

    // Identificador único del apartamento.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apartamento")
    private Long id;

    
    // Número del apartamento dentro de la torre.
    private String numero;

    // FK al propietario (Usuario con rol = propietario)


    //Piso donde se encuentra el apartamento.
    private int piso;


    // Nombre de la torre (se podría reemplazar por relación ManyToOne si se tiene entidad Torre)
    private String torre;

    //Propietario del apartamento.
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

    // Lista de residentes que habitan en el apartamento.
    @OneToMany(mappedBy = "apartamento")
    private List<Residente> residentes;

    //Lista de visitantes asociados al apartamento.

    @OneToMany(mappedBy = "apartamento")
    private List<Visitante> visitantes;

    //Lista de parqueaderos asociados al apartamento.

    @OneToMany(mappedBy = "apartamento")
    private List<Parqueadero> parqueaderos;

    // Lista de correspondencias asociadas al apartamento.

    @OneToMany(mappedBy = "apartamento")
    private List<Correspondencia> correspondencias;
}