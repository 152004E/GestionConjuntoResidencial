package com.example.Conjunto4.DTO;

/**
 * DTO para la entidad Apartamento.
 */
public class ApartamentoDTO {
    private Long id;
    private String numero;
    private Integer piso;
    private Long torreId;
    public ApartamentoDTO() {}
    public ApartamentoDTO(Long id, String numero, Integer piso, Long torreId) {
        this.id = id;
        this.numero = numero;
        this.piso = piso;
        this.torreId = torreId;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public Integer getPiso() { return piso; }
    public void setPiso(Integer piso) { this.piso = piso; }
    public Long getTorreId() { return torreId; }
    public void setTorreId(Long torreId) { this.torreId = torreId; }
}
