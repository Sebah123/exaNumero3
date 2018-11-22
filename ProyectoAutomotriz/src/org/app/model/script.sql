CREATE DATABASE prueba3_poo;

USE prueba3_poo;

CREATE TABLE automovil(
    patente VARCHAR(7),
    marca VARCHAR(100),
    estado BOOLEAN, -- true(nuevo) false(usado)
    precio LONG,
    red INT,
    green INT,
    blue INT,
    PRIMARY KEY(patente)
);

INSERT INTO automovil VALUES('AABB-11','Toyota',true,12500000,255,0,0);
INSERT INTO automovil VALUES('CCDD-22','Chevrolet',true,8900000,0,255,0);
INSERT INTO automovil VALUES('EEFF-33','Peugeot',false,650000,0,0,255);

SELECT * FROM automovil ORDER BY precio DESC;

-- Eliminar la base de datos
-- DROP DATABASE prueba3_poo;
-- Eliminar la base de datos
