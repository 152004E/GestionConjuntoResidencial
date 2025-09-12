package com.example.Conjunto4.Entity;

import jakarta.persistence.*;
import java.util.List;

/**
 * Entidad que representa una Torre en el conjunto residencial.
 */
@Entity
public class Torre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer numeroDePisos;
    @OneToMany(mappedBy = "torre", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Apartamento> apartamentos;
    public Torre() {}
    public Torre(Long id, String nombre, Integer numeroDePisos, List<Apartamento> apartamentos) {
        this.id = id;
        this.nombre = nombre;
        this.numeroDePisos = numeroDePisos;
        this.apartamentos = apartamentos;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Integer getNumeroDePisos() { return numeroDePisos; }
    public void setNumeroDePisos(Integer numeroDePisos) { this.numeroDePisos = numeroDePisos; }
    public List<Apartamento> getApartamentos() { return apartamentos; }
    public void setApartamentos(List<Apartamento> apartamentos) { this.apartamentos = apartamentos; }
}
