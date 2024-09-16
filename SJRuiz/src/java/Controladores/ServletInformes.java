/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controladores;

import DML.Delete;
import DML.Insert;
import DML.Select;
import DML.Update;
import Entidades.Clientes;
import Entidades.Usuarios;
import Entidades.Finanzas;
import Entidades.Informes;
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
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 *
 * @author jefer
 */
@WebServlet(name = "ServletInformes", urlPatterns = {"/ServletInformes"})
public class ServletInformes extends HttpServlet {
     Usuarios usuarios = new Usuarios();
     Clientes clientes = new Clientes();
     Finanzas finanzas = new Finanzas();
     Insert insert = new Insert();
     Update update = new Update();
     Delete delete = new Delete();
     Select select = new Select();
     String ventana = "./crearInforme.jsp";
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
            out.println("<title>Servlet ServletInformes</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletInformes at " + request.getContextPath() + "</h1>");
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

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String NombreInforme = request.getParameter("nombreinforme");
            String TipoInforme = request.getParameter("tipoinforme");
            String fecha = request.getParameter("fechainforme");
            LocalDate fechaInforme = null;
            try {
                if(fecha != null ){
                    fechaInforme = LocalDate.parse(fecha, formato);
                }else{
                    fechaInforme=null;
                }  
                
                
            } catch (DateTimeParseException ex) {
                Logger.getLogger(ServletInformes.class.getName()).log(Level.SEVERE, null, ex);
            }
            String fecha1 = request.getParameter("fechainicialinforme");
            LocalDate fechaInicialPersonalizado = null;
            try {
                if(fecha1 != null ){
                    fechaInicialPersonalizado = LocalDate.parse(fecha1, formato);
                }else{
                    fechaInicialPersonalizado=null;
                }   
            } catch (DateTimeParseException ex) {
                Logger.getLogger(ServletInformes.class.getName()).log(Level.SEVERE, null, ex);
            }
            String fecha2 = request.getParameter("fechafinalinforme");
            LocalDate fechaFinalPersonalizado = null;
            try {
                if(fecha2 != null ){
                    fechaInicialPersonalizado = LocalDate.parse(fecha2, formato);
                }else{
                    fechaFinalPersonalizado=null;
                }              
            } catch (DateTimeParseException ex) {
                Logger.getLogger(ServletInformes.class.getName()).log(Level.SEVERE, null, ex);
            }
            String tipoinforme2 =null;
            int totalAño1 = 0;
            int pagosAño = 0;
            int gananciasAño = 0;   
            String tipoinforme= null;
            int totalClientes= 0;
            int totalMes =0;
            int totalAño=0;
            int totalPersonalizado=0;
            int pagos=0;
            int ganancia=0;
            java.sql.Date sqlDate = null;
            Select select = new Select();
            //fecha personalizada inicial
            int diainicialformulario = fechaInicialPersonalizado.getDayOfMonth();
            int mesinicialformulario = fechaInicialPersonalizado.getMonthValue();
            int añoinicialformulario = fechaInicialPersonalizado.getYear();
            //fecha personalizada final
            int diafinalformulario = fechaFinalPersonalizado.getDayOfMonth();
            int mesfinalformulario = fechaFinalPersonalizado.getMonthValue();
            int añofinalformulario = fechaFinalPersonalizado.getYear();
            //fecha normal
            int mesformulario = fechaInforme.getMonthValue();
            int añoformulario = fechaInforme.getYear();
            boolean existeFechaIgual = false;
            try {
                  ArrayList<Finanzas> listaFinanzas = select.BuscarFinanzas();
                  ArrayList<Clientes> listaClientes = select.BuscarClientes();
                  ArrayList<Informes> listaInformes = select.BuscarInformes();
                  
                  //esta pendiente de borrar si no hace nada no recuerdo
                  //LocalDateTime fechaInicioPersonalizada = null;
                  //LocalDateTime fechaFinPersonalizada = null;
                  
                  //if(fechaInicialPersonalizado != null || fechaFinalPersonalizado != null){
                     //fechaInicioPersonalizada = fechaInicialPersonalizado.atStartOfDay();
                     //fechaFinPersonalizada = fechaFinalPersonalizado.atStartOfDay();
                 //}else{
                    //fechaInicialPersonalizado=null;
                    //fechaFinalPersonalizado=null;
                 //}  
                 
                 //LocalDate fechinforme= null;
                
                 LocalDate fechacliente= null;
                 int totalClientesMes = 0;
                 int totalClientesAnual=0;
                    for (Clientes clientes : listaClientes) {
                       totalClientes = clientes.getTotalJugado();
                       fechacliente = clientes.getFecha();
                       // Total Clientes Anual
                        if (fechaInforme.getYear() == fechacliente.getYear()) {
                            totalClientesAnual += totalClientes;

                        }
                        
                        //total personalizado
                        // falta arreglar acordarse
                        if (((fechaInicialPersonalizado.getYear() == fechacliente.getYear() && 
                             fechaFinalPersonalizado.getYear() == fechacliente.getYear() &&
                              fechaInicialPersonalizado.getMonthValue() == fechacliente.getMonthValue() &&
                              fechaFinalPersonalizado.getMonthValue() == fechacliente.getMonthValue() &&
                              fechaInicialPersonalizado.getDayOfMonth() <= fechacliente.getDayOfMonth() && 
                              fechaFinalPersonalizado.getDayOfMonth() >= fechacliente.getDayOfMonth()))) {                                            
                           
                                
                        }

                       //total Clientes Mensual
                       if (fechaInforme.getYear() == fechacliente.getYear() && 
                            fechaInforme.getMonth() == fechacliente.getMonth()) {
        
                              // Solo sumar el totalJugado si las fechas coinciden
                            totalClientesMes += totalClientes;

                        }                                      
                    
                    }
                    
                    for (Finanzas finanzas : listaFinanzas) {
                     LocalDateTime fechaigualadafinanza= finanzas.getFecha();
                     int dia = fechaigualadafinanza.getDayOfMonth();
                     int mes = fechaigualadafinanza.getMonthValue();
                     int año = fechaigualadafinanza.getYear();                    
                     int maquinas = finanzas.getMontoMaquinas();
                     int futbolin = finanzas.getMontoFutbolin();
                     int luz = finanzas.getMontoLuz();
                     int agua = finanzas.getMontoAgua();
                     int internet = finanzas.getMontoInternet();
                     int plan = finanzas.getMontoPlan();
                     int montofinal = finanzas.getMontoFinalFinanza();
                    //Esta bueno verificado
                     if (TipoInforme.equals("Mes")) {   
                       if((mesformulario == mes && añoformulario == año)){                                                       
                           totalMes = montofinal;
                           pagos = luz + agua + internet + plan;
                           ganancia = maquinas + futbolin + totalClientesMes;
                           existeFechaIgual = true;
                           break; 
                       }                        
                       
                     }
                     //esta bueno verificado
                     if (TipoInforme.equals("Anio")) {
                        for (Informes informe : listaInformes) {
                            if(añoformulario == año){                                                       
                                pagos += luz + agua + internet + plan;
                                ganancia += maquinas + futbolin + totalClientesAnual;
                                totalAño = (ganancia - pagos);
                                existeFechaIgual = true;
                                break; 
                            }                              
                        }
                     }

                     if(TipoInforme.equals("Personalizado")){
                       
                        for (Informes informe : listaInformes) {
                            if ((añoinicialformulario < año || (añoinicialformulario == año && mesinicialformulario < mes) || 
                                (añoinicialformulario == año && mesinicialformulario == mes && diainicialformulario <= dia)) &&
                                (añofinalformulario > año || (añofinalformulario == año && mesfinalformulario > mes) || 
                                (añofinalformulario == año && mesfinalformulario == mes && diafinalformulario >= dia))) {                                            
                           
                                pagos += luz + agua + internet + plan;
                                ganancia += maquinas + futbolin + totalClientesAnual;
                                totalAño = (ganancia - pagos);
                                existeFechaIgual = true;
                                break; 
                            }
                            
                        }
                    }
                     
                }
                 

            }catch (SQLException ex) {
                Logger.getLogger(ServletInformes.class.getName()).log(Level.SEVERE, null, ex);
            }

                  
            
            LocalDateTime fechaCreacion1;
            HttpSession session = request.getSession();
            String usuarioCreador2 = (String) session.getAttribute("inputEmail1");
            LocalDateTime fechaModificacion2 = null;
            String usuarioModificador2= null;            
            fechaCreacion1 = LocalDateTime.now();
            try {
                 if (existeFechaIgual) {
                    insert.insertarInforme(NombreInforme, TipoInforme, fechaInforme, fechaInicialPersonalizado, fechaFinalPersonalizado, totalPersonalizado, totalMes, totalAño, pagos, ganancia, usuarioCreador2, fechaCreacion1, usuarioModificador2, fechaModificacion2);                 
                 }else {
                  System.out.println("La finanza de ese mes no existe.");
                  request.setAttribute("mensajeError", "La finanza de ese mes no existe.");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ServletInformes.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher view = request.getRequestDispatcher(ventana);
            view.forward(request, response);
        }
        
        if (accion.equalsIgnoreCase("mostrarmesinforme")) {
            Select select = new Select();
            String FechaMesInforme = request.getParameter("fechamesinforme");
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechamesinforme = null;
            try {
                fechamesinforme = LocalDate.parse(FechaMesInforme, formato);
            } catch (DateTimeParseException ex) {
                Logger.getLogger(ServletClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                  ArrayList<Informes> listaInformes = select.BuscarInformes();
                     Informes informeSeleccionado = null;
                    for (Informes informe : listaInformes) {
                        LocalDate fechainforme = informe.getFechaInforme();
                            if (informe.getFechaInforme().getYear() == fechamesinforme.getYear() &&
                                informe.getFechaInforme().getMonth() == fechamesinforme.getMonth()) {
                                informeSeleccionado = informe;
                                break;
                            }
                    }

                 // Configurar el informe en la solicitud
                  request.setAttribute("informe", informeSeleccionado);

                  // Enviar a la página JSP para mostrar el informe
                    RequestDispatcher dispatcher = request.getRequestDispatcher("verInformeMes.jsp");
                    dispatcher.forward(request, response);
                } catch (SQLException ex) {
                   Logger.getLogger(ServletInformes.class.getName()).log(Level.SEVERE, null, ex);
                }
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
