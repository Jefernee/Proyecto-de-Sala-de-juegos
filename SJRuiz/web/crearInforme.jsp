<%-- 
    Document   : crearInforme
    Created on : 8 abr 2024, 22:31:42
    Author     : jefer
--%>
<%@page import="SQL.Conexion"%>
<%@page import="DML.Insert"%>
<%@page import="DML.Update"%>
<%@page import="DML.Delete"%>
<%@page import="DML.Select"%>
<%@page import="Entidades.Informes"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


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
                max-height: 280px; /* Altura máxima del contenedor */
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

        <div class="container text-center">
            <div class="row align-items-start">
                <div class="col">
                    <h3>Registro de Informes</h3>
                </div>
            </div>
            <form class="container text-center" id="registroForm" method="GET" action="ServletInformes">
                <div class="row align-items-start">
                    <div class="col">
                        <div class="mb-2">
                            <label for="nombreinforme"><b>Nombre de Informe</b></label>
                            <input type="text" class="form-control" name="nombreinforme" id="nombreinforme" placeholder="Nombre del Cliente" maxlength="25" required>
                        </div>
                    </div>   
                    <div class="col">
                        <label for="tipoinforme" class="form-label">Elija el tipo de Informe</label>
                        <select class="form-select"  name="tipoinforme" id="tipoinforme" aria-label="Default select example" required>
                            <option>Mes</option>
                            <option value="Anio">Año</option>
                            <option>Personalizado</option>
                        </select>
                        <div class="invalid-feedback">
                            Por favor seleccione.
                        </div>
                    </div>
                    
                    <div class="col">
                        <div class="mb-3">
                            <label for="fechainforme"><b>Fecha de Informe</b></label>
                            <input type="Date" id="fechainforme" name="fechainforme" class="form-control" aria-label="cant" required>
                        </div>
                    </div>
                </div>

                <div class="row align-items-start">
                    <div class="col">
                        <div class="mb-3">
                            <label for="fechainicialinforme"><b>Feha Inicial de Informe</b></label>
                            <input type="Date" id="fechainicialinforme" name="fechainicialinforme" class="form-control"  title="Solamente se va a activar el campo si elige la opción Fechas Personalizadas" aria-label="des" disabled >
                        </div>
                    </div>
                    <div class="col">
                        <div class="mb-3">
                            <label for="fechafinalinforme"><b>Fecha Final de Infome</b></label>
                            <input type="Date" id="fechafinalinforme" name="fechafinalinforme" class="form-control"  title="Solamente se va a activar el campo si elige la opción echas Personalizadas " aria-label="des" disabled>
                        </div>
                    </div>
                    <script>
                        document.getElementById('tipoinforme').addEventListener('change', function () {
                        // Obtener el valor seleccionado del elemento 'estadoproducto'
                       var seleccionado = this.value; 

                        // Obtener los elementos de descripción del problema y reparación
                       var descripcionProblema = document.getElementById('fechainicialinforme');
                       var descripcionReparacion = document.getElementById('fechafinalinforme');

                       // Mostrar valores en la consola para depuración
                       console.log("Valor seleccionado:", seleccionado);
                       console.log("Descripción del problema:", descripcionProblema);
                       console.log("Descripción de la reparación:", descripcionReparacion);

                      // Verificar si la opción seleccionada es 'Malo' o 'Reparado'
                        if (seleccionado === 'Personalizado') {
                            // Habilitar el campo de texto
                            descripcionProblema.removeAttribute('disabled');
                            descripcionReparacion.removeAttribute('disabled');
                        } else {
                             // Deshabilitar el campo de texto
                             descripcionProblema.setAttribute('disabled', 'disabled');
                             descripcionReparacion.setAttribute('disabled', 'disabled');
                        }
                          });
                    </script>
                    <div class="col">
                        <label for="validationServer05" class="form-label"></label>
                        <div class="mb-2">
                            <button type="submit" class="btn btn-primary" name="accion" value="insertar">Crear Informe</button>
                        </div>
                    </div>
                    <div class="col" style="color: red; font-weight: bold;">
                            <c:if test="${not empty mensajeError}">
                              <div class="error">${mensajeError}</div>
                            </c:if>
                    </div>
                </div>
            </form>
        </div>
        <div class="container mt-2">
            
            <div class="table-container">
                <table class="table table-striped table-bordered">
                    <thead class="table-dark">
                        <tr>
                            <th>ID Informe</th>
                            <th>Nombre de Informe</th>                           
                            <th>Descripción de Informe</th>
                            <th>Fecha Informe</th>
                            <th>Día Inicial Informe Personalizado</th>
                            <th>Día Final Informe Personalizado</th>
                            <th>Monto Final Informe Personalizado</th>
                            <th>Monto Final de Informe Mes</th>
                            <th>Monto Final de Informe Año</th>
                            <th>Total de Pagos</th>
                            <th>Total de Ganancia</th>
                            <th>Usuario Creador</th>
                            <th>Fecha Creación</th>
                            <th>Usuario Modificador</th>
                            <th>Fecha Modificación</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% 
                            ArrayList<Informes> informes = select.BuscarInformes();
                            for(Informes m : informes){
                        %>
                        <tr>
                            <td><%= m.getIdInforme() %> </td>
                            <td><%= m.getNombreInforme() %> </td>
                            <td><%= m.getDescripcionInforme() %> </td>
                            <td><%= m.getFechaInforme() %> </td>
                            <td><%= m.getFechaInicialInforme() %> </td>
                            <td><%= m.getFechaFinalInforme() %> </td>
                            <td><%= m.getMontoInformePersonalizado() %> </td>
                            <td><%= m.getMontoMesInforme() %> </td>
                            <td><%= m.getMontoAñoInforme() %> </td>
                            <td><%= m.getTotalPagos() %> </td>
                            <td><%= m.getTotalGanancias() %> </td>
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

