/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DML;

import SQL.Conexion;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author jefer
 */
public class Update {

    Conexion c = new Conexion();
    Connection conn;

    public void modificarCliente(int idCliente, String nombre, LocalDate fecha, String descripcion, String tiempoPagado, Time horaInicial, Time horaFinal, String tiempoPendiente, char numeroplay, String juegosJugados, Integer controlAdicional, Integer mesaPingPong, Integer play4, Integer play5, Integer totalJugado, String telefono, String usuarioCreacion, LocalDateTime fechaCreacion, String usuarioModificador, LocalDateTime fechaModificacion) throws SQLException {
        conn = c.conectar();
        try {
            String query = "UPDATE clientes "
                    + "SET nombre = ?, "
                    + "fecha = ?, "
                    + "descripcion = ?, "
                    + "tiempoPagado = ?, "
                    + "horaInicial = ?, "
                    + "horaFinal = ?, "
                    + "tiempoPendiente = ?, "
                    + "numeroplay = ?, "
                    + "juegosJugados = ?, "
                    + "controlAdicional = ?, "
                    + "mesaPingPong = ?, "
                    + "play4 = ?, "
                    + "play5 = ?, "
                    + "totalJugado = ?, "
                    + "telefono = ?, "
                    + "usuarioCreacion = ?, "
                    + "fechaCreacion = ?, "
                    + "usuarioModificador = ?, "
                    + "fechaModificacion = ? "
                    + "WHERE idCliente = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setObject(2, fecha);
            ps.setString(3, descripcion);
            ps.setString(4, tiempoPagado);
            ps.setTime(5, horaInicial);
            ps.setTime(6, horaFinal);
            ps.setString(7, tiempoPendiente);
            ps.setString(8, String.valueOf(numeroplay));
            ps.setString(9, juegosJugados);
            ps.setInt(10, controlAdicional);
            ps.setInt(11, mesaPingPong);
            ps.setInt(12, play4);
            ps.setInt(13, play5);
            ps.setInt(14, totalJugado);
            ps.setString(15, telefono);
            ps.setString(16, usuarioCreacion);
            ps.setObject(17, fechaCreacion);
            ps.setString(18, usuarioModificador);
            ps.setObject(19, fechaModificacion);
            ps.setInt(20, idCliente);

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void modificarUsuario(int idUsuario, int idRol, String nombre, String usuario, String correoElectronico, String contraseña, String estado, String telefono, String rolUsuario, String usuarioCreacion, LocalDateTime fechaCreacion, String usuarioModificador, LocalDateTime fechaModificacion) throws SQLException {
        conn = c.conectar();
        try {
            String query = "UPDATE usuarios "
                    + "SET idRol = ?, "
                    + "nombre = ?, "
                    + "usuario = ?, "
                    + "correoElectronico = ?, "
                    + "contraseña = ?, "
                    + "estado = ?, "
                    + "telefono = ?, "
                    + "rolUsuario = ?, "
                    + "usuarioCreacion = ?, "
                    + "fechaCreacion = ?, "
                    + "usuarioModificador = ?, "
                    + "fechaModificacion = ? "
                    + "WHERE idUsuario = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idRol);
            ps.setString(2, nombre);
            ps.setString(3, usuario);
            ps.setString(4, correoElectronico);
            ps.setString(5, contraseña);
            ps.setString(6, estado);
            ps.setString(7, telefono);
            ps.setString(8, rolUsuario);
            ps.setString(9, usuarioCreacion);
            ps.setObject(10, fechaCreacion);
            ps.setString(11, usuarioModificador);
            ps.setObject(12, fechaModificacion);
            ps.setInt(13, idUsuario);

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void modificarProducto(String idProducto, String nombreProducto, String descripcionProducto, Date fechaCompra, String garantia, Integer cantidad, Integer precioComprado, String lugarComprado, String telefonoLugar, String estadoProducto, String descripcionProblema, String descripcionReparación, String usuarioCreacion, LocalDateTime fechaCreacion, String usuarioModificador, LocalDateTime fechaModificacion) throws SQLException {
        conn = c.conectar();
        try {
            String query = "UPDATE inventarioSala "
                    + "SET nombreProducto = ?, "
                    + "descripcionProducto = ?, "
                    + "fechaCompra = ?, "
                    + "garantia = ?, "
                    + "cantidad = ?, "
                    + "precioComprado = ?, "
                    + "lugarComprado = ?, "
                    + "telefonoLugar = ?, "
                    + "estadoProducto = ?, "
                    + "descripcionProblema = ?, "
                    + "descripcionReparación = ?, "
                    + "usuarioCreacion = ?, "
                    + "fechaCreacion = ?, "
                    + "usuarioModificador = ?, "
                    + "fechaModificacion = ? "
                    + "WHERE idProducto = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, nombreProducto);
            ps.setString(2, descripcionProducto);
            ps.setDate(3, fechaCompra);
            ps.setString(4, garantia);
            ps.setInt(5, cantidad);
            ps.setInt(6, precioComprado);
            ps.setString(7, lugarComprado);
            ps.setString(8, telefonoLugar);
            ps.setString(9, estadoProducto);
            ps.setString(10, descripcionProblema);
            ps.setString(11, descripcionReparación);
            ps.setString(12, usuarioCreacion);
            ps.setObject(13, fechaCreacion);
            ps.setString(14, usuarioModificador);
            ps.setObject(15, fechaModificacion);
            ps.setString(16, idProducto);

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
  
    public void modificarPrecios(Integer idCosto, String tipoJuego, Integer costoHora, String usuarioCreacion, LocalDateTime fechaCreacion, String usuarioModificador, LocalDateTime fechaModificacion) throws SQLException {
        conn = c.conectar();
        try {
            String query = "UPDATE costosHorasdejuego "
                    + "SET tipoJuego = ?, "
                    + "costoHora = ?, "
                    + "usuarioCreacion = ?, "
                    + "fechaCreacion = ?, "
                    + "usuarioModificador = ?, "
                    + "fechaModificacion = ? "
                    + "WHERE idCosto = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, tipoJuego);
            ps.setInt(2, costoHora);
            ps.setString(3, usuarioCreacion);
            ps.setObject(4, fechaCreacion);
            ps.setString(5, usuarioModificador);
            ps.setObject(6, fechaModificacion);
            ps.setInt(7, idCosto);

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public void modificarFinanzas(Integer idFinanza, String nombreFinanza, String descripcion, Integer montoMaquinas, 
        Integer montoFutbolin, Integer montoLuz, Integer montoAgua, Integer montoInternet, Integer montoPlan, 
        Integer montoFinalFinanza, LocalDateTime fecha, String usuarioCreacion, LocalDateTime fechaCreacion, 
        String usuarioModificador, LocalDateTime fechaModificacion) throws SQLException {

    conn = c.conectar();
    try {
        String query = "UPDATE finanzas "
                + "SET nombreFinanza = ?, "
                + "descripcion = ?, "
                + "montoMaquinas = ?, "
                + "montoFutbolin = ?, "
                + "montoLuz = ?, "
                + "montoAgua = ?, "
                + "montoInternet = ?, "
                + "montoPlan = ?, "
                + "montoFinalFinanza = ?, "
                + "fecha = ?, "
                + "usuarioCreacion = ?, "
                + "fechaCreacion = ?, "
                + "usuarioModificador = ?, "
                + "fechaModificacion = ? "
                + "WHERE idfinanza = ?";

        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, nombreFinanza);
        ps.setString(2, descripcion);
        ps.setInt(3, montoMaquinas);
        ps.setInt(4, montoFutbolin);
        ps.setInt(5, montoLuz);
        ps.setInt(6, montoAgua);
        ps.setInt(7, montoInternet);
        ps.setInt(8, montoPlan);
        ps.setObject(9, montoFinalFinanza);
        ps.setObject(10, fecha);
        ps.setString(11, usuarioCreacion);
        ps.setObject(12, fechaCreacion);
        ps.setString(13, usuarioModificador);
        ps.setObject(14, fechaModificacion);
        ps.setInt(15, idFinanza);

        ps.executeUpdate();

    } catch (SQLException ex) {
        System.out.println(ex);
    }
}
    
}
