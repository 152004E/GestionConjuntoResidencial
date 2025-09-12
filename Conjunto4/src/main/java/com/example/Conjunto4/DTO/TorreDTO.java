package com.example.Conjunto4.DTO;

import java.util.List;

/**
 * DTO para la entidad Torre.
 */
public class TorreDTO {
    private Long id;
    private String nombre;
    private Integer numeroDePisos;
    private List<Long> apartamentosIds;
    public TorreDTO() {}
    public TorreDTO(Long id, String nombre, Integer numeroDePisos, List<Long> apartamentosIds) {
        this.id = id;
        this.nombre = nombre;
        this.numeroDePisos = numeroDePisos;
        this.apartamentosIds = apartamentosIds;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Integer getNumeroDePisos() { return numeroDePisos; }
    public void setNumeroDePisos(Integer numeroDePisos) { this.numeroDePisos = numeroDePisos; }
    public List<Long> getApartamentosIds() { return apartamentosIds; }
    public void setApartamentosIds(List<Long> apartamentosIds) { this.apartamentosIds = apartamentosIds; }
}
