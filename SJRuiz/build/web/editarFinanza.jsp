<%-- 
    Document   : editarFinanza
    Created on : 8 abr 2024, 22:42:42
    Author     : jefer
--%>
<%@page import="SQL.Conexion"%>
<%@page import="DML.Insert"%>
<%@page import="DML.Update"%>
<%@page import="DML.Delete"%>
<%@page import="DML.Select"%>
<%@page import="Entidades.Finanzas"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <title>Modificar Finanza</title>
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
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="font-size: 20px; color: white;">
                                <b>Inventario Sala</b>
                            </a>
                            <ul class="dropdown-menu bg-dark">
                                <li><a class="dropdown-item text-white" href="./agregarProductos.jsp"  >Agregar productos</a></li>

                                <li><a class="dropdown-item text-white" href="./editarProductos.jsp">Modificar o eliminar productos</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" title="primero debe ir a Gestion de horas y crear las horas" style="font-size: 20px; color: white;">
                                <b>Clientes</b>
                            </a>
                            <ul class="dropdown-menu bg-dark">
                                <li><a class="dropdown-item text-white" href="./cliente.jsp">Registro de juego</a></li>

                                <li><a class="dropdown-item text-white" href="./editarCliente.jsp">Modificar o eliminar registro</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="font-size: 20px; color:white;">
                                <b>Informes</b>
                            </a>
                            <ul class="dropdown-menu bg-dark">
                                <li><a class="dropdown-item text-white" href="./crearInforme.jsp">Crear Informe</a></li>
                                <li><a class="dropdown-item text-white" href="./eliminarInformes.jsp">Eliminar Informes</a></li>
                                <li><hr class="dropdown-divider border-white"></li>
                                <li><a class="dropdown-item text-white" href="./verInformeMes.jsp">Ver Informe Mes</a></li>
                                <li><a class="dropdown-item text-white" href="./verInformeAño.jsp">Ver Informe Año</a></li>
                                <li><a class="dropdown-item text-white" href="./filtrarfechasInforme.jsp">Ver Informe Personalizado</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="font-size: 20px; color: white;">
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
                                 
                                <% if ("Empleado".equals(rolUsuario)) { %>
                                   <li><a class="dropdown-item text-white" href="./editarUsuarios.jsp" onclick="return false;">Modificar o Eliminar Usuarios</a></li>
                                <% } else { %>
                                    <li><a class="dropdown-item text-white" href="./editarUsuarios.jsp">Modificar o Eliminar Usuarios</a></li>
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
                    <h3>Modificar o Eliminar Finanzas</h3>
                </div>
            </div>
            <form class="container text-center" id="registroForm">
                <div class="row align-items-start">
                    <div class="col">
                        <div class="mb-2">
                            <label for="nombreFinanza"><b>Nombre de Finanza</b></label>
                            <input type="text" id=nombreFinanza name="nombre" class="form-control" placeholder="" aria-label="Nombre" required>
                        </div>
                    </div>
                    <div class="col">
                        <label for="desfinanza"><b>Descripción de Finanza</b></label>
                        <input type="text" id="desfinanza" name="descripcion" class="form-control" placeholder="Descripción" aria-label="Descripción" required>
                    </div>
                    <div class="col">
                        <label for="fechafinanza"><b>Fecha de Finanza </b></label>
                        <input type="datetime-local" id="fechafinanza" name="fecha" class="form-control" placeholder="Fecha" aria-label="Fecha" required>
                    </div>
                    <div class="col">
                        <label for="montoluz"><b>Monto de Luz</b></label>
                        <input type="number" id="montoluz" name="precio" class="form-control" placeholder="2000" aria-label="precio" required>
                    </div>

                </div>

                <div class="row align-items-start">
                    <div class="col">
                        <div class="mb-3">
                            <label for="montomaquinas"><b>Monto de Maquinas</b></label>
                            <input type="number" id="montomaquinas" name="precio" class="form-control" placeholder="10000" aria-label="precio" required>
                        </div>
                    </div>
                    <div class="col">
                        <div class="mb-3">
                            <label for="montoagua"><b>Monto de Agua</b></label>
                            <input type="number" id="montoagua" name="precio" class="form-control" placeholder="5000" aria-label="precio" required>
                        </div>
                    </div>
                    <div class="col">
                        <div class="mb-3">
                            <label for="montointernet"><b>Monto de Internet</b></label>
                            <input type="number" id="montointernet" name="precio" class="form-control" placeholder="20000" aria-label="precio" required>
                        </div>
                    </div>
                    <div class="col">
                        <div class="mb-3">
                            <label for="montoplan"><b>Monto de Plan</b></label>
                            <input type="number" id="montoplan" name="precio" class="form-control" placeholder="10000" aria-label="precio" required>
                        </div>
                    </div>
                    <div class="col">          
                        <div class="mb-3">
                            <label for="montofutbolin"><b>Monto de Futbolin</b></label>
                            <input type="number" id="montofutbolin" name="precio" class="form-control" placeholder="20000" aria-label="precio" required>
                        </div>
                    </div>
                    <div class="row align-items-start">
                        <div class="col-4">
                            <div class="input-group">
                                <input type="number" id="nombre" name="nombre" class="form-control" placeholder="Digite el ID a buscar" title="digite solo numeros" aria-label="Nombre" required>
                                <button class="btn btn-primary" type="button">Buscar Producto</button>
                            </div>
                        </div>
                        <div class="col-2">
                            <div class="mb-2">
                                <button type="submit" class="btn btn-warning">Modificar Finanza</button>
                            </div>
                        </div>
                        <div class="col-2">
                            <div class="mb-2">
                                <button type="submit" class="btn btn-danger">Eliminar Finanza</button>
                            </div>
                        </div>
                    </div>

                </div>
            </form>
        </div>
        <div class="container mt-2">
            
            <div class="table-container">
                <table class="table table-striped table-bordered">
                    <thead class="table-dark">
                        <tr>
                            <th>ID Finanza</th>
                            <th>Nombre de Finanza</th>                           
                            <th>Descripción de Finanza</th>
                            <th>Monto de Maquinas</th>
                            <th>Monto de Futbolin</th>
                            <th>Monto de Luz</th>
                            <th>Monto de Agua</th>
                            <th>Monto de Internet</th>
                            <th>Monto de Plan</th>
                            <th>Monto Final Finanza</th>
                            <th>Fecha</th>
                            <th>Usuario Creador</th>
                            <th>Fecha Creación</th>
                            <th>Usuario Modificador</th>
                            <th>Fecha Modificación</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% 
                            ArrayList<Finanzas> finanzas = select.BuscarFinanzas();
                            for(Finanzas m : finanzas){
                        %>
                        <tr>
                            <td><%= m.getIdFinanza() %> </td>
                            <td><%= m.getNombreFinanza() %> </td>
                            <td><%= m.getDescripcion() %> </td>
                            <td><%= m.getMontoMaquinas() %> </td>
                            <td><%= m.getMontoFutbolin() %> </td>
                            <td><%= m.getMontoLuz() %> </td>
                            <td><%= m.getMontoAgua() %> </td>
                            <td><%= m.getMontoInternet() %> </td>
                            <td><%= m.getMontoPlan() %> </td>
                            <td><%= m.getMontoFinalFinanza() %> </td>
                            <td><%= m.getFecha() %> </td>
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

