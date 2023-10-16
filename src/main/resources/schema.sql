create table UsuarioAplicacion(
    id IDENTITY PRIMARY KEY NOT NULL,
    nombreusuario VARCHAR(100) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    codigoPais CHAR(2) NOT NULL,
    fechaNacimiento DATE,
    creado DATE,
    admin BOOLEAN
);







