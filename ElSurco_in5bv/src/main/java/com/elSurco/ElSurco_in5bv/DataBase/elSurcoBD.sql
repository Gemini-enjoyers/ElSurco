drop database if exists ElSurcoDB_in5bv;
create database ElSurcoDB_in5bv;
use ElSurcoDB_in5bv;

-- 1. USUARIO
create table Usuario(
                        idUsuario int auto_increment primary key,
                        correoUsuario varchar(100) unique not null,
                        passwordUsuario varchar(255) not null,
                        confirmacionPasswordUsuario varchar(255) not null,
                        direccionUsuario varchar(200) not null,
                        telefonoUsuario bigint not null,
                        estadoUsuario enum('ACTIVO', 'INACTIVO') default 'ACTIVO' -- NUEVO: Para suspender cuentas sin borrarlas
);

-- 2. AGRICULTOR
create table Agricultor(
                           idAgricultor int auto_increment primary key,
                           nombreAgricultor varchar(50) not null,
                           apellidoAgricultor varchar(50) not null,
                           dpiAgricultor varchar(13) unique not null,
                           telefonoAgricultor bigint not null,
                           direccionAgricultor varchar(100) not null,
                           gpsAgricultor varchar(100),
                           historiaAgricultor text,
                           fechaRegistro date default (CURRENT_DATE), -- NUEVO: Para saber cuánto tiempo lleva en la plataforma
                           idUsuario int not null,
                           foreign key (idUsuario) references Usuario(idUsuario) on delete cascade
);

-- 4. PRODUCTO
create table Producto(
                         idProducto int auto_increment primary key,
                         nombreProducto varchar(100) not null,
                         descripcionProducto varchar(200),
                         precioProducto decimal(10,2) not null,
                         stockProducto int not null,
                         fechaCosechaProducto date not null,
                         categoriaProducto enum('FRUTAS', 'VERDURAS', 'GRANOS', 'TUBERCULOS', 'LACTEOS', 'OTROS') not null,
                         estadoProducto enum('DISPONIBLE', 'AGOTADO', 'OCULTO') default 'DISPONIBLE', -- NUEVO: Para deshabilitar el botón de compra
                         idAgricultor int not null,
                         foreign key (idAgricultor) references Agricultor(idAgricultor)
);

-- 5. PEDIDO
create table Pedido(
                       idPedido int auto_increment primary key,
                       fechaPedido datetime not null default current_timestamp, -- NUEVO: Se llena solo al hacer el insert
                       totalPedido decimal(10,2) not null,
                       cantidadPedido int not null,
                       estadoPedido enum('PENDIENTE', 'EN_CAMINO', 'ENTREGADO', 'CANCELADO') not null,
                       metodoPago enum('EFECTIVO', 'TARJETA') not null, -- NUEVO: Para mostrar el icono de pago en el Frontend
                       idUsuario int not null,
                       foreign key (idUsuario) references Usuario(idUsuario),
                       idProducto int not null,
                       foreign key (idProducto) references Producto(idProducto)
);

-- 6. FACTURA
create table Factura(
                        idFactura int auto_increment primary key,
                        nitFactura varchar(15) default 'CF',
                        fechaEmisionFactura datetime not null default current_timestamp,
                        totalFactura decimal(10,2) not null,
                        idPedido int unique not null,
                        foreign key (idPedido) references Pedido(idPedido)
);

-- 7. VALORACION
create table Valoracion(
                           idValoracion int auto_increment primary key,
                           puntuacionValoracion int not null check (puntuacionValoracion between 1 and 5), -- NUEVO: Límite de 1 a 5 estrellas para renderizar en el UI
                           comentarioValoracion text,
                           fechaValoracion date not null default (CURRENT_DATE),
                           idProducto int not null,
                           idUsuario int not null,
                           foreign key (idProducto) references Producto(idProducto),
                           foreign key (idUsuario) references Usuario(idUsuario) on delete cascade
);