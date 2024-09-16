<%-- 
    Document   : cliente
    Created on : 8 abr 2024, 22:27:15
    Author     : jefer
--%>
<%@page import="SQL.Conexion"%>
<%@page import="DML.Insert"%>
<%@page import="DML.Update"%>
<%@page import="DML.Delete"%>
<%@page import="DML.Select"%>
<%@page import="Entidades.Clientes"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <title>Clientes</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <style>

            body {
                background-image: url('https://th.bing.com/th/id/R.8ef8f65f7c93494b7e19c8eb7f81a3f3?rik=9%2fCjV50%2f9ajT7g&riu=http%3a%2f%2fk42.kn3.net%2ftaringa%2fC%2f5%2f9%2f1%2f9%2f7%2fagente867%2f12B.jpg&ehk=YPc%2fLK6HFcJ%2fpptujb7W%2f1D27gYg6ZP4804Tx%2byRnPA%3d&risl=&pid=ImgRaw&r=0');
                background-size: cover;
                background-position: center;
                background-repeat: no-repeat;
                min-height: 100vh;
                color:white;

            }
            .table-container {
                max-width: 100%;
                overflow-x: auto;
                overflow-y: auto;
                white-space: nowrap;
                border: 1px solid rgba(255, 255, 255, 0.3);
                border-radius: 10px;
                padding: 10px;
            }
            .table {
                background-color: rgba(255, 255, 255, 0.7);
                color: black;
            }
            .table-container {
                overflow-x: auto; /* Hacer que sea scrollable horizontalmente */
                overflow-y: auto; /* Hacer que sea scrollable verticalmente */
                max-height: 500px; /* Altura máxima del contenedor */
                border: 1px solid rgba(255, 255, 255, 0.3);
                border-radius: 10px;
            }
            .table {
                background-color: rgba(255, 255, 255, 0.7);
                color: black;
            }


        </style>
    </head>
    <body>
        <%! DML.Select select = new DML.Select(); %>
        <% String rolUsuario = (String) session.getAttribute("rolUsuario"); %>
        <nav class="navbar navbar-expand-lg" data-bs-theme="dark" >
            <div class="container-fluid">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active fs-5" href="./agregarProductos.jsp" role="button" aria-expanded="false" style="font-size: 20px; color: white;">
                                <b>Inventario Sala</b>
                            </a>
                            
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active fs-5" href="./cliente.jsp" role="button" aria-expanded="false" title="primero debe ir a Gestion de horas y crear las horas" style="font-size: 20px; color: white;">
                                <b>Clientes</b>
                            </a>
                            
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="font-size: 20px; color:white;">
                                <b>Informes</b>
                            </a>
                            <ul class="dropdown-menu bg-dark">
                                <li><a class="dropdown-item text-white" href="./crearInforme.jsp">Crear Informe</a></li>
                                
                                <li><hr class="dropdown-divider border-white"></li>
                                <li><a class="dropdown-item text-white" href="./verInformeMes.jsp">Ver Informe Mes</a></li>
                                <li><a class="dropdown-item text-white" href="./verInformeAño.jsp">Ver Informe Año</a></li>
                                <li><a class="dropdown-item text-white" href="./filtrarfechasInforme.jsp">Ver Informe Personalizado</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active fs-5" href="./añadirFinanzas.jsp" role="button" aria-expanded="false" style="font-size: 20px; color: white;">
                                <b>Finanzas</b>
                            </a>
                            <ul class="dropdown-menu bg-dark">
                                <li><a class="dropdown-item text-white" href="./añadirFinanzas.jsp"  >Añadir Finanzas</a></li>
                                         
                                <li><a class="dropdown-item text-white" href="./editarFinanza.jsp"  >Modificar Finanzas</a></li>                                
                            </ul>
                        </li>
                        <li class="nav-item dropdown ">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="font-size: 20px; color: white;">
                                <b>Usuarios</b>
                            </a>
                            <ul class="dropdown-menu bg-dark">
                                <% if ("Empleado".equals(rolUsuario)) { %>
                                   <li><a class="dropdown-item text-white" href="./creacionUsuarios.jsp" onclick="return false;" >Crear Usuarios</a></li>
                                <% } else { %>
                                    <li><a class="dropdown-item text-white" href="./creacionUsuarios.jsp">Crear Usuarios</a></li>
                                <% } %>
                                 
                              
                            </ul>
                        </li>
                        <li class="nav-item dropdown ">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="font-size: 20px; color: white;">
                                <b>Gestor de Precios</b>
                            </a>
                            <ul class="dropdown-menu bg-dark">
                                <% if ("Empleado".equals(rolUsuario)) { %>
                                   <li><a class="dropdown-item text-white" href="./editarPrecios.jsp" onclick="return false;">Gestion de horas</a></li>
                                <% } else { %>
                                   <li><a class="dropdown-item text-white" href="./editarPrecios.jsp">Gestion de horas</a></li>
                                <% } %>
                            </ul>
                        </li>
                    </ul>

                    <form class="d-flex" role="search">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>


        <div class="container text-center">
            <div class="row align-items-start">
                <div class="col">
                    <h3>Registrar Clientes</h3>
                </div>
            </div>
            <form class="container text-center" id="registroForm" method="GET" action="ServletClientes">
                <div class="row align-items-start">
                    <div class="col">
                        <div class="mb-2">
                            <label for="nombrecliente"><b>Nombre del cliente</b></label>
                            <input type="text" class="form-control" name="nombrecliente" id="nombrecliente" placeholder="Nombre del Cliente" maxlength="15" required>
                        </div>
                    </div>
                    <div class="col">
                        <div class="mb-2">
                            <label for="descripcionclliente"><b>Descripcion del cliente</b></label>
                            <input type="text" class="form-control" name="descripcioncliente" id="descripcioncliente" maxlength="15" placeholder="Descripcion del Cliente" required>
                        </div>
                    </div>
                    <div class="col">
                        <div class="mb-2">
                            <label for="fecha"><b>Fecha</b></label>
                            <input type="date" class="form-control" name="fecha" id="fecha" placeholder="Fecha" required>
                        </div>
                    </div>
                    
                    <div class="col">
                           <label for="idcliente"><b>Digite el ID a Modificar </b></label>
                          <div class="input-group mb-2">
                            <input type="number" class="form-control" name="idcliente" id="idcliente" placeholder="1">
                            <button type="submit" class="btn btn-warning" name="accion" value="editar">Modificar Cliente</button>                           
                          </div>
                    </div>
                    
                </div>

                <div class="row align-items-start">
                    <div class="col">
                        <div class="mb-2">
                            <label for="tiempopagado"><b>Tiempo pagado</b></label>
                            <input type="time" class="form-control" name="tiempopagado" id="tiempopagado" placeholder="Tiempo Pagado"required>
                        </div>
                    </div>
                    <div class="col">
                        <div class="mb-2">
                            <label for="horainicial"><b>Hora Inicial</b></label>
                            <input type="time" class="form-control" name="horainicial" id="horainicial" placeholder="Hora Inicial" required>
                        </div>
                    </div>
                    <div class="col">
                        <div class="mb-2">
                            <label for="horafinal"><b>Hora Final</b></label>
                            <input type="time" class="form-control" name="horafinal" id="horafinal" placeholder="Hora Final" required>
                        </div>
                    </div>
                    <div class="col">
                           <div class="mb-3">
                                <label for="zonajuego"><b>Control Adicional</b></label>
                                <select class="form-select" name="controladicional" id="controladicional" required>
                                      <option >1</option>
                                      <option >2</option>
                                      <option >Ninguno</option>
                                      
                                </select>
                           </div>
                    </div>
                    <div class="row align-items-start">
                        <div class="col">
                            <div class="mb-2">
                                <label for="tiempopendiente"><b>Tiempo Pendiente</b></label>
                                <input type="text" class="form-control" name="tiempopendiente" id="tiempopendiente" maxlength="10" placeholder="30 min">
                            </div>
                        </div>
                        <div class="col">
                           <div class="mb-3">
                                <label for="zonajuego"><b>Eleccion zona de juego</b></label>
                                <select class="form-select" name="zonajuego" id="zonajuego" required>
                                      <option value="1">Play #1</option>
                                      <option value="2">Play #2</option>
                                      <option value="3">Play #3</option>
                                      <option value="4">Play 5 #4</option>
                                      <option value="5">Ping Pong #5</option>
                                </select>
                            </div>
                        </div>
                        <div class="col">
                            <div class="mb-2">
                                <label for="juegosjugados"><b>Juegos Jugados</b></label>
                                <input type="text" class="form-control" name="juegosjugados" id="juegosjugados" maxlength="25" placeholder="juegos Jugados">
                            </div>
                        </div>
                        <div class="col">
                            <div class="mb-2">
                                <label for="telefono"><b>telefono</b></label>
                                <input type="number" class="form-control" name="telefono" id="telefono" maxlength="15" placeholder="">
                            </div>
                        </div>
                        
                        
                        <div class="col">
                            <label for="hora_inicial"><b>Finalizar</b></label>
                            <div class="mb-2">
                                
                                <button type="submit" class="btn btn-primary" name="accion" value="insertar" >Registrar Cliente</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <form class="container text-center" id="registroForm" method="GET" action="ServletClientes">
                <div class="row align-items-start">
                    <div class="col-3">
                      <div class="input-group mb-2">
                               <input type="text" class="form-control" name="idbuscarcliente" id="idbuscarcliente" placeholder="ID " aria-describedby="button-addon2" required>
                               <button class="btn btn-danger" type="submit" name="accion" value="borrar">Eliminar Cliente</button>
                      </div>
                    </div>
                    
                    <div class="col-3">
                        <label for="idcliente"><b>Si se Crea el cliente no se pone ID, solamente cuando se modifica</b></label>
                    </div>
                </div>
            </form>
        </div>
        <div class="container mt-2">
            
            <div class="table-container">
                <table class="table table-striped table-bordered">
                    <thead class="table-dark">
                        <tr>
                            <th>ID Cliente</th>
                            <th>Nombre</th>
                            <th>Fecha</th>
                            <th>Descripción</th>
                            <th>Tiempo Pagado</th>
                            <th>Hora Inicial</th>
                            <th>Hora Final</th>
                            <th>Tiempo Pendiente</th>
                            <th>Zona de juego</th>
                            <th>Juegos Jugados</th>
                            <th>Control Adicional</th>
                            <th>Mesa Ping Pong</th>
                            <th>Play 4</th>
                            <th>Play 5</th>
                            <th>Total Jugado</th>
                            <th>Teléfono</th>
                            <th>Usuario Creador</th>
                            <th>Fecha Creación</th>
                            <th>Usuario Modificador</th>
                            <th>Fecha Modificación</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% 
                            ArrayList<Clientes> clientes = select.BuscarClientes();
                            for(Clientes m : clientes){
                        %>
                        <tr>
                            <td><%= m.getIdCliente() %> </td>
                            <td><%= m.getNombre() %> </td>
                            <td><%= m.getFecha() %> </td>
                            <td><%= m.getDescripcion() %> </td>
                            <td><%= m.getTiempoPagado() %> </td>
                            <td><%= m.getHoraInicial() %> </td>
                            <td><%= m.getHoraFinal() %> </td>
                            <td><%= m.getTiempoPendiente() %> </td>
                            <td><%= m.getNumeroplay() %> </td>
                            <td><%= m.getJuegosJugados() %> </td>
                            <td><%= m.getControlAdicional() %> </td>
                            <td><%= m.getMesaPingPong() %> </td>
                            <td><%= m.getPlay4() %> </td>
                            <td><%= m.getPlay5() %> </td>
                            <td><%= m.getTotalJugado() %> </td>
                            <td><%= m.getTelefono() %> </td>
                            <td><%= m.getUsuarioCreacion() %> </td>
                            <td><%= m.getFechaCreacion() %> </td>
                            <td><%= m.getUsuarioModificador() %> </td>
                            <td><%= m.getFechaModificacion() %> </td>
                        </tr>
                        <% 
                          }
                        %>
                    </tbody>
                </table>
            </div>
        </div>

    </body>
</html>

