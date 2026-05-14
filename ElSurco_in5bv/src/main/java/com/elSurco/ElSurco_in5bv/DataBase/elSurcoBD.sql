drop database if exists ElSurcoDB_in5bv;
create database ElSurcoDB_in5bv;
use ElSurcoDB_in5bv;

-- 1. USUARIOS
create table Users(
    idUser int auto_increment primary key,
    userEmail varchar(100) unique not null,
    userPassword varchar(255) not null,
    userAddress varchar(200) not null,
    userPhone bigint not null,
    userStatus enum('ACTIVE', 'INACTIVE') default 'ACTIVE' -- NUEVO: Para suspender cuentas sin borrarlas
);

-- 2. AGRICULTORES
create table Farmers(
    idFarmer int auto_increment primary key,
    farmerFirstName varchar(50) not null,
    farmerLastName varchar(50) not null,
    farmerDpi varchar(13) unique not null,
    farmerPhone bigint not null,
    farmerAddress varchar(100) not null,
    farmerGps varchar(100),
    farmerHistory text,
    registrationDate date default (CURRENT_DATE), -- NUEVO: Para saber cuánto tiempo lleva en la plataforma
    idUser int not null,
    foreign key (idUser) references Users(idUser) on delete cascade
);

-- 4. PRODUCTOS
create table Products(
    idProduct int auto_increment primary key,
    productName varchar(100) not null,
    productDescription varchar(200),
    productPrice decimal(10,2) not null,
    productStock int not null,
    harvestDate date not null,
    productCategory enum('FRUITS', 'VEGETABLES', 'GRAINS', 'TUBERS', 'DAIRY', 'OTHERS') not null,
    productStatus enum('AVAILABLE', 'OUT_OF_STOCK', 'HIDDEN') default 'AVAILABLE', -- NUEVO: Para deshabilitar el botón de compra
    idFarmer int not null,
    foreign key (idFarmer) references Farmers(idFarmer)
);

-- 5. PEDIDOS
create table BuyOrders(
    idBuyOrder int auto_increment primary key,
    orderDate datetime not null default current_timestamp, -- NUEVO: Se llena solo al hacer el insert
    orderTotal decimal(10,2) not null,
    orderQuantity int not null,
    orderStatus enum('PENDING', 'ON_THE_WAY', 'DELIVERED', 'CANCELLED') not null,
    paymentMethod enum('CASH', 'CARD') not null, -- NUEVO: Para mostrar el icono de pago en el Frontend
    idUser int not null,
    foreign key (idUser) references Users(idUser),
    idProduct int not null,
    foreign key (idProduct) references Products(idProduct)
);

-- 6. FACTURAS
create table Invoices(
    idInvoice int auto_increment primary key,
    invoiceNit varchar(15) default 'CF',
    invoiceIssueDate datetime not null default current_timestamp,
    invoiceTotal decimal(10,2) not null,
    idBuyOrder int unique not null,
    foreign key (idBuyOrder) references BuyOrders(idBuyOrder)
);

-- 7. VALORACIONES
create table Ratings(
    idRating int auto_increment primary key,
    ratingScore int not null check (ratingScore between 1 and 5), -- NUEVO: Límite de 1 a 5 estrellas para renderizar en el UI
    ratingComment text,
    ratingDate date not null default (CURRENT_DATE),
    idProduct int not null,
    idUser int not null,
    foreign key (idProduct) references Products(idProduct),
    foreign key (idUser) references Users(idUser) on delete cascade
);