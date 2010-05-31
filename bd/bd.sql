create database proyecto;
create user 'admin' identified by 'admin';
grant super on *.* to 'admin';
grant all privileges on *.* to 'admin' with grant option;


use proyecto;

create table usuarios (

	id_usuario int unsigned not null auto_increment,
	nombre     varchar(45)  not null,
    password   varchar(45)  not null,
	email      varchar(45),
		
	primary key (id_usuario, nombre)

) ENGINE=innoDB;


create table proyectos (

	id_proyecto int unsigned not null auto_increment,
    jefe int unsigned not null,
	nombre varchar(45) not null,
    descripcion text,
	fecha_inicio date not null,
    fecha_fin date not null,
	estado enum('Activo', 'Finalizado', 'Cancelado', 'Pendiente') not null,
    
	primary key (id_proyecto),
	
	key FK_proyecto_usuario (jefe),
	constraint FK_proyecto_usuario foreign key (jefe) references usuarios (id_usuario)

) ENGINE=innoDB;


create table eventos (

    id_evento int unsigned not null auto_increment,
    proyecto int unsigned not null,
	fecha date not null,
    hora_inicio time not null,
	nombre varchar(45) not null,
	descripcion text,
	
	primary key (id_evento),
    
    key FK_evento_proyecto (proyecto),
    constraint FK_evento_proyecto foreign key (proyecto) references proyectos (id_proyecto)
    
) ENGINE=innoDB;


create table grupos (

	id_grupo int unsigned not null auto_increment,
	nombre varchar(45) not null,
	descripcion text,
    proyecto int unsigned,
	
	primary key (id_grupo),

	key FK_grupo_proyecto (proyecto),
	constraint FK_grupo_proyecto foreign key (proyecto) references proyectos (id_proyecto)
	
) ENGINE=innoDB;


create table tareas (

	id_tarea int unsigned not null auto_increment,
	descripcion text not null,
	fecha_inicio date not null,
    fecha_fin date not null,
    proyecto int unsigned not null,
    grupo int unsigned not null,
	
	primary key (id_tarea),
	
	key FK_tarea_proyecto (proyecto),
	constraint FK_tarea_proyecto foreign key (proyecto) references proyectos (id_proyecto),
    
    key FK_tarea_grupo (grupo),
    constraint FK_tarea_grupo foreign key (grupo) references grupos (id_grupo)

) ENGINE=innoDB;


create table rol (

	usuario int unsigned not null,
    grupo int unsigned not null,
	descripcion text,
	
	primary key (usuario,grupo),
	
	key FK_usuario_rol (usuario),
	constraint FK_usuario_rol foreign key (usuario) references usuarios (id_usuario),
    
    key FK_grupo_rol (grupo),
    constraint FK_tgrupo_rol foreign key (grupo) references grupos (id_grupo)

) ENGINE=innoDB;