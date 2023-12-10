BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Usuarios" (
	"Id_Usuario"	INTEGER NOT NULL UNIQUE,
	"NºExpedientes "	INTEGER NOT NULL UNIQUE,
	"Contraseña"	TEXT NOT NULL,
	"Codigo secreto"	INTEGER NOT NULL UNIQUE,
	"Tipo_usuario"	TEXT,
	PRIMARY KEY("Id_Usuario")
);
CREATE TABLE IF NOT EXISTS "Reservas" (
	"Id_Reserva"	INTEGER NOT NULL UNIQUE,
	"Id_Usuario"	INTEGER NOT NULL,
	"Id_Plaza"	INTEGER NOT NULL,
	"Date_Inicio"	INTEGER NOT NULL,
	"Date_Final"	INTEGER NOT NULL,
	PRIMARY KEY("Id_Reserva" AUTOINCREMENT),
	FOREIGN KEY("Id_Usuario") REFERENCES "Usuarios"("Id_Usuario"),
	FOREIGN KEY("Id_Plaza") REFERENCES "Plaza"("Id_Plaza")
);
CREATE TABLE IF NOT EXISTS "Plaza" (
	"Id_Plaza"	INTEGER NOT NULL UNIQUE,
	"Id_Zona"	INTEGER NOT NULL,
	"Lugar"	TEXT NOT NULL,
	PRIMARY KEY("Id_Plaza" AUTOINCREMENT),
	FOREIGN KEY("Id_Zona") REFERENCES "Zona"("Id_Zona")
);
CREATE TABLE IF NOT EXISTS "Zona" (
	"Id_Zona"	INTEGER NOT NULL UNIQUE,
	"Disponibilidad"	INTEGER NOT NULL,
	PRIMARY KEY("Id_Zona" AUTOINCREMENT)
);
COMMIT;