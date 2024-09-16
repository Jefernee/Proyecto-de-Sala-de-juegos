/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author jefer
 */
public class Conexion {
    String bd = "SJRuizDB";
    String url = "jdbc:mysql://localhost:3306/" + bd + "?useUnicode=true&use"
            + "JDBCCompliantTimeZoneShift=true&useLegacyDateTimeCode=false&useSSL=false";
    String user = "root";
    String password = "Rkf2362*#";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection c = null;

    public Conexion() {
    }

    public Conexion(String baseDatos) {
        this.bd = baseDatos;
    }

    public Connection conectar() {
        try {
            Class.forName(driver);
            c = DriverManager.getConnection(url, user, password);
            if (c != null) {
                System.out.println("Conexión establecida a " + bd);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Ha ocurrido un error: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Ha ocurrido un error al establecer conexión con la base de datos: " + ex.getMessage());
        }
        return c;
    }

    public void desconectar() {
        try {
            c.close();
        } catch (SQLException ex) {
            System.out.println("Ha ocurrido un error al cerrar la conexión con la base de datos " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        conexion.conectar();
    }
}
