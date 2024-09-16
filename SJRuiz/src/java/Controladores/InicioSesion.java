/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controladores;

import DML.Delete;
import DML.Insert;
import DML.Select;
import DML.Update;
import Entidades.Usuarios;
import java.util.ArrayList;
import SQL.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jefer
 */
@WebServlet(name = "InicioSesion", urlPatterns = {"/Iniciosesion"})
public class InicioSesion extends HttpServlet {

    Usuarios usuarios = new Usuarios();
    Insert insert = new Insert();
    Update update = new Update();
    Delete delete = new Delete();
    Select select = new Select();
    String ventana = "./index.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InicioSesion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InicioSesion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("iniciar")) {
            String username = request.getParameter("inputEmail1");
            String password = request.getParameter("inputPassword5");

            // Llama a un método que verifique las credenciales en tu base de datos
            //boolean isValidUser = verificarCredenciales(username, password);
             String rolUsuario = verificarCredenciales(username, password);
            if (rolUsuario != null) {
                
                // Si las credenciales son válidas, establece la sesión y redirige al usuario a la página principal
                HttpSession session = request.getSession();
                session.setAttribute("inputEmail1", username);
                session.setAttribute("rolUsuario", rolUsuario);
                response.sendRedirect("paginaPrincipal.jsp");
            } else {
                // Si las credenciales no son válidas, redirige al usuario de vuelta al formulario de inicio de sesión con un mensaje de error
                response.sendRedirect("index.jsp?error=invalidCredentials");
            }
        }
    }

    // Método para verificar las credenciales en la base de datos
    public String verificarCredenciales(String inputEmail1, String inputPassword5) {
        Select select = new Select();
        boolean isAdmin = false;
        boolean isEmployee = false;
        try {
            ArrayList<Usuarios> listaUsuarios = select.BuscarUsuarios();

            // Recorre la lista de usuarios para verificar las credenciales
            for (Usuarios usuario : listaUsuarios) {
                String user = usuario.getUsuario();
                String Rol = usuario.getRolUsuario();
                
                 // Compara el nombre de usuario y la contraseña proporcionados con los de cada usuario en la lista
                  if (usuario.getUsuario().equals(inputEmail1) && usuario.getContraseña().equals(inputPassword5)) {
                       // Si las credenciales coinciden, retorna true
                       if (Rol.equals("Administrador")) {
                                isAdmin = true;
                                
                       }else if(Rol.equals("Empleado")){
                               isEmployee = true;
                               
                       } 
                   }
                
            }
            
        } catch (SQLException ex) {
            // Maneja la excepción si ocurre algún error al buscar usuarios
            ex.printStackTrace();
        }
         //return false;
         if (isAdmin) {
            return "Administrador";
        } else if (isEmployee) {
            return "Empleado";
        } else {
            return null; // Credenciales no válidas
        }
        // Si no se encuentra ningún usuario con las credenciales proporcionadas, retorna false
        //return false;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
