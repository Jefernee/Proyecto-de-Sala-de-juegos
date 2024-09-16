Create DATABASE SJRuizDB;
USE SJRuizDB;
CREATE TABLE roles (
    idRol INT PRIMARY KEY auto_increment,
    nombre VARCHAR(25),
    usuarioCreacion VARCHAR(25),
    fechaCreacion DATETIME,
    usuarioModificador VARCHAR(25) null,
    fechaModificacion DATETIME null
);

CREATE TABLE usuarios (
    idUsuario INT auto_increment,
    idRol INT,
    nombre VARCHAR(25),
    usuario VARCHAR(25),
    correoElectronico VARCHAR(25),
    contraseña VARCHAR(25),
    estado VARCHAR (10),
    telefono VARCHAR(15),
    rolUsuario VARCHAR(25),
	usuarioCreacion VARCHAR(25),
    fechaCreacion DATETIME,
    usuarioModificador VARCHAR(25) null,
    fechaModificacion DATETIME null,
    PRIMARY KEY(idUsuario, idRol),
    FOREIGN KEY (idRol) REFERENCES roles(idRol)
);

-- Crear tabla Clientes
CREATE TABLE clientes (
    idCliente INT PRIMARY KEY auto_increment,
    nombre VARCHAR(15),
    fecha DATE,
    descripcion VARCHAR(15) null,
    tiempoPagado VARCHAR(15),
    horaInicial TIME,
    horaFinal TIME,
    tiempoPendiente VARCHAR(10) null,
    numeroplay Char(1) null,
    juegosJugados VARCHAR(25) null,
    controlAdicional int(15) null,
    mesaPingPong int null,
    play4 int null,
    play5 int null,
    totalJugado int(30),
    telefono VARCHAR(15) null,
	usuarioCreacion VARCHAR(25),
    fechaCreacion DATETIME,
    usuarioModificador VARCHAR(25) null,
    fechaModificacion DATETIME null
);

CREATE TABLE costosHorasdejuego (
    idCosto INT PRIMARY KEY AUTO_INCREMENT,
    tipoJuego VARCHAR(25) UNIQUE,
    costoHora INT(30),
    usuarioCreacion VARCHAR(25),
    fechaCreacion DATETIME,
    usuarioModificador VARCHAR(25) null,
    fechaModificacion DATETIME null
);


-- Crear tabla InventarioSala
CREATE TABLE inventarioSala (
    idProducto VARCHAR (35),
    nombreProducto VARCHAR(25),
    descripcionProducto VARCHAR(30),
    fechaCompra DATE,
    garantia VARCHAR(10) null,
    cantidad INT NULL,
    precioComprado INT,
    lugarComprado VARCHAR(25),
    telefonoLugar VARCHAR(15) NULL,
    estadoProducto VARCHAR(15),
    descripcionProblema VARCHAR(30) null,
    descripcionReparación VARCHAR(30) null,
	usuarioCreacion VARCHAR(25),
    fechaCreacion DATETIME,
    usuarioModificador VARCHAR(25) null,
    fechaModificacion DATETIME null,
    PRIMARY KEY (idProducto)
);
-- Crear tabla ganacias y pagos
CREATE TABLE finanzas (
    idfinanza INT PRIMARY KEY auto_increment,
    nombreFinanza VARCHAR(25),
    descripcion VARCHAR(25) NULL,
    montoMaquinas INT,
    montoFutbolin INT,
    montoLuz INT, 
	montoAgua INT,
	montoInternet INT,
	montoPlan INT,
    montoFinalFinanza int null,
    fecha DATETIME,
	usuarioCreacion VARCHAR(25),
    fechaCreacion DATETIME,
    usuarioModificador VARCHAR(25) null,
    fechaModificacion DATETIME null
);

-- Crear tabla Informes
CREATE TABLE informes (
    idInforme INT PRIMARY KEY auto_increment,
    nombreInforme VARCHAR(25),
    descripcionInforme VARCHAR(30),
    fechaInforme DATE null,
    fechaInicialInforme DATE null,
    fechaFinalInforme DATE null,
    montoInformepersonalizado INT null,
    montomesInforme INT null,
    montoañoInforme INT null,
    totalPagos INT null,
    totalGanancias INT null,
	usuarioCreacion VARCHAR(25),
    fechaCreacion DATETIME,
    usuarioModificador VARCHAR(25) null,
    fechaModificacion DATETIME null
);