
--CREAR TABLAS QUE ESTAN EN VERDE EN LA NORMALIZACIÓN
-- Y ELIMINAR LOS DATOS ROJOS
CREATE DATABASE GypsiGram
USE GypsiGram

CREATE TABLE empresa(
CIF NVARCHAR (50),
direccion NVARCHAR (100) NOT NULL,
localidad NVARCHAR (100) NOT NULL,
nombre NVARCHAR(100) NOT NULL,
nombre_responsable NVARCHAR(30) NOT NULL,
apellido1_responsable NVARCHAR (50) NOT NULL,
apellido2_responsable NVARCHAR (50) NOT NULL,
provincia NVARCHAR (100) NOT NULL,
direccion_sede_practicas NVARCHAR(100) NOT NULL,
telefono NVARCHAR(100) NOT NULL,
email NVARCHAR(100) NOT NULL,
contraseña NVARCHAR(100) NOT NULL,
CONSTRAINT pk_CIF_empresa PRIMARY KEY(CIF));

CREATE TABLE estudiante (
DNI NVARCHAR(20),
nombre NVARCHAR(50) NOT NULL,
apellido1 NVARCHAR(50) NOT NULL,
apellido2 NVARCHAR(50) NOT NULL,
carta_presentacion NVARCHAR(500) NOT NULL,
certificaciones NVARCHAR(1000),
experiencias NVARCHAR(1000),
prov_instituto NVARCHAR(50) NOT NULL,
descripcion NVARCHAR(1000),
URL_linkedin NVARCHAR(1000),
URL_github NVARCHAR(1000),
email NVARCHAR(100)NOT NULL,
img_perfil NVARCHAR(1000),
curriculum NVARCHAR(1000) NOT NULL,
proyecto_personales NVARCHAR(1000),
video_cv NVARCHAR(1000) NOT NULL,
CONSTRAINT pk_DNI_estudiante PRIMARY KEY (DNI));

CREATE TABLE certificacion (
codigo_certificacion INT IDENTITY(1,1),
nombre NVARCHAR(300) NOT NULL,
CONSTRAINT pk_codigo_certificacion PRIMARY KEY (codigo_certificacion));

CREATE TABLE experiencia(
codigo_experiencia INT IDENTITY(1,1),
nombre NVARCHAR(300),
descripcion NVARCHAR(1000)
CONSTRAINT pk_codigo_experiencia PRIMARY KEY (codigo_experiencia));

CREATE TABLE proyecto_personal (
codigo_proyecto INT IDENTITY(1,1),
nombre NVARCHAR(300),
URL_proyecto NVARCHAR(1000)
CONSTRAINT pk_codigo_proyecto PRIMARY KEY (codigo_proyecto));

CREATE TABLE ciclo(
ID INT IDENTITY(1,1),
nombre NVARCHAR(50),
CONSTRAINT pk_ID_ciclo PRIMARY KEY(nombre),
CONSTRAINT ch_nombre_ciclo CHECK (nombre IN ('DAM','DAW','ASIR','ASMR','IA y Big Data', 'Ciberseguridad', 'Desarrollo de Videojuegos')));

CREATE TABLE instituto (
codigo_ies INT IDENTITY(1,1),
descripcion TEXT NOT NULL,
url_pagina TEXT NOT NULL,
telefono NVARCHAR(50) NOT NULL,
contrasenia NVARCHAR(100) NOT NULL,
correo NVARCHAR(100) NOT NULL,
localizacion NVARCHAR (200) NOT NULL,
CONSTRAINT pk_codigo_ies_insituto PRIMARY KEY(codigo_ies));

CREATE TABLE idioma(
nombre NVARCHAR(30),
CONSTRAINT pk_nombre_idioma PRIMARY KEY(nombre));

CREATE TABLE Idioma_estudiante (
DNI NVARCHAR(20),
nombre NVARCHAR(30),
nivel NVARCHAR(30) NOT NULL,
CONSTRAINT pk_DNI_nombre_Idioma_estudiante PRIMARY KEY(DNI, nombre),
CONSTRAINT fk_DNI_idioma_estudiante FOREIGN KEY (DNI) REFERENCES estudiante(DNI),
CONSTRAINT fk_nombre_idioma_estudiante FOREIGN KEY (nombre) REFERENCES idioma(nombre),
CONSTRAINT ch_idioma_estudiante_nivel CHECK (nivel IN ('Nativo','A1','A2','B1','B2','C1','C2'))
);

CREATE TABLE estudiante_ciclo_instituto (
DNI NVARCHAR(20),
nombre NVARCHAR(50),
codigo_ies INT,
curso NVARCHAR(20) NOT NULL,
curso_escolar NVARCHAR(20) NOT NULL,
CONSTRAINT pk_estudiante_ciclo_instituto PRIMARY KEY(DNI, nombre, codigo_ies),
CONSTRAINT fk_DNI_estudiante_ciclo_insituto FOREIGN KEY(DNI) REFERENCES estudiante(DNI),
CONSTRAINT fk_ID_estudiante_ciclo_insituto FOREIGN KEY (nombre) REFERENCES ciclo(nombre),
CONSTRAINT fk_codigo_ies_estudiante_ciclo_instituo FOREIGN KEY (codigo_ies) REFERENCES instituto(codigo_ies),
CONSTRAINT ch_curso_estudiante_ciclo_instituto CHECK (curso IN ('1º','2º'))
);

CREATE TABLE proyecto_personal_estudiante (
DNI NVARCHAR(20),
codigo_proyecto INT
CONSTRAINT pk_dni_codigo_proyecto_estudiante PRIMARY KEY (DNI, codigo_proyecto),
CONSTRAINT fk_DNI_proyecto_estudiante FOREIGN KEY (DNI) REFERENCES estudiante(DNI),
CONSTRAINT fk_codigo_proyecto_estudiante FOREIGN KEY (codigo_proyecto) REFERENCES proyecto_personal(codigo_proyecto));

CREATE TABLE experiencia_estudiante(
	DNI NVARCHAR(20),
	codigo_experiencia INT,
	CONSTRAINT pk_experiencia_estudiante PRIMARY KEY (DNI,codigo_experiencia),
	CONSTRAINT fk_experiencia_estudiante_dni FOREIGN KEY (DNI) REFERENCES estudiante(DNI),
	CONSTRAINT fk_experiencia_estudiante_codigo_experiencia FOREIGN KEY (codigo_experiencia) REFERENCES experiencia(codigo_experiencia)
);

CREATE TABLE certificacion_estudiante (
	DNI NVARCHAR(20),
	codigo_certificacion INT,
	CONSTRAINT pk_certificacion_estudiante PRIMARY KEY (DNI, codigo_certificacion),
	CONSTRAINT fk_certificacion_estudiante_dni FOREIGN KEY (DNI) REFERENCES estudiante(DNI),
	CONSTRAINT fk_certificacion_estudiante_codigo_certificacion FOREIGN KEY (codigo_certificacion) REFERENCES certificacion(codigo_certificacion)
);



