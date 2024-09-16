/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DML;

import SQL.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author jefer
 */

public class Delete {
    Conexion c = new Conexion();
    Connection conn;
    public Delete() {
        conn = c.conectar(); // Inicializar la conexión
    }
    public void eliminarClientes(Integer idCliente){
        try {
            String query = "DELETE FROM clientes "
                    + "WHERE idCliente = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idCliente);

            ps.executeUpdate();
            
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }
    public void eliminarUsuarios(Integer idUsuario){
        try {
            String query = "DELETE FROM usuarios "
                    + "WHERE idUsuario = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idUsuario);

            ps.executeUpdate();
            
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }
    public void eliminarHoras(Integer idCosto){
        try {
            String query = "DELETE FROM costosHorasdejuego "
                    + "WHERE idCosto = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idCosto);

            ps.executeUpdate();
            
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }
    public void eliminarInventarioSala(String idProducto){
        try {
            String query = "DELETE FROM inventarioSala  "
                    + "WHERE idProducto = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, idProducto);

            ps.executeUpdate();
            
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }
    public void eliminarFinanzas(Integer idfinanza){
        try {
            String query = "DELETE FROM finanzas  "
                    + "WHERE idfinanza = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idfinanza);

            ps.executeUpdate();
            
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }
    public void eliminarInformes(Integer idInforme){
        try {
            String query = "DELETE FROM informes "
                    + "WHERE idInforme = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idInforme);

            ps.executeUpdate();
            
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }
}
