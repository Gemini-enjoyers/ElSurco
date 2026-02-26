drop database if exists ElSurcoDB_in5bv;
create database ElSurcoDB_in5bv;
use ElSurcoDB_in5bv;

-- 1. LOGIN
create table Login(
    idLogin int auto_increment primary key,
    emailLogin varchar(100) unique not null,
    passwordLogin varchar(255) not null,
    rolUsuario enum('ADMIN', 'AGRICULTOR', 'COMPRADOR') not null
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
    idLogin int not null,
    foreign key (idLogin) references Login(idLogin) on delete cascade
);

-- 3. COMPRADOR
create table Comprador(
    idComprador int auto_increment primary key,
    nombreComprador varchar(50) not null,
    apellidoComprador varchar(50) not null,
    telefonoComprador bigint not null,       
    direccionComprador varchar(200) not null,
    idLogin int not null,
    foreign key (idLogin) references Login(idLogin) on delete cascade
);

-- 4. CATEGORIA
create table Categoria(
    idCategoria int auto_increment primary key,
    nombreCategoria varchar(50) not null,
    descripcionCategoria varchar(150)
);

-- 5. PRODUCTO
create table Producto(
    idProducto int auto_increment primary key,
    nombreProducto varchar(100) not null,
    descripcionProducto varchar(200),
    precioProducto decimal(10,2) not null,
    stockProducto int not null,
    fechaCosechaProducto date not null,
    idAgricultor int not null,
    idCategoria int not null,
    foreign key (idAgricultor) references Agricultor(idAgricultor),
    foreign key (idCategoria) references Categoria(idCategoria)
);

-- 6. PEDIDO
create table Pedido(
    idPedido int auto_increment primary key,
    fechaPedido datetime not null,
    totalPedido decimal(10,2) not null,
    cantidadPedido int not null, 
    estadoPedido enum('PENDIENTE', 'EN_CAMINO', 'ENTREGADO', 'CANCELADO') not null,
    idComprador int not null,
    foreign key (idComprador) references Comprador(idComprador),
    idProducto int not null,
    foreign key (idProducto) references Producto(idProducto)
);

-- 7. FACTURA
create table Factura(
    idFactura int auto_increment primary key,
    nitFactura varchar(15) default 'CF',
    fechaEmisionFactura datetime not null,
    totalFactura decimal(10,2) not null,
    idPedido int unique not null,
    foreign key (idPedido) references Pedido(idPedido)
);

-- 8. VALORACION
create table Valoracion(
    idValoracion int auto_increment primary key,
    puntuacionValoracion int not null, 
    comentarioValoracion text,
    fechaValoracion date not null,
    idProducto int not null,
    idComprador int not null,
    foreign key (idProducto) references Producto(idProducto),
    foreign key (idComprador) references Comprador(idComprador)
);