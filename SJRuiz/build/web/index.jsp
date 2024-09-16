<%-- 
    Document   : index
    Created on : 8 abr 2024, 22:13:38
    Author     : jefer
--%>
<%@page import="SQL.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
   
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <!--apartado de fondo de pantalla 
         background-color: #1A1A1A !important;
                color: white !important;-->
        <style>

            body {
                background-image: url('https://besthqwallpapers.com/Uploads/22-4-2019/88276/thumb2-black-wooden-boards-close-up-black-wooden-texture-wooden-backgrounds-macro.jpg');
                background-size: cover;
                background-position: center;
                background-repeat: no-repeat;
                min-height: 100vh;
                color: white;

            }
            input[type="text"],
            input[type="password"] {
                color: black;
            }
            .custom-img {
               max-width: 150px; /* Cambia el tamaño según tus necesidades */
               height: auto; /* Para mantener la proporción */
            }


        </style>
    </head>

    <body>
        <%
             String error = request.getParameter("error");
             if (error != null && error.equals("invalidCredentials")) {
        %>
        <div class="error-message">
               <p>Credenciales inválidas. Por favor, inténtelo de nuevo.</p>
        </div>
        <% } %>
        <!--apartado de imagenes y texto central-->
        <div class="container text-center">
            <div class="row">
                <div class="col mt-3">
                    <img src="https://uisil.ac.cr/files/branding/navbar-logo.png?1128729703" class="img-fluid" alt="...">  
                </div>
                <div class="col-6 mt-5">
                    <p class="h2"><b>SISTEMA SALA DE JUEGOS RUIZ</b></p>
                </div>
                <div class="col mt-3">
                    <img src="https://raw.githubusercontent.com/Ferny16/Ferny16/master/Blue%20Modern%20Simple%20Design%20Hotel%20and%20Resort%20Logo%20-%20Logos.png" class="img-fluid custom-img" alt="...">
                </div>
            </div>
        </div>
        <!--action="./paginaPrincipal.jsp"-->
        <div class="container">
            <form class="row justify-content-center" id="registroForm" action="InicioSesion" method="post">
                <div class="col-6"> 
                    <!--entrada de usuario mb-3-->
                    <div class="mb-3">
                        <label for="inputEmail1" class="form-label">Usuario</label>
                        <input type="text" class="form-control" name="inputEmail1" id="inputEmail1" aria-describedby="emailHelp" autocomplete="new-password" required>
                        <label for="exampleInputPassword1" class="form-label">No debe compartir esta informacion con nadie</label>
                    </div>
                    <div class="mb-3">
                        <label for="inputPassword5" class="form-label">Contraseña</label>
                        <input type="password" name="inputPassword5"id="inputPassword5" class="form-control" title="Tu contraseña debe de tener de 8 a 20 caracteres,letra mayuscula, contener letras, numeros, sin espacios y debe de tener caracteres especiales." aria-describedby="passwordHelpBlock" required>
                        <div id="passwordHelpBlock" class="form-text" style="color: white;">
                            Tu contraseña debe de tener de 8 a 20 caracteres, letra mayuscula, contener letras, numeros, sin espacios y debe de tener caracteres especiales.   
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
                    <div class="mb-3">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" name="autoSizingCheck" id="autoSizingCheck" onchange="saveCredentials()">
                            <label class="form-check-label" for="autoSizingCheck">
                                Recordar
                            </label>
                        </div>
                    </div>
                    <script>
                        function saveCredentials() {
                            // Obtiene el valor del campo de entrada de usuario
                            const usernameInput = document.getElementById('inputEmail1').value;
                            // Obtiene el valor del campo de contraseña
                            const passwordInput = document.getElementById('inputPassword5').value;

                            // Obtiene las credenciales guardadas del almacenamiento local o crea un arreglo vacío si no hay ninguna
                            let savedCredentials = JSON.parse(localStorage.getItem('savedCredentials')) || [];

                            // Filtra las credenciales existentes para eliminar cualquier duplicado del mismo usuario
                            savedCredentials = savedCredentials.filter(credential => credential.username !== usernameInput);

                            // Agrega las nuevas credenciales al arreglo de credenciales guardadas
                            savedCredentials.push({username: usernameInput, password: passwordInput});

                            // Guarda las credenciales actualizadas en el almacenamiento local
                            localStorage.setItem('savedCredentials', JSON.stringify(savedCredentials));
                        }

                        function loadAndAutocompleteCredentials() {
                            // Obtiene las credenciales guardadas del almacenamiento local o crea un arreglo vacío si no hay ninguna
                            const savedCredentials = JSON.parse(localStorage.getItem('savedCredentials')) || [];

                            // Obtiene el campo de entrada de usuario
                            const usernameInput = document.getElementById('inputEmail1');
                            // Crea un elemento datalist para mostrar las sugerencias de usuario
                            const dataListElement = document.createElement('datalist');

                            // Define un ID para el datalist
                            const dataListId = 'usernamesDatalist';
                            dataListElement.id = dataListId;

                            // Limpia cualquier opción existente en el datalist
                            dataListElement.innerHTML = '';

                            // Agrega cada usuario guardado como una opción en el datalist
                            savedCredentials.forEach(function (credential) {
                                const optionElement = document.createElement('option');
                                optionElement.value = credential.username;
                                dataListElement.appendChild(optionElement);
                            });

                            // Inserta el datalist después del campo de entrada de usuario y lo asocia con este campo
                            usernameInput.insertAdjacentElement('afterend', dataListElement);
                            usernameInput.setAttribute('list', dataListId);

                            // Oculta el datalist inicialmente
                            dataListElement.style.display = 'none';

                            // Muestra el datalist cuando se escribe en el campo de entrada de usuario
                            usernameInput.addEventListener('input', function () {

                            });

                            // Oculta el datalist cuando se hace clic fuera del campo de entrada de usuario
                            document.addEventListener('click', function (event) {
                                if (event.target !== usernameInput) {
                                    dataListElement.style.display = 'none';
                                }
                            });

                            // Autocompleta la contraseña cuando se selecciona un usuario del datalist
                            usernameInput.addEventListener('input', function () {
                                const selectedUsername = usernameInput.value;
                                const selectedCredential = savedCredentials.find(function (credential) {
                                    return credential.username === selectedUsername;
                                });

                                if (selectedCredential) {
                                    document.getElementById('inputPassword5').value = selectedCredential.password;
                                }
                            });
                        }

                        // Ejecuta la función loadAndAutocompleteCredentials() cuando se carga la página
                        window.onload = loadAndAutocompleteCredentials;

                    </script>
                    <div class="mb-3">
                        <a href="./olvidarContraseña.jsp" name="olvidarcontraseña" id="olvidarcontraseña" class="btn btn-link float-end">Olvidé mi contraseña</a>
                    </div>

                    <button type="submit" class="btn btn-primary" name="accion" value="iniciar" >Ingresar</button> 
                </div>
            </form>
        </div>
        <nav class="navbar bg-transparent-tertiary">
            <div class="container-fluid">
                    <a class="navbar-brand text-white" href="./acerca de.jsp" name="olvidarcontraseña" id="olvidarcontraseña">
                        <img src="https://cdn-icons-png.flaticon.com/128/553/553983.png" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
                        Acerca de
                    </a>
           </div>
        </nav>
    </body>
</html>

