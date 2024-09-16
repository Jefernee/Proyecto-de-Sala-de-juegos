<%-- 
    Document   : creacionUsuarios
    Created on : 8 abr 2024, 22:29:42
    Author     : jefer
--%>
<%@page import="SQL.Conexion"%>
<%@page import="DML.Insert"%>
<%@page import="DML.Update"%>
<%@page import="DML.Delete"%>
<%@page import="DML.Select"%>
<%@page import="Entidades.Usuarios"%>
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
            input[type="text"],
            input[type="email"],
            input[type="password"] {
                
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
                max-height: 260px; /* Altura máxima del contenedor */
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
                            <a class="nav-link active fs-5" href="./añadirFinanzas.jsp" role="button"  aria-expanded="false" style="font-size: 20px; color: white;">
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
                    <h3>Crear Usuarios</h3>
                </div>
            </div>
            <form class="container text-center" id="registroForm" method="GET" action="ServletUsuarios">
                <div class="row align-items-start">
                    <div class="col">
                        <div class="mb-2">
                            <label for="nombreApellido" class="form-label">Nombre y Apellidos</label>
                            <input type="text" class="form-control is valid" name="nombreApellido" id="nombreApellido" PlaceHolder="Anfernee Ruiz Garcia" maxlength="25" required>
                        </div>
                    </div>
                    <div class="col">
                        <label for="usuario" class="form-label">Usuario</label>
                        <div class="input-group has-validation">
                            <span class="input-group-text" id="inputGroupPrepend3">@</span>
                            <input type="text" class="form-control" name="usuario" id="usuario" placeholder="Jefernee" aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" maxlength="25" required>
                        </div>
                    </div>
                    <div class="col">
                        <label for="correo" class="form-label">Correo</label>
                        <input type="email" class="form-control"  name="correo" id="correo" placeholder="Jefernee31@gmail.com" aria-describedby="validationServer03Feedback" maxlength="25" required>
                        <div id="validationServer03Feedback" class="invalid-feedback">
                            Digite un correo electronico válido.
                        </div>
                    </div>
                    <div class="col">
                        <label for="tipousuario" class="form-label">Elija el Usuario</label>
                        <select class="form-select"  name="tipousuario" id="tipousuario" aria-label="Default select example" required>
                            <option value="Administrador">Administrador</option>
                            <option value="Empleado">Empleado</option>
                        </select>
                        <div class="invalid-feedback">
                            Por favor seleccione un tipo de usuario.
                        </div>
                    </div>
                </div>

                <div class="row align-items-start">
                    <div class="col">
                        <label for="inputPassword5" class="form-label">Contraseña</label>
                        <input type="password" name="inputPassword5" id="inputPassword5" class="form-control" title="Tu contraseña debe de tener de 8 a 20 caracteres,letra mayuscula, contener letras, numeros, sin espacios y debe de tener caracteres especiales." aria-describedby="passwordHelpBlock" placeholder="Contraseña" maxlength="25" required>
                        <div id="passwordHelpBlock" class="form-text" style="color: white;">      
                        </div>
                    </div>
                    <script>
                        // Función para validar y actualizar el mensaje de ayuda
                        function validarContraseña() {
                            var password = document.getElementById("inputPassword5").value;
                            var passwordHelpBlock = document.getElementById("passwordHelpBlock");
                            var isValid = true;

                            // Validar la longitud de la contraseña
                            if (password.length < 8 || password.length > 20) {
                                isValid = false;
                            }

                            // Validar si contiene números
                            if (!/\d/.test(password)) {
                                isValid = false;
                            }

                            // Validar si contiene espacios
                            if (/\s/.test(password)) {
                                isValid = false;
                            }

                            // Validar si contiene al menos una letra mayúscula
                            if (!/[A-Z]/.test(password)) {
                                isValid = false;
                            }

                            // Validar si contiene caracteres especiales
                            if (!/[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]+/.test(password)) {
                                isValid = false;
                            }

                            // Mostrar mensaje de ayuda según la validez de la contraseña
                            if (isValid) {
                                passwordHelpBlock.style.color = "white";
                                passwordHelpBlock.textContent = "Contraseña válida";
                            } else {
                                passwordHelpBlock.style.color = "red";
                                passwordHelpBlock.textContent = "La contraseña no cumple con los requisitos";
                            }

                            return isValid; // Devolver el resultado de la validación
                        }

                        // Asociar la función validarContraseña al evento input del campo de contraseña
                        document.getElementById("inputPassword5").addEventListener("input", validarContraseña);

                        // Asociar la función validarContraseña al evento submit del formulario
                        document.getElementById("registroForm").addEventListener("submit", function (event) {
                            if (!validarContraseña()) {
                                event.preventDefault(); // Evita que el formulario se envíe si la contraseña no es válida
                            }
                        });
                    </script>
                    <div class="col">
                        <label for="estado" class="form-label">Estado</label>
                        <select class="form-select" name="estado" id="estado" aria-describedby="validationServer04Feedback" required>
                            <option>Activo</option>
                            <option>Inactivo</option>
                        </select>
                    </div>
                    <div class="col">
                        <label for="telefono1" class="form-label">Teléfono</label>
                        <input type="number" class="form-control" name="telefono1" id="telefono1" placeHolder="67543201" title="Digite solo numeros" aria-describedby="validationServer05Feedback" maxlength="15" required>
                    </div>
                    <div class="col">
                           <label for="validationServer05" class="form-label">Modificar</label>
                           <div class="input-group mb-2">
                               <input type="text" class="form-control" name="idmodificar" id="idmodificar" placeholder="ID " aria-describedby="button-addon2">
                               <button class="btn btn-warning" type="submit" name="accion" value="editar" id="button-addon2">Modificar Usuario</button>
                           </div>
                    </div>
                    <div class="col">
                        <label for="validationServer05" class="form-label">Finalizar</label>
                        <div class="mb-2">
                            <button type="submit" class="btn btn-primary" name="accion" value="insertar">Crear Usuario</button>
                        </div>
                    </div>

                </div>
            </form>
            <form class="container text-center" id="registroForm" method="GET" action="ServletUsuarios">
                <div class="row align-items-start">
                    
                    
                    <div class="col-3">                       
                        <div class="input-group mb-2"> 
                            <input type="text" id="idbuscarusuario" name="idbuscarusuario" class="form-control" placeholder="Digite el ID a buscar" title="digite solo numeros" aria-label="Nombre" required>
                            <button type="submit" class="btn btn-danger" name="accion" value="borrar">Eliminar Usuario</button>
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
                            <th>ID Usuario</th>
                            <th>ID Rol</th>
                            <th>Nombre y Apellidos</th>                           
                            <th>Usuario</th>
                            <th>Correo Electronico</th>
                            <th>Contraseña</th>
                            <th>Estado</th>                           
                            <th>Telefono</th>
                            <th>Rol</th>
                            <th>Usuario Creador</th>
                            <th>Fecha Creación</th>
                            <th>Usuario Modificador</th>
                            <th>Fecha Modificación</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% 
                            ArrayList<Usuarios> usuarios = select.BuscarUsuarios();
                            for(Usuarios m : usuarios){
                        %>
                        <tr>
                            <td><%= m.getIdUsuario() %> </td>
                            <td><%= m.getIdRol() %> </td>
                            <td><%= m.getNombre() %> </td>
                            <td><%= m.getUsuario() %> </td>
                            <td><%= m.getCorreoElectronico() %> </td>
                            <td><%= m.getContraseña() %> </td>
                            <td><%= m.getEstado() %> </td>
                            <td><%= m.getTelefono() %> </td>
                            <td><%= m.getRolUsuario() %> </td>
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

