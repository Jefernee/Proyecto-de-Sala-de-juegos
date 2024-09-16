/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;
import java.sql.Timestamp;
import java.time.LocalDateTime;
/**
 *
 * @author jefer
 */
public class Finanzas {
    
    private int idFinanza;
    private String nombreFinanza;
    private String descripcion;
    private int montoMaquinas;
    private int montoFutbolin;
    private int montoLuz;
    private int montoAgua;
    private int montoInternet;
    private int montoPlan;
    private int montoFinalFinanza;
    private LocalDateTime fecha;
    private String usuarioCreacion;
    private LocalDateTime fechaCreacion;
    private String usuarioModificador;
    private LocalDateTime fechaModificacion;
    
    public Finanzas() {
        // Constructor por defecto
    }

    public int getIdFinanza() {
        return idFinanza;
    }

    public void setIdFinanza(int idFinanza) {
        this.idFinanza = idFinanza;
    }

    public String getNombreFinanza() {
        return nombreFinanza;
    }

    public void setNombreFinanza(String nombreFinanza) {
        this.nombreFinanza = nombreFinanza;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getMontoMaquinas() {
        return montoMaquinas;
    }

    public void setMontoMaquinas(int montoMaquinas) {
        this.montoMaquinas = montoMaquinas;
    }

    public int getMontoFutbolin() {
        return montoFutbolin;
    }

    public void setMontoFutbolin(int montoFutbolin) {
        this.montoFutbolin = montoFutbolin;
    }

    public int getMontoLuz() {
        return montoLuz;
    }

    public void setMontoLuz(int montoLuz) {
        this.montoLuz = montoLuz;
    }

    public int getMontoAgua() {
        return montoAgua;
    }

    public void setMontoAgua(int montoAgua) {
        this.montoAgua = montoAgua;
    }

    public int getMontoInternet() {
        return montoInternet;
    }

    public void setMontoInternet(int montoInternet) {
        this.montoInternet = montoInternet;
    }

    public int getMontoPlan() {
        return montoPlan;
    }

    public void setMontoPlan(int montoPlan) {
        this.montoPlan = montoPlan;
    }

    public Integer getMontoFinalFinanza() {
        return montoFinalFinanza;
    }

    public void setMontoFinalFinanza(Integer montoFinalFinanza) {
        this.montoFinalFinanza = montoFinalFinanza;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
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
