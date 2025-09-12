package com.example.Conjunto4.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "area_conjunto")//Nombre de la tabla AreaConjunto
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AreaConjunto {

    //Atributos de la entidad AreaConjunto

    //Llave primaria id 
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Nombre del area del conjunto
    @Column(name = "nombre_area", nullable = false, length = 100)
    private String nombreArea;

    //Descripcion del area del conjunto
    @Column(name = "descripcion", length = 255)
    private String descripcion;

    //Capacidad del area del conjunto
    @Column(name = "capacidad")
    private Integer capacidad;

    //Tipo de area del conjunto (social o operativa)
    @Column(name = "tipo_area", nullable = false, length = 50)
    private String tipoArea;

    //Reservable (si o no)
    @Column(name = "reservable", nullable = false)
    private Boolean reservable;

}
