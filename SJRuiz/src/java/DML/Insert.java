/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DML;

import SQL.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.sql.Types;

import java.sql.Timestamp;
import java.time.LocalDate;

/**
 *
 * @author jefer
 */
public class Insert {

    Conexion c = new Conexion();
    Connection conn = null;

    public void insertarCliente(String nombre, LocalDate fecha, String descripcion, String tiempoPagado, Time horaInicial, Time horaFinal, String tiempoPendiente, char numeroplay, String juegosJugados, Integer controlAdicional, Integer mesaPingPong,
            Integer play4, Integer play5, Integer totalJugado, String telefono, String usuarioCreacion, LocalDateTime fechaCreacion, String usuarioModificador,
            LocalDateTime fechaModificacion) throws SQLException {
        String query = "INSERT INTO clientes(nombre, fecha, descripcion, tiempoPagado, horaInicial, horaFinal, tiempoPendiente, numeroplay, juegosJugados, controlAdicional, mesaPingPong, play4, play5, totalJugado, telefono, usuarioCreacion, fechaCreacion, usuarioModificador, fechaModificacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        conn = c.conectar(); //establecer la conexión con la base de datos

        try (Connection conn = c.conectar()) {

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, nombre);
            ps.setObject(2, fecha);
            ps.setString(3, descripcion);
            ps.setString(4, tiempoPagado);
            ps.setTime(5, horaInicial);
            ps.setTime(6, horaFinal);
            ps.setString(7, tiempoPendiente);
            ps.setString(8, String.valueOf(numeroplay)); //revisar sustitucion de char a string en base de datos
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

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void insertarUsuario(Integer idRol, String nombre, String usuario, String correoElectronico, String contraseña, String estado, String telefono, String rolUsuario, String usuarioCreacion, LocalDateTime fechaCreacion, String usuarioModificador, LocalDateTime fechaModificacion) throws SQLException {
        String query = "INSERT INTO usuarios(idRol, nombre, usuario, correoElectronico, contraseña, estado, telefono, rolUsuario, usuarioCreacion, fechaCreacion, usuarioModificador, fechaModificacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        conn = c.conectar(); // Establecer la conexión con la base de datos

        try (Connection conn = c.conectar()) {
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, idRol); //se debe de traer de otra tabla
            ps.setString(2, nombre);
            ps.setString(3, usuario);
            ps.setString(4, correoElectronico);
            ps.setString(5, contraseña);
            ps.setString(6, estado);
            ps.setString(7, telefono);
            ps.setString(8, rolUsuario); //se debe de traer de otra tabla
            ps.setString(9, usuarioCreacion);
            ps.setObject(10, fechaCreacion);
            ps.setString(11, usuarioModificador);
            ps.setObject(12, fechaModificacion);
            //ps.setTimestamp(12, fechaModificacion);

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void insertarCostoHora(String tipoJuego, Integer costoHora, String usuarioCreacion, Timestamp fechaCreacion, String usuarioModificador, Timestamp fechaModificacion) throws SQLException {
        String query = "INSERT INTO costosHorasdejuego(tipoJuego, costoHora, usuarioCreacion, fechaCreacion, usuarioModificador, fechaModificacion) VALUES (?, ?, ?, ?, ?, ?)";

        conn = c.conectar(); // Establecer la conexión con la base de datos

        try (Connection conn = c.conectar()) {
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, tipoJuego);
            ps.setInt(2, costoHora);
            ps.setString(3, usuarioCreacion);
            ps.setTimestamp(4, fechaCreacion);
            ps.setString(5, usuarioModificador);
            ps.setTimestamp(6, fechaModificacion);

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void insertarProducto(String idProducto, String nombreProducto, String descripcionProducto, java.sql.Date fechaCompra, String garantia, Integer cantidad, Integer precioComprado, String lugarComprado, String telefonoLugar, String estadoProducto, String descripcionProblema, String descripcionReparacion, String usuarioCreacion, LocalDateTime fechaCreacion, String usuarioModificador, LocalDateTime fechaModificacion) throws SQLException {
        String query = "INSERT INTO inventarioSala(idProducto, nombreProducto, descripcionProducto, fechaCompra, garantia, cantidad, precioComprado, lugarComprado, telefonoLugar, estadoProducto, descripcionProblema, descripcionReparación, usuarioCreacion, fechaCreacion, usuarioModificador, fechaModificacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        conn = c.conectar(); // Establecer la conexión con la base de datos

        try (Connection conn = c.conectar()) {
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, idProducto);
            ps.setString(2, nombreProducto);
            ps.setString(3, descripcionProducto);
            ps.setDate(4, fechaCompra);
            ps.setString(5, garantia);
            ps.setInt(6, cantidad);
            ps.setInt(7, precioComprado);
            ps.setString(8, lugarComprado);
            ps.setString(9, telefonoLugar);
            ps.setString(10, estadoProducto);
            ps.setString(11, descripcionProblema);
            ps.setString(12, descripcionReparacion);
            ps.setString(13, usuarioCreacion);
            ps.setObject(14, fechaCreacion);
            ps.setString(15, usuarioModificador);
            ps.setObject(16, fechaModificacion);

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void insertarFinanza(String nombreFinanza, String descripcion, int montoMaquinas, int montoFutbolin, int montoLuz, int montoAgua, int montoInternet, int montoPlan, Integer montoFinalFinanza, LocalDateTime fecha, String usuarioCreacion, LocalDateTime fechaCreacion, String usuarioModificador, LocalDateTime fechaModificacion) throws SQLException {
        String query = "INSERT INTO finanzas(nombreFinanza, descripcion, montoMaquinas, montoFutbolin, montoLuz, montoAgua, montoInternet, montoPlan, montoFinalFinanza, fecha, usuarioCreacion, fechaCreacion, usuarioModificador, fechaModificacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        conn = c.conectar(); // Establecer la conexión con la base de datos

        try (Connection conn = c.conectar()) {
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, nombreFinanza);
            ps.setString(2, descripcion);
            ps.setInt(3, montoMaquinas);
            ps.setInt(4, montoFutbolin);
            ps.setInt(5, montoLuz);
            ps.setInt(6, montoAgua);
            ps.setInt(7, montoInternet);
            ps.setInt(8, montoPlan);
            ps.setObject(9, montoFinalFinanza); // Permite que sea null
            ps.setObject(10, fecha);
            ps.setString(11, usuarioCreacion);
            ps.setObject(12, fechaCreacion);
            ps.setString(13, usuarioModificador);
            ps.setObject(14, fechaModificacion);

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void insertarInforme(String nombreInforme, String descripcionInforme, LocalDate fechaInforme, LocalDate fechaInicialInforme, LocalDate fechaFinalInforme, Integer montoInformePersonalizado, Integer montoMesInforme, Integer montoAñoInforme, Integer totalPagos, Integer totalGanancias, String usuarioCreacion, LocalDateTime fechaCreacion, String usuarioModificador, LocalDateTime fechaModificacion) throws SQLException {
        String query = "INSERT INTO informes(nombreInforme, descripcionInforme, fechaInforme, fechaInicialInforme, fechaFinalInforme, montoInformePersonalizado, montoMesInforme, montoAñoInforme, totalPagos, totalGanancias, usuarioCreacion, fechaCreacion, usuarioModificador, fechaModificacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        conn = c.conectar(); // Establecer la conexión con la base de datos

        try (Connection conn = c.conectar()) {
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, nombreInforme);
            ps.setString(2, descripcionInforme);
            ps.setObject(3, fechaInforme);
            ps.setObject(4, fechaInicialInforme);
            ps.setObject(5, fechaFinalInforme);
            ps.setObject(6, montoInformePersonalizado); // Permitimos que sea null
            ps.setObject(7, montoMesInforme); // Permitimos que sea null
            ps.setObject(8, montoAñoInforme); // Permitimos que sea null
            ps.setObject(9, totalPagos); // Permitimos que sea null
            ps.setObject(10, totalGanancias); // Permitimos que sea null
            ps.setString(11, usuarioCreacion);
            ps.setObject(12, fechaCreacion);
            ps.setString(13, usuarioModificador);
            ps.setObject(14, fechaModificacion);

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
