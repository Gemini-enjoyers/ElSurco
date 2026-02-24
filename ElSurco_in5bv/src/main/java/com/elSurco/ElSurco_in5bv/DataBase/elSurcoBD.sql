drop database if exists tiendaDB_ElSurco_in5bv;
create database tiendaDB_ElSurco_in5bv;
use tiendaDB_ElSurco_in5bv;

-- 1. tabla para el acceso (login)
create table Login(
    idLogin int auto_increment primary key,
    emailLogin varchar(100) unique not null,
    passwordLogin varchar(255) not null,
    rolUsuario enum('ADMIN', 'AGRICULTOR', 'COMPRADOR') not null
);

-- 2. perfil del agricultor
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

-- 3. perfil del comprador
create table Comprador(
    idComprador int auto_increment primary key,
    nombreComprador varchar(50) not null,
    apellidoComprador varchar(50) not null,
    telefonoComprador bigint not null,
    direccionComprador varchar(200) not null,
    idLogin int not null,
    foreign key (idLogin) references Login(idLogin) on delete cascade
);

-- 4. categoria de productos
create table Categoria(
    idCategoria int auto_increment primary key,
    nombreCategoria varchar(50) not null, -- ej: "Fruta", "Verdura", "Grano"
    descripcionCategoria varchar(150)
);

-- 5. inventario de productos
create table Producto(
    idProducto int auto_increment primary key,
    nombreProducto varchar(100) not null,
    descripcionProducto varchar(200),
    precioProducto decimal(10,2) not null,
    stockProducto int not null, -- cantidad disponible
    fechaCosechaProducto date not null,
    idAgricultor int not null,
    idCategoria int not null,
    foreign key (idAgricultor) references Agricultor(idAgricultor),
    foreign key (idCategoria) references Categoria(idCategoria)
);

-- 6. pedidos (carrito de compras)
create table Pedido(
    idPedido int auto_increment primary key,
    fechaPedido datetime not null,
    totalPedido decimal(10,2) not null,
    estadoPedido enum('PENDIENTE', 'EN_CAMINO', 'ENTREGADO', 'CANCELADO') not null,
	idComprador int not null,
    foreign key (idComprador) references Comprador(idComprador)
);

-- 7. detalle del pedido (que productos van dentro de la caja)
create table DetallePedido(
    idDetallePedido int auto_increment primary key,
    cantidadDetalle int not null,
    subtotalDetalle decimal(10,2) not null,
	idPedido int not null,
    idProducto int not null,
    foreign key (idPedido) references Pedido(idPedido) on delete cascade,
    foreign key (idProducto) references Producto(idProducto)
);

-- 8. factura (documento legal)
create table Factura(
    idFactura int auto_increment primary key,
    nitFactura varchar(15) default 'CF',
    fechaEmisionFactura datetime not null,
    totalFactura decimal(10,2) not null,
	idPedido int unique not null,
    foreign key (idPedido) references Pedido(idPedido)
);

-- 9. valoraciones (estrellitas y comentarios)
create table Valoracion(
    idValoracion int auto_increment primary key,
    puntuacionValoracion int not null, -- del 1 al 5
    comentarioValoracion text,
    fechaValoracion date not null,
    idProducto int not null,
    idComprador int not null,
    foreign key (idProducto) references Producto(idProducto),
    foreign key (idComprador) references Comprador(idComprador)
);