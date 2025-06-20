create database BD2_lozano;
use BD2_lozano;
create TABLE cliente(
id_cliente INT primary key,
nombre varchar(100)not null,
email varchar(100) not null
);
create table peliculas(
id_pelicula INT PRIMARY KEY,
titulo varchar(150) not null,

genero varchar(150) not null,
stock int not null
);
create table alquileres(
id_alquiler int auto_increment primary key,
fecha date not null,
id_cliente int not null,
total decimal(10,2) not null,
estado ENUM('Activo','Devuelto','Retrasado')not null,
foreign key (id_cliente) references cliente (id_cliente)
);

create table detalle_alquiler(
id_alquiler int not null,
id_pelicula int not null,
cantidad int not null,
primary key (id_alquiler, id_pelicula),
foreign key (id_alquiler) references alquileres(id_alquiler),
foreign key (id_pelicula) references peliculas(id_pelicula)
);
insert into cliente(id_cliente, nombre, email) values
(1,'Juan Lopez','juanlopez@gmail.com'),
(2,'Ana Vallejos', 'anavallejos@gmail.com'),
(3,'luis vega', 'luisvega@gmail.com');

INSERT INTO peliculas (id_pelicula, titulo, genero, stock) VALUES
(1, 'John Wick', 'Acción', 4),
(2, 'El Contador 2', 'Suspenso', 2),
(3, 'Lilo y Stitch', 'Ciencia Ficción', 3);
