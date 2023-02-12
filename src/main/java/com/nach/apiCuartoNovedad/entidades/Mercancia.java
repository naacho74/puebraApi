package com.nach.apiCuartoNovedad.entidades;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nach.apiCuartoNovedad.entidades.Zona;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "mercancias")
public class Mercancia implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="iup")
    private Integer iup;
    @Column(name="volumen")
    private Double volumen;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="tipo_remitente")
    private String tipoRemitente;
    @Column(name="id-remitente")
    private String idRemitente;
    @Column(name="nombre_remitente")
    private String nombreRemitente;
    @Column(name="departamento_remitente")
    private String deptoRemitente;
    @Column(name="municipio_remitente")
    private String municipioRemitente;
    @Column(name="direccion_remitente")
    private String direccionRemitente;

    @Column(name="tipo_destinatario")
    private String tipoDestinatario;
    @Column(name="id_destinatario")
    private String idDestinatario;
    @Column(name="nombre_destinatario")
    private String nombreDestinatario;
    @Column(name="departamento_destinatario")
    private String deptoDestinatario;
    @Column(name="municipio_destinatario")
    private String municipioDestinatario;
    @Column(name="direccion_destinatario")
    private String direccionDestinatario;

   @ManyToOne(optional = false)
   @JoinColumn(name="fk_zona",referencedColumnName = "id")
   @JsonBackReference
   private   Zona zona;

    public Mercancia() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public Integer getIup() {
        return iup;
    }

    public void setIup(Integer iup) {
        this.iup = iup;
    }

    public Double getVolumen() {
        return volumen;
    }

    public void setVolumen(Double volumen) {
        this.volumen = volumen;
    }

    public String getdescripcion() {
        return descripcion;
    }

    public void setdescripcion(String descripcion) {
        descripcion = descripcion;
    }

    public String getTipoRemitente() {
        return tipoRemitente;
    }

    public void setTipoRemitente(String tipoRemitente) {
        this.tipoRemitente = tipoRemitente;
    }

    public String getIdRemitente() {
        return idRemitente;
    }

    public void setIdRemitente(String idRemitente) {
        this.idRemitente = idRemitente;
    }

    public String getNombreRemitente() {
        return nombreRemitente;
    }

    public void setNombreRemitente(String nombreRemitente) {
        this.nombreRemitente = nombreRemitente;
    }

    public String getDeptoRemitente() {
        return deptoRemitente;
    }

    public void setDeptoRemitente(String deptoRemitente) {
        this.deptoRemitente = deptoRemitente;
    }

    public String getMunicipioRemitente() {
        return municipioRemitente;
    }

    public void setMunicipioRemitente(String municipioRemitente) {
        this.municipioRemitente = municipioRemitente;
    }

    public String getDireccionRemitente() {
        return direccionRemitente;
    }

    public void setDireccionRemitente(String direccionRemitente) {
        this.direccionRemitente = direccionRemitente;
    }

    public String getTipoDestinatario() {
        return tipoDestinatario;
    }

    public void setTipoDestinatario(String tipoDestinatario) {
        this.tipoDestinatario = tipoDestinatario;
    }

    public String getIdDestinatario() {
        return idDestinatario;
    }

    public void setIdDestinatario(String idDestinatario) {
        this.idDestinatario = idDestinatario;
    }

    public String getNombreDestinatario() {
        return nombreDestinatario;
    }

    public void setNombreDestinatario(String nombreDestinatario) {
        this.nombreDestinatario = nombreDestinatario;
    }

    public String getDeptoDestinatario() {
        return deptoDestinatario;
    }

    public void setDeptoDestinatario(String deptoDestinatario) {
        this.deptoDestinatario = deptoDestinatario;
    }

    public String getMunicipioDestinatario() {
        return municipioDestinatario;
    }

    public void setMunicipioDestinatario(String municipioDestinatario) {
        this.municipioDestinatario = municipioDestinatario;
    }

    public String getDireccionDestinatario() {
        return direccionDestinatario;
    }

    public void setDireccionDestinatario(String direccionDestinatario) {
        this.direccionDestinatario = direccionDestinatario;
    }


}
