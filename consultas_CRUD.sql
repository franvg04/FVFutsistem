INSERT INTO equipo (equipo_id, equipo_localidad, equipo_nombre)
VALUES
(1, 'Calamuchita', 'Deportivo Italiano'),
(2, 'Calamuchita', 'Nautico Rumipal'),
(3, 'Calamuchita', 'Sportivo 9 de Julio');


SELECT * FROM equipo;

UPDATE equipo
SET equipo_localidad = 'Rio Tercero'
WHERE equipo_id = 3;

DELETE FROM equipo
WHERE equipo_id = 3;

INSERT INTO jugador (jugador_dni, jugador_nombre, jugador_apellido, jugador_edad, jugador_goles, jugador_equipo, jugador_tarjetasAmarillas, jugador_tarjetasRojas, jugador_sancionActiva)
VALUES 
(45480446, 'Franco', 'Vega', 20, 5, 1, 1, 0, 0),
(12345678, 'Lionel', 'Messi', 37, 129, 1, 2, 1, 0);

SELECT * FROM jugador;

UPDATE jugador 
SET jugador_goles = 7
WHERE jugador_dni = 45480446;

DELETE FROM jugador
WHERE jugador_dni = 12345678;

INSERT INTO sancion (sancion_id, sancion_duracion, sancion_fechaInicio, sancion_fechaFin, sancion_jugadorDNI)
VALUES (1, 2, '2024-10-05', '2024-10-19', 45480446);

SELECT * FROM sancion;

UPDATE sancion
SET sancion_duracion = 4
WHERE sancion_id = 1;

DELETE FROM sancion
WHERE sancion_id = 1;


INSERT INTO transferencia (transferencia_id, transferencia_dniJugador, transferencia_equipoAnterior, transferencia_equipoActual, transferencia_fecha)
VALUES (1, 45480446, 1, 2, '2024-10-09');

SELECT * FROM transferencia;

UPDATE transferencia 
SET transferencia_fecha = '2024-10-05'
WHERE transferencia_id = 1;

DELETE FROM transferencia
WHERE transferencia_id = 1;