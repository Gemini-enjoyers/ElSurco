drop database if exists ElSurcoDB_in5bv;
create database ElSurcoDB_in5bv;
use ElSurcoDB_in5bv;

-- 1. USUARIOS
create table Users(
    idUser int auto_increment primary key,
    userFirtName varchar(105) not null,
    userLastName varchar(105) not null,
    handle varchar(50) unique not null,
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

-- =========================================================================
-- 1. INSERCIONES EN USUARIOS (Users)
-- =========================================================================
-- Nota: idUser generado: 1 y 2
insert into Users(userFirtName, userLastName, handle, userEmail, userPassword, userAddress, userPhone, userStatus)
values
    ('Carlos', 'Mendoza', 'carlos_tienda', 'carlos.mendoza@email.com', '$2a$12$E2IdVb56...', 'Zona 10, Ciudad de Guatemala', 50255443322, 'ACTIVE'),
    ('María', 'Chajón', 'comercial_chajon', 'maria.chajon@email.com', '$2a$12$R9xYm234...', 'San Lucas Sacatepéquez, Sacatepéquez', 50244332211, 'ACTIVE');


-- =========================================================================
-- 2. INSERCIONES EN AGRICULTORES (Farmers)
-- Requieren un idUser existente para vincular su cuenta de acceso
-- =========================================================================
-- Nota: idFarmer generado: 1 y 2
insert into Farmers(farmerFirstName, farmerLastName, farmerDpi, farmerPhone, farmerAddress, farmerGps, farmerHistory, registrationDate, idUser)
values
    ('Pedro', 'Alvarado', '2345678900101', 50233221100, 'Aldea Choacorral, San Juan Sacatepéquez', '14.7189,-90.6432', 'Agricultor de tercera generación dedicado al cultivo de hortalizas libres de pesticidas químicos.', '2026-01-15', 1),
    ('Juana', 'Xoc', '3456789010301', 50277665544, 'Caserío Los Llanos, Tecpán, Chimaltenango', '14.7612,-90.9941', 'Líder comunitaria que organiza a mujeres productoras para la distribución justa de granos y tubérculos.', '2026-02-20', 2);


-- =========================================================================
-- 4. INSERCIONES EN PRODUCTOS (Products)
-- Requieren un idFarmer existente. Categorías limitadas por el ENUM original.
-- =========================================================================
-- Nota: idProduct generado: 1 y 2
insert into Products(productName, productDescription, productPrice, productStock, harvestDate, productCategory, productStatus, idFarmer)
values
    ('Arverja China de Primera', 'Arverja fresca clasificada a mano, ideal para exportación o comercio local. Bolsa de 5 libras.', 45.00, 120, '2026-05-14', 'VEGETABLES', 'AVAILABLE', 1),
    ('Papa Loman Amarilla', 'Papa grande, arenosa y recién cosechada. Quintal completo directo de Tecpán.', 180.00, 45, '2026-05-13', 'TUBERS', 'AVAILABLE', 2);


-- =========================================================================
-- 5. INSERCIONES EN PEDIDOS (BuyOrders)
-- Vinculan a un comprador (idUser) con un producto (idProduct)
-- =========================================================================
-- Nota: idBuyOrder generado: 1 y 2
insert into BuyOrders(orderTotal, orderQuantity, orderStatus, paymentMethod, idUser, idProduct)
values
    (90.00, 2, 'DELIVERED', 'CASH', 2, 1),  -- María compró 2 unidades de Arverja (45.00 * 2 = 90.00)
    (180.00, 1, 'PENDING', 'CARD', 1, 2);  -- Carlos compró 1 Quintal de Papa (180.00 * 1 = 180.00)


-- =========================================================================
-- 6. INSERCIONES EN FACTURAS (Invoices)
-- Requieren un idBuyOrder único que no haya sido facturado previamente
-- =========================================================================
insert into Invoices(invoiceNit, invoiceTotal, idBuyOrder)
values
    ('8493021-K', 90.00, 1),
    ('CF', 180.00, 2);


-- =========================================================================
-- 7. INSERCIONES EN VALORACIONES (Ratings)
-- El sistema evalúa productos específicos por parte de usuarios compradores
-- =========================================================================
insert into Ratings(ratingScore, ratingComment, ratingDate, idProduct, idUser)
values
    (5, 'La arverja vino sumamente fresca, crujiente y limpia. Mis clientes de la tienda quedaron encantados.', '2026-05-15', 1, 2),
    (4, 'Excelente tamaño de la papa, muy bien empacado el quintal. Tardó un poco el envío pero valió la pena.', '2026-05-15', 2, 1);