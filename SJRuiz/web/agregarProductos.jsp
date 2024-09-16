<%-- 
    Document   : agregarProductos
    Created on : 8 abr 2024, 22:18:47
    Author     : jefer
--%>
<%@page import="SQL.Conexion"%>
<%@page import="DML.Insert"%>
<%@page import="DML.Update"%>
<%@page import="DML.Delete"%>
<%@page import="DML.Select"%>
<%@page import="Entidades.InventarioSala"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <title>Registrar Productos</title>
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
                    <h3>Registrar Producto</h3>
                </div>
            </div>
            <form class="container text-center" id="registroForm" method="GET" action="ServletInventarioSala">
                <div class="row align-items-start">
                    <div class="col-4">
                        <label for="idproducto"><b>ID Producto de Crear o Modificar</b></label>
                        <div class="input-group mb-2">
                            <input type="text" class="form-control" name="idproducto" maxlength="35" id="idproducto" placeholder="Control ps4001" required>
                            <button type="submit" class="btn btn-warning" name="accion" value="editar">Modificar Producto</button>                           
                        </div>
                    </div>
                    <div class="col">
                        <label for="nombreproducto"><b>Nombre del Producto</b></label>
                        <div class="mb-2">
                            <input type="text" class="form-control" maxlength="25" name="nombreproducto" id="nombreproducto" placeholder="Control ps4" required>
                        </div>
                    </div>
                    <div class="col">
                        <label for="descripcionproducto"><b>Descripcion del producto</b></label>
                        <div class="mb-2">
                            <input type="text" class="form-control" maxlength="30" name="descripcionproducto" id="descripcionproducto" placeholder="control nuevo" required>
                        </div>
                    </div>
                    <div class="col">
                        <label for="fechacompra"><b>Fecha de Compra</b></label>
                        <div class="mb-2">
                            <input type="DATE" class="form-control" name="fechacompra" id="fechacompra" placeholder="" required>
                        </div>
                    </div>
                </div>

                <div class="row align-items-start">
                    <div class="col">
                        <label for="garantia"><b>Garantía</b></label>
                        <div class="mb-2">
                            <input type="text" class="form-control" name="garantia" maxlength="10" id="garantia" placeholder="2 años">
                        </div>
                    </div>
                    <div class="col">
                        <label for="preciocomprado"><b>Precio Comprado</b></label>
                        <div class="mb-2">
                            <input type="number" class="form-control" name="preciocomprado" id="preciocomprado" placeholder="25000" required>
                        </div>
                    </div>
                    <div class="col">
                        <label for="lugarcomprado"><b>Lugar de Compra</b></label>
                        <div class="mb-2">
                            <input type="text" class="form-control" maxlength="25" name="lugarcomprado" id="lugarcomprado" placeholder="Gamer XYZ"required>
                        </div>
                    </div>
                    <div class="col">
                        <label for="telefonolugar"><b>Telefono del Lugar</b></label>
                        <div class="mb-2">
                            <input type="number" class="form-control" maxlength="15" name="telefonolugar" id="telefonolugar" placeholder="7658-2316">
                        </div>
                    </div>
                </div>
                <div class="row align-items-start">
                    <div class="col">
                        <label for="cantidad"><b>Cantidad</b></label>
                        <div class="mb-2">
                            <input type="number" class="form-control" name="cantidad" id="cantidad" placeholder="" required>
                        </div>
                    </div>
                    <div class="col">
                           <div class="mb-3">
                                <label for="estadoproducto"><b>Estado del Producto</b></label>
                                <select class="form-select" name="estadoproducto" id="estadoproducto" required>
                                      <option>Recien Comprado</option>
                                      <option>Bueno</option>
                                      <option>Malo</option>
                                      <option>Reparado</option>
                                      
                                </select>
                           </div>
                    </div>                   
                    
                    <div class="col">
                        <label for="desproblema"><b>Descripcion de Problema</b></label>
                        <div class="mb-2">
                            <input type="text" class="form-control" maxlength="30" name="desproblema" id="desproblema" placeholder="boton Triagulo" disabled required>
                        </div>
                    </div>
                    <div class="col">
                        <label for="desreparacion"><b>Descripcion de Reparación</b></label>
                        <div class="mb-2">
                            <input type="text" class="form-control" maxlength="30" name="desreparacion" id="desreparacion" placeholder="boton Triagulo" disabled required>
                        </div>
                    </div>
                    <div class="col">
                        <label for="fin"><b>Finalizar</b></label>
                        <div class="mb-2"> 
                            <button type="submit" class="btn btn-primary" name="accion" value="insertar">Crear Producto</button>
                        </div>
                    </div>
                    
                    
                        
                    <script>
                        document.getElementById('estadoproducto').addEventListener('change', function () {
                        // Obtener el valor seleccionado del elemento 'estadoproducto'
                       var seleccionado = this.value; 

                        // Obtener los elementos de descripción del problema y reparación
                       var descripcionProblema = document.getElementById('desproblema');
                       var descripcionReparacion = document.getElementById('desreparacion');

                       // Mostrar valores en la consola para depuración
                       console.log("Valor seleccionado:", seleccionado);
                       console.log("Descripción del problema:", descripcionProblema);
                       console.log("Descripción de la reparación:", descripcionReparacion);

                      // Verificar si la opción seleccionada es 'Malo' o 'Reparado'
                        if (seleccionado === 'Malo' || seleccionado === 'Reparado') {
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
                </div>
            </form>
            <form class="container text-center" id="registroForm" method="GET" action="ServletInventarioSala">
                <div class="row align-items-start">
                                       
                    <div class="col-3">  
                        <label for="fin"><b>Digite El ID a Eliminar Solamente</b></label>
                        <div class="input-group mb-2">   
                            <input type="text" id="idbuscar" name="idbuscar" class="form-control" placeholder="Digite el ID a buscar" title="digite solo numeros" aria-label="Nombre" required>
                            <button type="submit" class="btn btn-danger" name="accion" value="borrar">Eliminar Producto</button>
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
                            <th>ID Cliente</th>
                            <th>Nombre Producto</th>                           
                            <th>Descripción Producto</th>
                            <th>Fecha Compra</th>
                            <th>Garantía</th>
                            <th>Cantidad</th>
                            <th>Precio Comprado</th>
                            <th>Lugar Comprado</th>
                            <th>Telefono Lugar</th>
                            <th>Estado Producto</th>
                            <th>Descripción Problema</th>
                            <th>Descripcion Reparación</th>
                            <th>Usuario Creador</th>
                            <th>Fecha Creación</th>
                            <th>Usuario Modificador</th>
                            <th>Fecha Modificación</th>
                        </tr>
                    </thead>    
                    <tbody>
                        <% 
                            ArrayList<InventarioSala> inventariosala = select.BuscarProductos();
                            for(InventarioSala m : inventariosala){
                        %>
                        <tr>
                            <td><%= m.getIdProducto() %> </td>
                            <td><%= m.getNombreProducto() %> </td>
                            <td><%= m.getDescripcionProducto() %> </td>
                            <td><%= m.getFechaCompra() %> </td>
                            <td><%= m.getGarantia() %> </td>
                            <td><%= String.valueOf(m.getCantidad()) %> </td>
                            <td><%= String.valueOf(m.getPrecioComprado()) %> </td>
                            <td><%= m.getLugarComprado() %> </td>
                            <td><%= m.getTelefonoLugar() %> </td>
                            <td><%= m.getEstadoProducto() %> </td>
                            <td><%= m.getDescripcionProblema() %> </td>
                            <td><%= m.getDescripcionReparacion() %> </td>
                            <td><%= m.getUsuarioCreacion() %> </td>
                            <td><%= m.getFechaCreacion() %> </td>
                            <td><%= m.getUsuarioModificador() %> </td>
                            <td><%= m.getFechaModificacion() %> </td>
                        </tr>
                        <% 
                          }
                        %>
                    <tbody>
                    
                    
                </table>
            </div>
        </div>
        
    </body>
</html>

