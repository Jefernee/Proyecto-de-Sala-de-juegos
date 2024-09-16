/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controladores;

import DML.Delete;
import DML.Insert;
import DML.Select;
import DML.Update;
import Entidades.Finanzas;
import Entidades.Usuarios;
import Entidades.Clientes;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author jefer
 */
@WebServlet(name = "ServletFinanzas", urlPatterns = {"/ServletFinanzas"})
public class ServletFinanzas extends HttpServlet {
     Finanzas finanzas = new Finanzas();
     Clientes clientes = new Clientes();
     Usuarios usuarios = new Usuarios();
     Insert insert = new Insert();
     Update update = new Update();
     Delete delete = new Delete();
     Select select = new Select();
     String ventana = "./añadirFinanzas.jsp";
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
            out.println("<title>Servlet ServletFinanzas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletFinanzas at " + request.getContextPath() + "</h1>");
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
        if(accion.equalsIgnoreCase("borrar")){
            
            if (request.getParameter("idbuscarfinanza") != null) {
                   int idusuario = Integer.parseInt(request.getParameter("idbuscarfinanza"));
      
                  delete.eliminarFinanzas(idusuario);
           }
   
                   
           RequestDispatcher view = request.getRequestDispatcher(ventana);
           view.forward(request, response);
        }
        if (accion.equalsIgnoreCase("insertar")) {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            String NombreFinanza = request.getParameter("nombrefinanza");
            String DescripcionFinanza = request.getParameter("descripcionfinanza");
            //SimpleDateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            String fecha = request.getParameter("fechafinanza");
            
            LocalDateTime fechaFinanza = null;
            try {
               if(fecha != null ){
                    fechaFinanza = LocalDateTime.parse(fecha, formato);
                }else{
                    fechaFinanza=null;
                }  
            } catch (DateTimeParseException ex) {
                Logger.getLogger(ServletFinanzas.class.getName()).log(Level.SEVERE, null, ex);
            }
            int mesformulario = fechaFinanza.getMonthValue();
            int añoformulario = fechaFinanza.getYear();
            
            int MontoMaquinas = Integer.parseInt(request.getParameter("montomaquinas"));
            int MontoLuz = Integer.parseInt(request.getParameter("montoluz"));
            int MontoAgua = Integer.parseInt(request.getParameter("montoagua"));
            int MontoInternet = Integer.parseInt(request.getParameter("montointernet"));
            int MontoPlan = Integer.parseInt(request.getParameter("montoplan"));
            int MontoFutbolin = Integer.parseInt(request.getParameter("montofutbolin"));
            int sumaTotalJugadoMes = 0;
            try{
                ArrayList<Clientes> listaClientes = select.BuscarClientes();
                for (Clientes clientes : listaClientes) {
                    LocalDate fechacliente = clientes.getFecha();
                    int totaljugado = clientes.getTotalJugado();
                    int mes = fechacliente.getMonthValue();
                    int año = fechacliente.getYear();
                    if (mesformulario == mes && añoformulario == año) {
                        sumaTotalJugadoMes += totaljugado; // Suma el total jugado del cliente si está en el mes y año del formulario
                    }
                    
                }
            }catch (SQLException ex) {
                Logger.getLogger(ServletFinanzas.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
            int MontoFinalFinanza = MontoMaquinas + MontoFutbolin + sumaTotalJugadoMes - (MontoLuz + MontoAgua + MontoInternet + MontoPlan);     
            
            LocalDateTime fechaCreacion1;
            HttpSession session = request.getSession();
            String usuarioCreador2 = (String) session.getAttribute("inputEmail1");
            LocalDateTime fechaModificacion2 = null;
            String usuarioModificador2= null;            
            fechaCreacion1 = LocalDateTime.now();
            
            boolean existeFechaIgual = false;
            Select select = new Select();
            try{
                ArrayList<Finanzas> listaFinanzas = select.BuscarFinanzas();
                for (Finanzas finanzas : listaFinanzas) {
                    String nombrefinanza = finanzas.getNombreFinanza();
                    LocalDateTime fecharepetida = finanzas.getFecha();  
                    int mes = fecharepetida.getMonthValue();
                    int año = fecharepetida.getYear();
                    if((mesformulario == mes && añoformulario == año) || (NombreFinanza.equalsIgnoreCase(nombrefinanza) && añoformulario == año)){                        
                           existeFechaIgual = true;
                            break; 
                                            
                    }
                    
                }
            }catch (SQLException ex) {
                Logger.getLogger(ServletFinanzas.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            try{
               if (!existeFechaIgual) {
                insert.insertarFinanza(NombreFinanza, DescripcionFinanza, MontoMaquinas, MontoFutbolin, MontoLuz, MontoAgua, MontoInternet, MontoPlan, MontoFinalFinanza, fechaFinanza, usuarioCreador2, fechaCreacion1,usuarioModificador2, fechaModificacion2);
               }else {
                  System.out.println("Ya existe una finanza con el mismo mes y año. No se puede añadir.");
                  request.setAttribute("mensajeError", "Ya existe una finanza con el mismo mes y año.");
                }
            }catch (SQLException ex) {
               Logger.getLogger(ServletFinanzas.class.getName()).log(Level.SEVERE, "Error al insertar la finanza", ex);
               request.setAttribute("mensajeError", "Error al insertar la finanza: " + ex.getMessage());
           }
            
            
            RequestDispatcher view = request.getRequestDispatcher(ventana);
            view.forward(request, response);
        }
        
        if (accion.equalsIgnoreCase("editar")) {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            int idFinanza = Integer.parseInt(request.getParameter("idfinanza"));
            String NombreFinanza = request.getParameter("nombrefinanza");
            String DescripcionFinanza = request.getParameter("descripcionfinanza");
            //SimpleDateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            String fecha = request.getParameter("fechafinanza");
            LocalDateTime fechaFinanza = null;
            try {
               if(fecha != null ){
                    fechaFinanza = LocalDateTime.parse(fecha, formato);
                }else{
                    fechaFinanza=null;
                }  
            } catch (DateTimeParseException ex) {
                Logger.getLogger(ServletFinanzas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            int MontoMaquinas = Integer.parseInt(request.getParameter("montomaquinas"));
            int MontoLuz = Integer.parseInt(request.getParameter("montoluz"));
            int MontoAgua = Integer.parseInt(request.getParameter("montoagua"));
            int MontoInternet = Integer.parseInt(request.getParameter("montointernet"));
            int MontoPlan = Integer.parseInt(request.getParameter("montoplan"));
            int MontoFutbolin = Integer.parseInt(request.getParameter("montofutbolin")); 
            
            int MontoFinalFinanza = MontoMaquinas + MontoFutbolin - (MontoLuz + MontoAgua + MontoInternet + MontoPlan);     
            
            LocalDateTime fechaCreacion1;
            HttpSession session = request.getSession();
            String usuarioCreador2 = (String) session.getAttribute("inputEmail1");
            LocalDateTime fechaModificacion2 = null;
            String usuarioModificador2= null;            
            fechaCreacion1 = LocalDateTime.now();
            
            int mesformulario = fechaFinanza.getMonthValue();
            int añoformulario = fechaFinanza.getYear();
            boolean existeFechaIgual = false;
            Select select = new Select();
            try{
                ArrayList<Finanzas> listaFinanzas = select.BuscarFinanzas();
                for (Finanzas finanzas : listaFinanzas) {
                    String nombrefinanza = finanzas.getNombreFinanza();
                    LocalDateTime fecharepetida = finanzas.getFecha();  
                    int mes = fecharepetida.getMonthValue();
                    int año = fecharepetida.getYear();
                    if((mesformulario == mes && añoformulario == año) || (NombreFinanza.equalsIgnoreCase(nombrefinanza) && añoformulario == año)){                        
                           existeFechaIgual = true;
                            break; 
                                            
                    }
                    
                }
            }catch (SQLException ex) {
                Logger.getLogger(ServletFinanzas.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            try{
               if (!existeFechaIgual) {
                update.modificarFinanzas(idFinanza, NombreFinanza, DescripcionFinanza, MontoMaquinas, MontoFutbolin, MontoLuz, MontoAgua, MontoInternet, MontoPlan, MontoFinalFinanza, fechaFinanza, usuarioCreador2, fechaCreacion1,usuarioModificador2, fechaModificacion2);
               }else {
                  System.out.println("Ya existe una finanza con el mismo mes y año. No se puede añadir.");
                  request.setAttribute("mensajeError", "Ya existe una finanza con el mismo mes y año.");
                }
            }catch (SQLException ex) {
               Logger.getLogger(ServletFinanzas.class.getName()).log(Level.SEVERE, "Error al insertar la finanza", ex);
               request.setAttribute("mensajeError", "Error al insertar la finanza: " + ex.getMessage());
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
