/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controladores;

import DML.Delete;
import DML.Insert;
import DML.Select;
import DML.Update;
import Entidades.Roles;
import Entidades.Usuarios;
import java.util.ArrayList;
import SQL.Conexion;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.ResultSet;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author jefer
 */

@WebServlet(name = "ServletUsuarios", urlPatterns = {"/ServletUsuarios"})
public class ServletUsuarios extends HttpServlet {
     Usuarios usuarios = new Usuarios();
     Roles roles = new Roles();
     Insert insert = new Insert();
     Update update = new Update();
     Delete delete = new Delete();
     Select select = new Select();
     String ventana = "./creacionUsuarios.jsp";
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
            out.println("<title>Servlet ServletUsuarios</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletUsuarios at " + request.getContextPath() + "</h1>");
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
        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("insertar")) {

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            String Nombre = request.getParameter("nombreApellido");
            String Usuario = request.getParameter("usuario");
            String Correo = request.getParameter("correo");
            String Contraseña = request.getParameter("inputPassword5");
            String Estado = request.getParameter("estado");
            String Telefono = request.getParameter("telefono1");
            String Rolusuario = request.getParameter("tipousuario");
            
            String usuario=null;
            int IDRol =0;
            Select select = new Select();
            try {
                ArrayList<Roles> listaRoles = select.BuscarRoles();
                for (Roles rol : listaRoles) {
                    int ID = rol.getIdRol();
                    String nombreRol = rol.getNombreRol();
                    if (nombreRol.equals(Rolusuario)) {
                        usuario=nombreRol;
                        IDRol= ID;
                        break;
                    } 
                }
            } catch (SQLException ex) {
                Logger.getLogger(ServletUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }

           
            LocalDateTime fechaCreacion1;
            HttpSession session = request.getSession();
            String usuarioCreador2 = (String) session.getAttribute("inputEmail1");
            LocalDateTime fechaModificacion2 = null;
            String usuarioModificador2= null;            
            fechaCreacion1 = LocalDateTime.now();
            try {
                insert.insertarUsuario(IDRol, Nombre, Usuario, Correo, Contraseña, Estado, Telefono, usuario, usuarioCreador2, fechaCreacion1, usuarioModificador2, fechaModificacion2);
            } catch (SQLException ex) {
                //Logger.getLogger(ServletClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher view = request.getRequestDispatcher(ventana);
            view.forward(request, response);

        }
        
        if(accion.equalsIgnoreCase("borrar")){
            
            if (request.getParameter("idbuscarusuario") != null) {
                   int idusuario = Integer.parseInt(request.getParameter("idbuscarusuario"));
      
                  delete.eliminarUsuarios(idusuario);
           }
   
                   
           RequestDispatcher view = request.getRequestDispatcher(ventana);
           view.forward(request, response);
        }
        
        if (accion.equalsIgnoreCase("editar")) {

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            String Nombre = request.getParameter("nombreApellido");
            String Usuario = request.getParameter("usuario");
            String Correo = request.getParameter("correo");
            String Contraseña = request.getParameter("inputPassword5");
            String Estado = request.getParameter("estado");
            String Telefono = request.getParameter("telefono1");
            String Rolusuario = request.getParameter("tipousuario");
            
            String usuario=null;
            int IDRol =0;
            Select select = new Select();
            try {
                ArrayList<Roles> listaRoles = select.BuscarRoles();
                for (Roles rol : listaRoles) {
                    int ID = rol.getIdRol();
                    String nombreRol = rol.getNombreRol();
                    if (nombreRol.equals(Rolusuario)) {
                        usuario=nombreRol;
                        IDRol= ID;
                        break;
                    } 
                }
            } catch (SQLException ex) {
                Logger.getLogger(ServletUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }

           
            LocalDateTime fechaCreacion1;
            HttpSession session = request.getSession();
            String usuarioCreador2 = (String) session.getAttribute("inputEmail1");
            LocalDateTime fechaModificacion2 = null;
            String usuarioModificador2= null;            
            fechaCreacion1 = LocalDateTime.now();
            int idusuario = Integer.parseInt(request.getParameter("idmodificar"));
            try {
                update.modificarUsuario(idusuario, IDRol, Nombre, Usuario, Correo, Contraseña, Estado, Telefono, usuario, usuarioCreador2, fechaCreacion1, usuarioModificador2, fechaModificacion2);
            } catch (SQLException ex) {
                //Logger.getLogger(ServletClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher view = request.getRequestDispatcher(ventana);
            view.forward(request, response);

        }
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
