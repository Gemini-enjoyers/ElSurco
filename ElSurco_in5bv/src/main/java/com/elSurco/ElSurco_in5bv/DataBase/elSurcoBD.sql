drop database if exists ElSurcoDB_in5bv;
create database ElSurcoDB_in5bv;
use ElSurcoDB_in5bv;

create table Login(
    idLogin int auto_increment primary key,
    correo varchar(100) unique not null,
    password varchar(255) not null,
    rol varchar(20) not null 
);

create table Agricultor(
    idAgricultor int auto_increment primary key,
    nombres varchar(50) not null,
    apellidos varchar(50) not null,
    dpi varchar(13) unique not null,
    telefono varchar(8) not null, 
    comunidadAldea varchar(100) not null, 
    coordenadasGps varchar(100), 
    historiaPerfil text, 
    idLogin int not null,
    foreign key (idLogin) references Login(idLogin) on delete cascade
);

create table Comprador(
    idComprador int auto_increment primary key,
    nombres varchar(50) not null,
    apellidos varchar(50) not null,
    telefono varchar(8) not null,
    direccionEntrega varchar(200) not null,
    idLogin int not null,
    foreign key (idLogin) references Login(idLogin) on delete cascade
);

create table Verduras(
    idVerdura int auto_increment primary key,
    nombre varchar(50) not null, 
    descripcion varchar(150)
);

create table Frutas(
    idFruta int auto_increment primary key,
    nombre varchar(50) not null, 
    descripcion varchar(150)
);

create table Productos(
    idProducto int auto_increment primary key,
    idAgricultor int not null,
    idVerdura int null, 
    idFruta int null, 
    precioPorLibra decimal(10,2) not null, 
    cantidadLibras int not null,
    fechaCosecha date not null, 
    foreign key (idAgricultor) references Agricultor(idAgricultor),
    foreign key (idVerdura) references Verduras(idVerdura),
    foreign key (idFruta) references Frutas(idFruta)
);