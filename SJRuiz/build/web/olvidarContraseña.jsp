<%-- 
    Document   : olvidarContraseña
    Created on : 8 abr 2024, 22:17:18
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
            input[type="text"],
            input[type="email"],
            input[type="password"] {
                color: black;
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
                max-height: 250px; /* Altura máxima del contenedor */
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




        <div class="container text-center">
            <div class="row align-items-start">
                <div class="col">
                    <h3>Contraseña Olvidada</h3>
                </div>
            </div>
            <form class="container text-center" id="registroForm">
                <div class="row align-items-start">
                    <div class="col">
                        <div class="mb-2">
                            <label for="validationServer04" class="form-label">Nombre y Apellidos</label>
                            <input type="text" class="form-control is valid" id="nombreApellido" PlaceHolder="Anfernee Ruiz Garcia" required>
                        </div>
                    </div>
                    <div class="col">
                        <label for="validationServer04" class="form-label">Usuario</label>
                        <div class="input-group has-validation">
                            <span class="input-group-text" id="inputGroupPrepend3">@</span>
                            <input type="text" class="form-control" id="usuario" placeholder="Jefernee"aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" required>
                        </div>
                    </div>


                    <script>
                        document.querySelectorAll('.dropdown-menu a.dropdown-item').forEach(function (element) {
                            element.addEventListener('click', function () {
                                document.querySelector('.dropdown-menu').querySelectorAll('.dropdown-item').forEach(function (innerElement) {
                                    innerElement.classList.remove('active');
                                });
                                element.classList.add('active');
                            });
                        });

                        document.getElementById("registroForm").addEventListener("submit", function (event) {
                            var algunaSeleccionada = false;

                            document.querySelectorAll(".dropdown-menu .dropdown-item").forEach(function (opcion) {
                                if (opcion.classList.contains("active")) {
                                    algunaSeleccionada = true;
                                }
                            });

                            if (!algunaSeleccionada) {
                                event.preventDefault(); // Evitar que el formulario se envíe
                                alert("Por favor, elija una opción de Usuario.");
                            }
                        });
                    </script>
                </div>

                <div class="row align-items-start">
                    <div class="col">
                        <label for="inputPassword5" class="form-label">Contraseña</label>
                        <input type="password" id="inputPassword5" class="form-control" title="Tu contraseña debe de tener de 8 a 20 caracteres,letra mayuscula, contener letras, numeros, sin espacios y debe de tener caracteres especiales." aria-describedby="passwordHelpBlock" placeholder="Contraseña" required>
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
                        <label for="validationServer05" class="form-label">Teléfono</label>
                        <input type="number" class="form-control" id="telefono1" placeHolder="67543201" title="Digite solo numeros" aria-describedby="validationServer05Feedback" >
                    </div>


                </div>
                <div class="row align-items-start">
                    <div class="col-6">
                        <label for="validationServer05" class="form-label"></label>
                        <div class="input-group">
                            <input type="email" id="nombre" name="nombre" class="form-control" placeholder="Digite el Email a buscar" title="Digitar el ultimo Email que uso" aria-label="Nombre" required>
                            <button class="btn btn-primary" type="button">Buscar Usuario</button>
                        </div>
                    </div>
                    <div class="col-2">
                        <label for="validationServer05" class="form-label"></label>
                        <div class="mb-2">
                            <button type="submit" class="btn btn-primary">Modificar Usuario</button>
                        </div>
                    </div>

                </div>
            </form>
        </div>

    </body>
</html>

