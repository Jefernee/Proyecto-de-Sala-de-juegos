<%-- 
    Document   : verInformeAño
    Created on : 8 abr 2024, 22:55:08
    Author     : jefer
--%>
<%@page import="SQL.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <title>TODO supply a title</title>
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
                            <a class="nav-link active fs-5" href="./agregarProductos.jsp" role="button"  aria-expanded="false" style="font-size: 20px; color: white;">
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
        <div class="container-fluid">
            <div class="row justify-content-center align-items-center" style="height: 100vh;">
                <div class="col-md-8">
                    <div class="card text-center">
                        <div class="card-header">
                            Informe Año - Enero 2024
                        </div>
                        <div class="card-body text-center dark">
                            <h5 class="card-title">Nombre del Informe: Informe de Ventas</h5>
                            <p class="card-text">Descripción: Este informe contiene datos de ventas para el mes de enero de 2024.</p>
                            <p class="card-text">Fecha de Informe: 2024-01-01</p>
                            <p class="card-text">Total de Ventas de Plays: $1500</p>
                            <p class="card-text">Total de Jugado de Futbolín: $300</p>
                            <p class="card-text">Total de Jugado de Ping Pong: $200</p>
                            <p class="card-text">Total de Jugado de Maquinas: $600</p>
                            <p class="card-text">Suma General de Ventas: $2000</p>
                            <h4 class="card-title">Ganancias Netas</h4>
                            <p class="card-text">Pagos del Mes: $10000</p>
                            <p class="card-text">Ganancias Netas: $2000 - $500 (Pagos del Mes) = $1500</p>
                            <p class="card-text">Juegos más Jugados:EAFC24</p>
                            <button class="btn btn-primary">Generar Informe</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

