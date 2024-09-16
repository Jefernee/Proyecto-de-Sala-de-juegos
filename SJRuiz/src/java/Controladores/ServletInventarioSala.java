/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controladores;

import DML.Delete;
import DML.Insert;
import DML.Select;
import DML.Update;
import Entidades.InventarioSala;
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
@WebServlet(name = "ServletInventarioSala", urlPatterns = {"/ServletInventarioSala"})
public class ServletInventarioSala extends HttpServlet {

    InventarioSala inventariosala = new InventarioSala();
    Usuarios usuarios = new Usuarios();
    Insert insert = new Insert();
    Update update = new Update();
    Delete delete = new Delete();
    Select select = new Select();
    String ventana = "./agregarProductos.jsp";

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
            out.println("<title>Servlet ServletInventarioSala</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletInventarioSala at " + request.getContextPath() + "</h1>");
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
            String IDProducto = request.getParameter("idproducto");
            String Nombre = request.getParameter("nombreproducto");
            String Descripcion = request.getParameter("descripcionproducto");
            String fecha = request.getParameter("fechacompra");
            Date fechaProducto = null;
            try {
                java.util.Date utilDate = formato.parse(fecha);
                fechaProducto = new Date(utilDate.getTime());
            } catch (ParseException ex) {
                Logger.getLogger(ServletClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            String Garantia = request.getParameter("garantia");
            int PrecioComprado = Integer.parseInt(request.getParameter("preciocomprado"));
            String LugarComprado = request.getParameter("lugarcomprado");
            String TelefonoLugar = request.getParameter("telefonolugar");
            int Cantidad = Integer.parseInt(request.getParameter("cantidad"));
            String EstadoProducto = request.getParameter("estadoproducto");
            String DescripcionProblema = request.getParameter("desproblema");
            String DescripcionReparacion = request.getParameter("desreparacion");

            LocalDateTime fechaCreacion1;
            HttpSession session = request.getSession();
            String usuarioCreador2 = (String) session.getAttribute("inputEmail1");
            LocalDateTime fechaModificacion2 = null;
            String usuarioModificador2= null;            
            fechaCreacion1 = LocalDateTime.now();

            try {
                insert.insertarProducto(IDProducto, Nombre, Descripcion, fechaProducto, Garantia, Cantidad, PrecioComprado, LugarComprado, TelefonoLugar, EstadoProducto, DescripcionProblema, DescripcionReparacion, usuarioCreador2, fechaCreacion1, usuarioModificador2, fechaModificacion2);
            } catch (SQLException ex) {
              Logger.getLogger(ServletClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher view = request.getRequestDispatcher(ventana);
            view.forward(request, response);
        }
        
        if(accion.equalsIgnoreCase("borrar")){
            
            if (request.getParameter("idbuscar") != null) {
                   String idProducto = request.getParameter("idbuscar");
      
                  delete.eliminarInventarioSala(idProducto);
           }
   
                   
           RequestDispatcher view = request.getRequestDispatcher(ventana);
           view.forward(request, response);
        }
        
        if(accion.equalsIgnoreCase("editar")){
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            String IDProducto = request.getParameter("idproducto");
            String Nombre = request.getParameter("nombreproducto");
            String Descripcion = request.getParameter("descripcionproducto");
            String fecha = request.getParameter("fechacompra");
            Date fechaProducto = null;
            try {
                java.util.Date utilDate = formato.parse(fecha);
                fechaProducto = new Date(utilDate.getTime());
            } catch (ParseException ex) {
                Logger.getLogger(ServletClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            String Garantia = request.getParameter("garantia");
            int PrecioComprado = Integer.parseInt(request.getParameter("preciocomprado"));
            String LugarComprado = request.getParameter("lugarcomprado");
            String TelefonoLugar = request.getParameter("telefonolugar");
            int Cantidad = Integer.parseInt(request.getParameter("cantidad"));
            String EstadoProducto = request.getParameter("estadoproducto");
            String DescripcionProblema = request.getParameter("desproblema");
            String DescripcionReparacion = request.getParameter("desreparacion");

            LocalDateTime fechaCreacion1;
            HttpSession session = request.getSession();
            String usuarioCreador2 = (String) session.getAttribute("inputEmail1");
            LocalDateTime fechaModificacion2 = null;
            String usuarioModificador2= null;            
            fechaCreacion1 = LocalDateTime.now();

            try {
                update.modificarProducto(IDProducto, Nombre, Descripcion, fechaProducto, Garantia, Cantidad, PrecioComprado, LugarComprado, TelefonoLugar, EstadoProducto, DescripcionProblema, DescripcionReparacion, usuarioCreador2, fechaCreacion1, usuarioModificador2, fechaModificacion2);
            } catch (SQLException ex) {
              Logger.getLogger(ServletInventarioSala.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
