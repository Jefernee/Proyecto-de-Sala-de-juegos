/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;
import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 *
 * @author jefer
 */
public class Informes {
    private int idInforme;
    private String nombreInforme;
    private String descripcionInforme;
    private LocalDate fechaInforme;
    private LocalDate fechaInicialInforme;
    private LocalDate fechaFinalInforme;
    private Integer montoInformePersonalizado;
    private Integer montoMesInforme;
    private Integer montoAñoInforme;
    private Integer totalPagos;
    private Integer totalGanancias;
    private String usuarioCreacion;
    private LocalDateTime fechaCreacion;
    private String usuarioModificador;
    private LocalDateTime fechaModificacion;
    
    // Constructor por defecto
    public Informes() {
        // Constructor vacío
    }
    
    // Getters y setters
    public int getIdInforme() {
        return idInforme;
    }

    public void setIdInforme(int idInforme) {
        this.idInforme = idInforme;
    }

    public String getNombreInforme() {
        return nombreInforme;
    }

    public void setNombreInforme(String nombreInforme) {
        this.nombreInforme = nombreInforme;
    }

    public String getDescripcionInforme() {
        return descripcionInforme;
    }

    public void setDescripcionInforme(String descripcionInforme) {
        this.descripcionInforme = descripcionInforme;
    }

    public LocalDate getFechaInforme() {
        return fechaInforme;
    }

    public void setFechaInforme(LocalDate fechaInforme) {
        this.fechaInforme = fechaInforme;
    }

    public LocalDate getFechaInicialInforme() {
        return fechaInicialInforme;
    }

    public void setFechaInicialInforme(LocalDate fechaInicialInforme) {
        this.fechaInicialInforme = fechaInicialInforme;
    }

    public LocalDate getFechaFinalInforme() {
        return fechaFinalInforme;
    }

    public void setFechaFinalInforme(LocalDate fechaFinalInforme) {
        this.fechaFinalInforme = fechaFinalInforme;
    }

    public Integer getMontoInformePersonalizado() {
        return montoInformePersonalizado;
    }

    public void setMontoInformePersonalizado(Integer montoInformePersonalizado) {
        this.montoInformePersonalizado = montoInformePersonalizado;
    }

    public Integer getMontoMesInforme() {
        return montoMesInforme;
    }

    public void setMontoMesInforme(Integer montoMesInforme) {
        this.montoMesInforme = montoMesInforme;
    }

    public Integer getMontoAñoInforme() {
        return montoAñoInforme;
    }

    public void setMontoAñoInforme(Integer montoAñoInforme) {
        this.montoAñoInforme = montoAñoInforme;
    }

    public Integer getTotalPagos() {
        return totalPagos;
    }

    public void setTotalPagos(Integer totalPagos) {
        this.totalPagos = totalPagos;
    }

    public Integer getTotalGanancias() {
        return totalGanancias;
    }

    public void setTotalGanancias(Integer totalGanancias) {
        this.totalGanancias = totalGanancias;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioModificador() {
        return usuarioModificador;
    }

    public void setUsuarioModificador(String usuarioModificador) {
        this.usuarioModificador = usuarioModificador;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    
}
