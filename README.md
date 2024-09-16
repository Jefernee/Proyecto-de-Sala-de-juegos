# Proyecto-de-Sala-de-juegos
Descripción
Este proyecto es un sistema de gestión completo para una sala de juegos, desarrollado como una aplicación full-stack en Java con una base de datos MySQL. La aplicación fue desarrollada en Apache NetBeans y está diseñada para facilitar la administración de juegos, usuarios, inventario, horas jugadas, finanzas y precios, con un enfoque en la eficiencia y la facilidad de uso.

Características
Inicio de Sesión: Permite a los usuarios ingresar con credenciales y guarda el nombre del usuario para modificar o agregar datos.
Módulo de Inventario: Gestión completa del inventario de juegos, incluyendo la adición, modificación y eliminación de juegos.
Registro de Horas Jugadas: Registro detallado de las horas jugadas por cada usuario, con informes y estadísticas.
Informes:
Creación de Informes: La funcionalidad para crear informes está operativa.
Otros Informes: Los demás tipos de informes están en desarrollo y no son funcionales en esta versión.
Finanzas: Gestión de ingresos y gastos, incluyendo la creación de reportes financieros.
Creación de Usuarios: Administración de usuarios con roles y permisos.
Gestor de Precios: Configuración de precios basados en las horas jugadas, con un módulo CRUD para ajustar precios.
Olvidar Contraseña: La funcionalidad para recuperar contraseñas olvidadas aún no está implementada.
Requisitos
Software:
Java 8 o superior
MySQL
Apache NetBeans
Hardware:
Computadora con capacidad suficiente para ejecutar la base de datos y la aplicación.
Instalación
Clonar el Repositorio:

bash
Copiar código
git clone https://github.com/usuario/nombre-repositorio.git
cd nombre-repositorio
Configurar MySQL:

Crea una base de datos en MySQL y configura el archivo de conexión con tus credenciales. Asegúrate de crear las tablas necesarias según el esquema proporcionado en el proyecto.
Usa el siguiente script para insertar usuarios de prueba:
sql
Copiar código
INSERT INTO usuarios (id, empresa_id, nombre_completo, username, email, contraseña, estado, telefono, rol, tipo_usuario, fecha_creacion, administrador)
VALUES
(2, 1, 'Anfernee', 'anfernee_Ruiz', 'anfernee32@gmail.com', 'Wq2345*#', 'Activo', '6751-9034', 'Empleado', 'Empleado', '2024-04-15T10:00', NULL),
(3, 1, 'jefernee Ruiz', 'Ruiz', 'jefernee50@gmail.com', 'Rt2301*#', 'Activo', '8682-5481', 'Administrador', 'Administrador', '2024-04-15T10:00', NULL);
Abrir el Proyecto en Apache NetBeans:

Abre Apache NetBeans.
Selecciona File > Open Project y navega a la carpeta del proyecto clonada.
Abre el proyecto y configura las dependencias necesarias.
Configurar la Conexión a la Base de Datos:

Asegúrate de que el archivo de configuración del proyecto tenga las credenciales correctas para conectar a la base de datos MySQL.
Compilar y Ejecutar la Aplicación:

En Apache NetBeans, selecciona el proyecto y haz clic en Run para compilar y ejecutar la aplicación.
Uso
Inicio de Sesión:

Accede al sistema con tus credenciales de usuario.
Usuario de prueba:
Username: anfernee_Ruiz
Password: Wq2345*#
Usuario Administrador:
Username: Ruiz
Password: Rt2301*#
Gestión de Inventario:

Navega al módulo de inventario para agregar, modificar o eliminar juegos.
Registro de Horas Jugadas:

Registra las horas jugadas por cada usuario y genera informes a partir de estos datos.
Creación de Usuarios y Gestión de Precios:

Administra los usuarios y ajusta los precios de acuerdo a las horas jugadas en el gestor de precios.
Informes:

La funcionalidad de Creación de Informes está completamente operativa.
Otros Informes: Los demás tipos de informes están en desarrollo y no son funcionales en esta versión.
Olvidar Contraseña:

La funcionalidad para recuperar contraseñas olvidadas aún no está implementada.
