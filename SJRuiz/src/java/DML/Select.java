/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DML;

import Entidades.InventarioSala;
import Entidades.Clientes;
import Entidades.Finanzas;
import Entidades.Informes;
import Entidades.Horas;
import Entidades.Usuarios;
import Entidades.Roles;
import SQL.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.LocalDate;

/**
 *
 * @author jefer
 */
public class Select {

    Conexion c = new Conexion();
    Connection conn = null;
    ArrayList<InventarioSala> listaProductos;
    InventarioSala inventariosala;
    ArrayList<Clientes> listaClientes;
    Clientes clientes;
    ArrayList<Finanzas> listaFinanzas;
    Finanzas finanzas;
    ArrayList<Horas> listaHoras;
    Horas horas;
    ArrayList<Usuarios> listaUsuarios;
    Usuarios usuarios;
    ArrayList<Informes> listaInformes;
    Informes informes;
    ArrayList<Roles> listaRoles;
    Roles roles;

    public ArrayList<InventarioSala> BuscarProductos() throws SQLException {
        String query = "SELECT idProducto, nombreProducto, descripcionProducto, fechaCompra, garantia, cantidad, precioComprado, lugarComprado, telefonoLugar, estadoProducto, descripcionProblema, descripcionReparación, usuarioCreacion, fechaCreacion, usuarioModificador, fechaModificacion FROM inventarioSala";
        conn = c.conectar();
        listaProductos = new ArrayList();
        

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                inventariosala = new InventarioSala();
                inventariosala.setIdProducto(rs.getString("idProducto"));
                inventariosala.setNombreProducto(rs.getString("nombreProducto"));
                inventariosala.setDescripcionProducto(rs.getString("descripcionProducto"));
                inventariosala.setFechaCompra(rs.getDate("fechaCompra"));
                inventariosala.setGarantia(rs.getString("garantia"));
                inventariosala.setCantidad(rs.getInt("cantidad"));
                inventariosala.setPrecioComprado(rs.getInt("precioComprado"));
                inventariosala.setLugarComprado(rs.getString("lugarComprado"));
                inventariosala.setTelefonoLugar(rs.getString("telefonoLugar"));
                inventariosala.setEstadoProducto(rs.getString("estadoProducto"));
                inventariosala.setDescripcionProblema(rs.getString("descripcionProblema"));
                inventariosala.setDescripcionReparacion(rs.getString("descripcionReparación"));
                inventariosala.setUsuarioCreacion(rs.getString("usuarioCreacion"));
                LocalDateTime fechaCreacion = rs.getObject("fechaCreacion", LocalDateTime.class);
                inventariosala.setFechaCreacion(fechaCreacion);
                inventariosala.setUsuarioModificador(rs.getString("usuarioModificador") != null ? rs.getString("usuarioModificador") : null);
                LocalDateTime fechaModificacion = rs.getObject("fechaModificacion", LocalDateTime.class);
                inventariosala.setFechaModificacion(fechaModificacion);
                listaProductos.add(inventariosala);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return listaProductos;
    }
    
    public ArrayList<Clientes> BuscarClientes() throws SQLException {
        String query = "SELECT idCliente, nombre, fecha, descripcion, tiempoPagado, horaInicial, horaFinal, tiempoPendiente, numeroplay, juegosJugados, controlAdicional, mesaPingPong, play4, play5, totalJugado, telefono, usuarioCreacion, fechaCreacion, usuarioModificador, fechaModificacion FROM clientes;";
        conn = c.conectar();
        listaClientes = new ArrayList();
        

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                clientes = new Clientes();
                clientes.setIdCliente(rs.getInt("idCliente"));
                clientes.setNombre(rs.getString("nombre"));
                LocalDate fechaCliente = rs.getObject("fecha", LocalDate.class);
                clientes.setFecha(fechaCliente);
                clientes.setDescripcion(rs.getString("descripcion"));
                clientes.setTiempoPagado(rs.getString("tiempoPagado"));
                clientes.setHoraInicial(rs.getTime("horaInicial"));
                clientes.setHoraFinal(rs.getTime("horaFinal"));
                clientes.setTiempoPendiente(rs.getString("tiempoPendiente"));
                clientes.setNumeroplay(rs.getString("numeroplay").charAt(0));
                clientes.setJuegosJugados(rs.getString("juegosJugados"));
                clientes.setControlAdicional(rs.getInt("controlAdicional"));
                clientes.setMesaPingPong(rs.getInt("mesaPingPong"));
                clientes.setPlay4(rs.getInt("play4"));
                clientes.setPlay5(rs.getInt("play5"));
                clientes.setTotalJugado(rs.getInt("totalJugado"));
                clientes.setTelefono(rs.getString("telefono")); 
                clientes.setUsuarioCreacion(rs.getString("usuarioCreacion"));
                LocalDateTime fechaCreacion = rs.getObject("fechaCreacion", LocalDateTime.class);
                clientes.setFechaCreacion(fechaCreacion);
                clientes.setUsuarioModificador(rs.getString("usuarioModificador") != null ? rs.getString("usuarioModificador") : null);
                LocalDateTime fechaModificacion = rs.getObject("fechaModificacion", LocalDateTime.class);
                clientes.setFechaModificacion(fechaModificacion);
                listaClientes.add(clientes);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return listaClientes;
    }
    
    public ArrayList<Finanzas> BuscarFinanzas() throws SQLException {
        String query = "SELECT idfinanza, nombreFinanza, descripcion, montoMaquinas, montoFutbolin, montoLuz, montoAgua, montoInternet, montoPlan, montoFinalFinanza, fecha, usuarioCreacion, fechaCreacion, usuarioModificador, fechaModificacion FROM finanzas;";
        conn = c.conectar();
        listaFinanzas = new ArrayList();
        

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                finanzas = new Finanzas();
                finanzas.setIdFinanza(rs.getInt("idfinanza"));
                finanzas.setNombreFinanza(rs.getString("nombreFinanza"));
                finanzas.setDescripcion(rs.getString("descripcion"));
                finanzas.setMontoMaquinas(rs.getInt("montoMaquinas"));
                finanzas.setMontoFutbolin(rs.getInt("montoFutbolin"));
                finanzas.setMontoLuz(rs.getInt("montoLuz"));
                finanzas.setMontoAgua(rs.getInt("montoAgua"));
                finanzas.setMontoInternet(rs.getInt("montoInternet"));
                finanzas.setMontoPlan(rs.getInt("montoPlan"));
                finanzas.setMontoFinalFinanza(rs.getInt("montoFinalFinanza"));
                finanzas.setFecha(rs.getObject("fecha", LocalDateTime.class));
                finanzas.setUsuarioCreacion(rs.getString("usuarioCreacion"));
                LocalDateTime fechaCreacion = rs.getObject("fechaCreacion", LocalDateTime.class);
                finanzas.setFechaCreacion(fechaCreacion);
                finanzas.setUsuarioModificador(rs.getString("usuarioModificador") != null ? rs.getString("usuarioModificador") : null);
                LocalDateTime fechaModificacion = rs.getObject("fechaModificacion", LocalDateTime.class);
                finanzas.setFechaModificacion(fechaModificacion);
                listaFinanzas.add(finanzas);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return listaFinanzas;
    }
    
    public ArrayList<Horas> BuscarHoras() throws SQLException {
        String query = "SELECT idCosto, tipoJuego, costoHora, usuarioCreacion, fechaCreacion, usuarioModificador, fechaModificacion FROM costosHorasdejuego;";
        conn = c.conectar();
        Select select = new Select();
        listaHoras = new ArrayList();
        

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                horas = new Horas();
                horas.setIdCosto(rs.getInt("idCosto"));
                horas.setTipoJuego(rs.getString("tipoJuego"));
                horas.setCostoHora(rs.getInt("costoHora"));
                horas.setUsuarioCreacion(rs.getString("usuarioCreacion"));
                horas.setFechaCreacion(rs.getTimestamp("fechaCreacion").toLocalDateTime());
                horas.setUsuarioModificador(rs.getString("usuarioModificador") != null ? rs.getString("usuarioModificador") : null);
                horas.setFechaModificacion(rs.getTimestamp("fechaModificacion")!= null ? rs.getTimestamp("fechaModificacion").toLocalDateTime() : null); 
                listaHoras.add(horas);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return listaHoras;
    }
    
    public ArrayList<Usuarios> BuscarUsuarios() throws SQLException {
        String query = "SELECT idUsuario, idRol, nombre, usuario, correoElectronico, contraseña, estado, telefono, rolUsuario, usuarioCreacion, fechaCreacion, usuarioModificador, fechaModificacion FROM usuarios;";
        conn = c.conectar();
        listaUsuarios = new ArrayList();
        

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                usuarios = new Usuarios();
                usuarios.setIdUsuario(rs.getInt("idUsuario"));
                usuarios.setIdRol(rs.getInt("idRol"));
                usuarios.setNombre(rs.getString("nombre"));
                usuarios.setUsuario(rs.getString("usuario"));
                usuarios.setCorreoElectronico(rs.getString("correoElectronico"));
                usuarios.setContraseña(rs.getString("contraseña"));
                usuarios.setEstado(rs.getString("estado"));
                usuarios.setTelefono(rs.getString("telefono"));
                usuarios.setRolUsuario(rs.getString("rolUsuario"));
                usuarios.setUsuarioCreacion(rs.getString("usuarioCreacion"));
                usuarios.setFechaCreacion(rs.getTimestamp("fechaCreacion").toLocalDateTime());
                usuarios.setUsuarioModificador(rs.getString("usuarioModificador") != null ? rs.getString("usuarioModificador") : null);
                usuarios.setFechaModificacion(rs.getTimestamp("fechaModificacion")!= null ? rs.getTimestamp("fechaModificacion").toLocalDateTime() : null); 
                listaUsuarios.add(usuarios);
            }
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la consulta SQL: " + ex.getMessage());
            ex.printStackTrace(); // Esto imprimirá el stack trace completo de la excepción
        }

        return listaUsuarios;
    }

    public ArrayList<Informes> BuscarInformes() throws SQLException {
        String query = "SELECT idInforme, nombreInforme, descripcionInforme, fechaInforme, fechaInicialInforme, fechaFinalInforme, montoInformePersonalizado, montoMesInforme, montoAñoInforme, totalPagos, totalGanancias, usuarioCreacion, fechaCreacion, usuarioModificador, fechaModificacion FROM informes;";
        conn = c.conectar();
        listaInformes = new ArrayList();
        

        try {           
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                informes = new Informes();
                informes.setIdInforme(rs.getInt("idInforme"));
                informes.setNombreInforme(rs.getString("nombreInforme"));
                informes.setDescripcionInforme(rs.getString("descripcionInforme"));
                informes.setFechaInforme(rs.getObject("fechaInforme", LocalDate.class));
                informes.setFechaInicialInforme(rs.getObject("fechaInicialInforme", LocalDate.class));
                informes.setFechaFinalInforme(rs.getObject("fechaFinalInforme", LocalDate.class));          
                informes.setMontoInformePersonalizado(rs.getInt("montoInformepersonalizado"));
                informes.setMontoMesInforme(rs.getInt("montomesInforme"));
                informes.setMontoAñoInforme(rs.getInt("montoañoInforme"));
                informes.setTotalPagos(rs.getInt("totalPagos"));
                informes.setTotalGanancias(rs.getInt("totalGanancias"));
                informes.setUsuarioCreacion(rs.getString("usuarioCreacion"));
                LocalDateTime fechaCreacion = rs.getObject("fechaCreacion", LocalDateTime.class);
                informes.setFechaCreacion(fechaCreacion);
                informes.setUsuarioModificador(rs.getString("usuarioModificador") != null ? rs.getString("usuarioModificador") : null);
                LocalDateTime fechaModificacion = rs.getObject("fechaModificacion", LocalDateTime.class);
                informes.setFechaModificacion(fechaModificacion);

                listaInformes.add(informes);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            throw ex;
        }
        return listaInformes;
    }
    public ArrayList<Roles> BuscarRoles() throws SQLException {
    String query = "SELECT idRol, nombre, usuarioCreacion, fechaCreacion, usuarioModificador, fechaModificacion FROM roles;";
    conn = c.conectar();
    ArrayList<Roles> listaRoles = new ArrayList<>();

    try {
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            roles = new Roles();
            roles.setIdRol(rs.getInt("idRol"));
            roles.setNombreRol(rs.getString("nombre"));
            roles.setUsuarioCreacion(rs.getString("usuarioCreacion"));
            LocalDateTime fechaCreacion = rs.getObject("fechaCreacion", LocalDateTime.class);
            roles.setFechaCreacion(fechaCreacion);
            roles.setUsuarioModificador(rs.getString("usuarioModificador") != null ? rs.getString("usuarioModificador") : null);
            LocalDateTime fechaModificacion = rs.getObject("fechaModificacion", LocalDateTime.class);
            roles.setFechaModificacion(fechaModificacion);
            listaRoles.add(roles);
        }
    } catch (SQLException ex) {
        System.out.println("Error al ejecutar la consulta SQL: " + ex.getMessage());
        ex.printStackTrace();
    }
    return listaRoles;
    }
}
