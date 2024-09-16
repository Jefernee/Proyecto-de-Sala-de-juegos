/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;
import java.time.LocalDate;
import java.sql.Time;
import java.time.LocalDateTime;
/**
 *
 * @author jefer
 */
public class Clientes {
    private int idCliente;
    private String nombre;
    private LocalDate fecha;
    private String descripcion;
    private String tiempoPagado;
    private Time horaInicial;
    private Time horaFinal;
    private String tiempoPendiente;
    private char numeroplay;
    private String juegosJugados;
    private int controlAdicional;
    private Integer mesaPingPong;
    private Integer play4;
    private Integer play5;
    private int totalJugado;
    private String telefono;
    private String usuarioCreacion;
    private LocalDateTime fechaCreacion;
    private String usuarioModificador;
    private LocalDateTime fechaModificacion;
    
    public Clientes(){ //constructor por defecto
        
    }
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTiempoPagado() {
        return tiempoPagado;
    }

    public void setTiempoPagado(String tiempoPagado) {
        this.tiempoPagado = tiempoPagado;
    }

    public Time getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Time horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Time getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Time horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getTiempoPendiente() {
        return tiempoPendiente;
    }

    public void setTiempoPendiente(String tiempoPendiente) {
        this.tiempoPendiente = tiempoPendiente;
    }

    public char getNumeroplay() {
        return numeroplay;
    }

    public void setNumeroplay(char numeroplay) {
        this.numeroplay = numeroplay;
    }

    public String getJuegosJugados() {
        return juegosJugados;
    }

    public void setJuegosJugados(String juegosJugados) {
        this.juegosJugados = juegosJugados;
    }

    public int getControlAdicional() {
        return controlAdicional;
    }

    public void setControlAdicional(int controlAdicional) {
        this.controlAdicional = controlAdicional;
    }

    public Integer getMesaPingPong() {
        return mesaPingPong;
    }

    public void setMesaPingPong(Integer mesaPingPong) {
        this.mesaPingPong = mesaPingPong;
    }

    public Integer getPlay4() {
        return play4;
    }

    public void setPlay4(Integer play4) {
        this.play4 = play4;
    }

    public Integer getPlay5() {
        return play5;
    }

    public void setPlay5(Integer play5) {
        this.play5 = play5;
    }

    public int getTotalJugado() {
        return totalJugado;
    }

    public void setTotalJugado(int totalJugado) {
        this.totalJugado = totalJugado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
