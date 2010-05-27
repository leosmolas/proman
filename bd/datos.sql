use proyecto;

/* USUARIOS */
/* 10 Usuarios */
insert into usuarios (nombre, password, email) values ("1", "1", "sarasa");
insert into usuarios (nombre, password, email) values ("Nombre1", "Apellido1", "Email1");
insert into usuarios (nombre, password, email) values ("Nombre2", "Apellido2", "Email2");
insert into usuarios (nombre, password, email) values ("Nombre3", "Apellido3", "Email3");
insert into usuarios (nombre, password, email) values ("Nombre4", "Apellido4", "Email4");
insert into usuarios (nombre, password, email) values ("Nombre5", "Apellido5", "Email5");
insert into usuarios (nombre, password, email) values ("Nombre6", "Apellido6", "Email6");
insert into usuarios (nombre, password, email) values ("Nombre7", "Apellido7", "Email7");
insert into usuarios (nombre, password, email) values ("Nombre8", "Apellido8", "Email8");
insert into usuarios (nombre, password, email) values ("Nombre9", "Apellido9", "Email9");

/* PROYECTOS */
/* 3 Poryectos */
insert into proyectos (jefe, nombre, descripcion, fecha_inicio, fecha_fin, estado) values (1, "Proyecto1", "Proyecto 1, Jefe Nombre1 Apellido1", curdate(), adddate(curdate(),10), 'Activo');
insert into proyectos (jefe, nombre, descripcion, fecha_inicio, fecha_fin, estado) values (2, "Proyecto2", "Proyecto 2, Jefe Nombre2 Apellido2", subdate(curdate(),25), subdate(curdate(),10), 'Finalizado');
insert into proyectos (jefe, nombre, descripcion, fecha_inicio, fecha_fin, estado) values (3, "Proyecto3", "Proyecto 3, Jefe Nombre3 Apellido3", adddate(curdate(),5), adddate(curdate(),20), 'Pendiente');

/* EVENTOS */
/* 3 Eventos */
/* 2 Pertenecen al Proyecto 1, que se encuentra activo */
/* 1 Pertenece al Proyecto 2, que se encuentra finalizado */
/* Proyecto 3 no tiene eventos pues esta pendiente */
insert into eventos (proyecto, fecha, hora_inicio, nombre, descripcion) values (1, curdate(), curtime(), "Evento 1", "Evento Dia 1 del Proyecto 1 ");
insert into eventos (proyecto, fecha, hora_inicio, nombre, descripcion) values (1, adddate(curdate(),5), curtime(), "Evento 2", "Evento Dia 5 del Proyecto 1");
insert into eventos (proyecto, fecha, hora_inicio, nombre, descripcion) values (2, subdate(curdate(),22), curtime(), "Evento 1", "Evento Dia 3 del Proyecto 2");

/* GRUPOS */
/* 3 Grupos */
/* Grupo 1 -> Usuarios Primos */
/* Grupo 2 -> Multiplos de 2 */
/* Grupo 3 -> Multiplos de 3 */
insert into grupos (descripcion, proyecto) values ("Grupo Proyecto 1",1);
insert into grupos (descripcion, proyecto) values ("Grupo Proyecto 2",2);
insert into grupos (descripcion, proyecto) values ("Grupo Proyecto 3",3);

/* TAREAS */
/* 2 Tareas */
/* 1 Tarea del Proyecto 1 */
/* 1 Tarea del Proyecto 2 */
insert into tareas (descripcion, fecha_inicio, fecha_fin, proyecto, grupo) values ("Tarea Grupo 1, Proyecto 1", curdate(), adddate(curdate(),1), 1, 1);
insert into tareas (descripcion, fecha_inicio, fecha_fin, proyecto, grupo) values ("Tarea Grupo 2, Proyecto 2", subdate(curdate(),22), subdate(curdate(),20), 2, 2);

/* ROLES */
/* 10 Roles */
/* 1 Rol para cada usuario en el sistema (cada usuario pertenece a algun grupo) */
/* 1 Rol para el usuario 6 ya que es multiplo de 2 y 3 simultaneamente */
insert into rol (usuario, grupo, descripcion) values (1, 1, "Rol Usuario 1, Grupo 1 (sera jefe?, por ser jefe de proyecto)");
insert into rol (usuario, grupo, descripcion) values (5, 1, "Rol Usuario 5, Grupo 1");
insert into rol (usuario, grupo, descripcion) values (7, 1, "Rol Usuario 7, Grupo 1");
insert into rol (usuario, grupo, descripcion) values (2, 2, "Rol Usuario 2, Grupo 2 (sera jefe?, por ser jefe de proyecto)");
insert into rol (usuario, grupo, descripcion) values (4, 2, "Rol Usuario 4, Grupo 2");
insert into rol (usuario, grupo, descripcion) values (6, 2, "Rol Usuario 6, Grupo 2");
insert into rol (usuario, grupo, descripcion) values (8, 2, "Rol Usuario 8, Grupo 2");
insert into rol (usuario, grupo, descripcion) values (3, 3, "Rol Usuario 3, Grupo 3 (sera jefe?, por ser jefe de proyecto)");
insert into rol (usuario, grupo, descripcion) values (6, 3, "Rol Usuario 6, Grupo 3");
insert into rol (usuario, grupo, descripcion) values (9, 3, "Rol Usuario 9, Grupo 3");