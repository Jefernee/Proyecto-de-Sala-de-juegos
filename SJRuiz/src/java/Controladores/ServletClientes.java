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
import Entidades.Horas;
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
@WebServlet(name = "ServletClientes", urlPatterns = {"/ServletClientes"})
public class ServletClientes extends HttpServlet {

    Usuarios usuarios = new Usuarios();
    Clientes clientes = new Clientes();
    Insert insert = new Insert();
    Update update = new Update();
    Delete delete = new Delete();
    Select select = new Select();
    String ventana = "./cliente.jsp";

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
            out.println("<title>Servlet ServletClientes</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletClientes at " + request.getContextPath() + "</h1>");
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
            //SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            String nombre = request.getParameter("nombrecliente");
            String fecha = request.getParameter("fecha");
            LocalDate fechaCliente = null;
            try {
                fechaCliente = LocalDate.parse(fecha, formato);
            } catch (DateTimeParseException ex) {
                Logger.getLogger(ServletClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            String descripcion = request.getParameter("descripcioncliente");
            String tiempoPagadoString = request.getParameter("tiempopagado");
            String[] partes3 = tiempoPagadoString.split(":");
            int horas1 = Integer.parseInt(partes3[0]); // Convertir la parte de las horas a entero
            int minutos = Integer.parseInt(partes3[1]);

            double minutosComoHoras = minutos / 60.0;
            // Sumar las horas y los minutos (convertidos a fracción de hora)
            double tiempoTotalEnHoras = horas1 + minutosComoHoras;
            //int tiempoPagado = Integer.parseInt(tiempoPagadoString);
            // Recibir las horas iniciales y finales desde el formulario

            String horaInicialString = request.getParameter("horainicial");
            String horaFinalString = request.getParameter("horafinal");

            // Convertir las horas iniciales y finales de String a Time
            Time horaInicial = null;
            Time horaFinal = null;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm"); // Formato de las horas en el formulario
                horaInicial = new Time(sdf.parse(horaInicialString).getTime());
                horaFinal = new Time(sdf.parse(horaFinalString).getTime());
            } catch (ParseException e) {
                // Manejar el error de parseo si es necesario
                e.printStackTrace();
            }
            String tiempoPendiente = request.getParameter("tiempopendiente");
            String numeroPlayString = request.getParameter("zonajuego");
            String controlAdicionalParametro = request.getParameter("controladicional");
            int ControlAdicional = 0;
            char NumeroPlay = numeroPlayString.charAt(0);
            int costoControlAdicional1 = 200;
            int costoControlAdicional2 = 400;
            int totalPagadoplay4 = 0;
            int totalPagadoplay5 = 0;
            int totalPagadoPingPong = 0;
            int totalJugado = 0;
            Select select = new Select();
            try {
                ArrayList<Horas> listaHoras = select.BuscarHoras();
                for (Horas horas : listaHoras) {
                    int ID = horas.getIdCosto();
                    int costoHora = horas.getCostoHora();
                    if (controlAdicionalParametro != null && !controlAdicionalParametro.isEmpty()) {
                        if (numeroPlayString.equals("1") || numeroPlayString.equals("2") || numeroPlayString.equals("3")) {
                            if (ID == 1) {
                                totalPagadoplay4 += costoHora * tiempoTotalEnHoras;
                                totalJugado += totalPagadoplay4;
                                if (controlAdicionalParametro.equals("1")) {
                                    ControlAdicional += costoControlAdicional1;
                                    totalJugado += costoControlAdicional1;
                                } else if (controlAdicionalParametro.equals("2")) {
                                    ControlAdicional += costoControlAdicional2;
                                    totalJugado += costoControlAdicional2;
                                }
                            }
                        } else if (numeroPlayString.equals("4")) {
                            if (ID == 2) {
                                totalPagadoplay5 += costoHora * tiempoTotalEnHoras;
                                totalJugado += totalPagadoplay5;

                                if (controlAdicionalParametro.equals("1")) {
                                    ControlAdicional += costoControlAdicional1;
                                    totalJugado += costoControlAdicional1;
                                } else if (controlAdicionalParametro.equals("2")) {
                                    ControlAdicional += costoControlAdicional2;
                                    totalJugado += costoControlAdicional2;
                                }
                            }
                        } else if (numeroPlayString.equals("5")) {
                            if (ID == 3) {
                                totalPagadoPingPong += costoHora * tiempoTotalEnHoras;
                                totalJugado += totalPagadoPingPong;
                            }
                        }
                    } else {
                          ControlAdicional = 0; // Si es nulo o vacío, no se suma nada adicional.
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(ServletClientes.class.getName()).log(Level.SEVERE, null, ex);
            }

            String JuegosJugados = request.getParameter("juegosjugados");
            String telefono = request.getParameter("telefono");

            //Timestamp resultado = verificarUsuarioCreador(inputEmail1);
            //String inputEmail1 = request.getParameter("inputEmail1");
            //String usuarioCreador = verificarCreador(inputEmail1);
            LocalDateTime fechaCreacion1;
            HttpSession session = request.getSession();
            String usuarioCreador2 = (String) session.getAttribute("inputEmail1");
            LocalDateTime fechaModificacion2 = null;
            String usuarioModificador2= null;            
            fechaCreacion1 = LocalDateTime.now();
            try {
                insert.insertarCliente(nombre, fechaCliente, descripcion, tiempoPagadoString, horaInicial, horaFinal, tiempoPendiente, NumeroPlay, JuegosJugados, ControlAdicional, totalPagadoPingPong, totalPagadoplay4, totalPagadoplay5, totalJugado, telefono, usuarioCreador2, fechaCreacion1, usuarioModificador2, fechaModificacion2);
            } catch (SQLException ex) {
                //Logger.getLogger(ServletClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher view = request.getRequestDispatcher(ventana);
            view.forward(request, response);

        }
        
        if(accion.equalsIgnoreCase("borrar")){
            
            if (request.getParameter("idbuscarcliente") != null) {
                   int idusuario = Integer.parseInt(request.getParameter("idbuscarcliente"));
      
                  delete.eliminarClientes(idusuario);
           }
   
                   
           RequestDispatcher view = request.getRequestDispatcher(ventana);
           view.forward(request, response);
        }
        
        if (accion.equalsIgnoreCase("editar")) {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            int idCliente = Integer.parseInt(request.getParameter("idcliente"));
            //SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            String nombre = request.getParameter("nombrecliente");
            String fecha = request.getParameter("fecha");
            LocalDate fechaCliente = null;
            try {
                fechaCliente = LocalDate.parse(fecha, formato);
            } catch (DateTimeParseException ex) {
                Logger.getLogger(ServletClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            String descripcion = request.getParameter("descripcioncliente");
            String tiempoPagadoString = request.getParameter("tiempopagado");
            String[] partes3 = tiempoPagadoString.split(":");
            int horas1 = Integer.parseInt(partes3[0]); // Convertir la parte de las horas a entero
            int minutos = Integer.parseInt(partes3[1]);

            double minutosComoHoras = minutos / 60.0;
            // Sumar las horas y los minutos (convertidos a fracción de hora)
            double tiempoTotalEnHoras = horas1 + minutosComoHoras;
            //int tiempoPagado = Integer.parseInt(tiempoPagadoString);
            // Recibir las horas iniciales y finales desde el formulario

            String horaInicialString = request.getParameter("horainicial");
            String horaFinalString = request.getParameter("horafinal");

            // Convertir las horas iniciales y finales de String a Time
            Time horaInicial = null;
            Time horaFinal = null;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm"); // Formato de las horas en el formulario
                horaInicial = new Time(sdf.parse(horaInicialString).getTime());
                horaFinal = new Time(sdf.parse(horaFinalString).getTime());
            } catch (ParseException e) {
                // Manejar el error de parseo si es necesario
                e.printStackTrace();
            }
            String tiempoPendiente = request.getParameter("tiempopendiente");
            String numeroPlayString = request.getParameter("zonajuego");
            String controlAdicionalParametro = request.getParameter("controladicional");
            int ControlAdicional = 0;
            char NumeroPlay = numeroPlayString.charAt(0);
            int costoControlAdicional1 = 200;
            int costoControlAdicional2 = 400;
            int totalPagadoplay4 = 0;
            int totalPagadoplay5 = 0;
            int totalPagadoPingPong = 0;
            int totalJugado = 0;
            Select select = new Select();
            try {
                ArrayList<Horas> listaHoras = select.BuscarHoras();
                for (Horas horas : listaHoras) {
                    int ID = horas.getIdCosto();
                    int costoHora = horas.getCostoHora();
                    if (controlAdicionalParametro != null && !controlAdicionalParametro.isEmpty()) {
                        if (numeroPlayString.equals("1") || numeroPlayString.equals("2") || numeroPlayString.equals("3")) {
                            if (ID == 1) {
                                totalPagadoplay4 += costoHora * tiempoTotalEnHoras;
                                totalJugado += totalPagadoplay4;
                                if (controlAdicionalParametro.equals("1")) {
                                    ControlAdicional += costoControlAdicional1;
                                    totalJugado += costoControlAdicional1;
                                } else if (controlAdicionalParametro.equals("2")) {
                                    ControlAdicional += costoControlAdicional2;
                                    totalJugado += costoControlAdicional2;
                                }else if (controlAdicionalParametro.equals("Ninguno")) {
                                    ControlAdicional += 0;
                                    totalJugado += 0;
                                }
                            }
                        } else if (numeroPlayString.equals("4")) {
                            if (ID == 2) {
                                totalPagadoplay5 += costoHora * tiempoTotalEnHoras;
                                totalJugado += totalPagadoplay5;

                                if (controlAdicionalParametro.equals("1")) {
                                    ControlAdicional += costoControlAdicional1;
                                    totalJugado += costoControlAdicional1;
                                } else if (controlAdicionalParametro.equals("2")) {
                                    ControlAdicional += costoControlAdicional2;
                                    totalJugado += costoControlAdicional2;
                                }else if (controlAdicionalParametro.equals("Ninguno")) {
                                    ControlAdicional += 0;
                                    totalJugado += 0;
                                }
                            }
                        } else if (numeroPlayString.equals("5")) {
                            if (ID == 3) {
                                totalPagadoPingPong += costoHora * tiempoTotalEnHoras;
                                totalJugado += totalPagadoPingPong;
                                
                                
                            }
                        }
                    }else {
                          // Puedes manejar el caso donde controlAdicionalParametro es nulo o vacío aquí, si es necesario.
                          ControlAdicional = 0; // Si es nulo o vacío, no se suma nada adicional.
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(ServletClientes.class.getName()).log(Level.SEVERE, null, ex);
            }

            String JuegosJugados = request.getParameter("juegosjugados");
            String telefono = request.getParameter("telefono");

            //Timestamp resultado = verificarUsuarioCreador(inputEmail1);
            //String inputEmail1 = request.getParameter("inputEmail1");
            //String usuarioCreador = verificarCreador(inputEmail1);
            LocalDateTime fechaCreacion1;
            HttpSession session = request.getSession();
            String usuarioCreador2 = (String) session.getAttribute("inputEmail1");
            LocalDateTime fechaModificacion2 = null;
            String usuarioModificador2= null;            
            fechaCreacion1 = LocalDateTime.now();
            try {
                update.modificarCliente(idCliente,nombre, fechaCliente, descripcion, tiempoPagadoString, horaInicial, horaFinal, tiempoPendiente, NumeroPlay, JuegosJugados, ControlAdicional, totalPagadoPingPong, totalPagadoplay4, totalPagadoplay5, totalJugado, telefono, usuarioCreador2, fechaCreacion1, usuarioModificador2, fechaModificacion2);
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
