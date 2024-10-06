-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.28-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para fvfutsistem
CREATE DATABASE IF NOT EXISTS `fvfutsistem` /*!40100 DEFAULT CHARACTER SET armscii8 COLLATE armscii8_bin */;
USE `fvfutsistem`;

-- Volcando estructura para tabla fvfutsistem.equipo
CREATE TABLE IF NOT EXISTS `equipo` (
  `equipo_id` int(11) NOT NULL AUTO_INCREMENT,
  `equipo_localidad` varchar(50) NOT NULL DEFAULT '0',
  `equipo_nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`equipo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;

-- Volcando datos para la tabla fvfutsistem.equipo: ~0 rows (aproximadamente)

-- Volcando estructura para tabla fvfutsistem.jugador
CREATE TABLE IF NOT EXISTS `jugador` (
  `jugador_dni` int(11) NOT NULL,
  `jugador_nombre` varchar(50) NOT NULL DEFAULT '',
  `jugador_apellido` varchar(50) NOT NULL DEFAULT '',
  `jugador_edad` int(11) NOT NULL DEFAULT 0,
  `jugador_goles` int(11) NOT NULL DEFAULT 0,
  `jugador_equipo` int(11) NOT NULL DEFAULT 0,
  `jugador_tarjetasAmarillas` int(11) NOT NULL DEFAULT 0,
  `jugador_tarjetasRojas` int(11) NOT NULL DEFAULT 0,
  `jugador_sancionActiva` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`jugador_dni`) USING BTREE,
  KEY `equipo_jugador` (`jugador_equipo`),
  CONSTRAINT `equipo_jugador` FOREIGN KEY (`jugador_equipo`) REFERENCES `equipo` (`equipo_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;

-- Volcando datos para la tabla fvfutsistem.jugador: ~0 rows (aproximadamente)

-- Volcando estructura para tabla fvfutsistem.sancion
CREATE TABLE IF NOT EXISTS `sancion` (
  `sancion_id` int(11) NOT NULL AUTO_INCREMENT,
  `sancion_duracion` int(11) NOT NULL DEFAULT 0,
  `sancion_fechaInicio` date NOT NULL,
  `sancion_fechaFin` date NOT NULL,
  `sancion_jugadorDNI` int(11) NOT NULL,
  PRIMARY KEY (`sancion_id`),
  KEY `jugadorDNI` (`sancion_jugadorDNI`),
  CONSTRAINT `jugadorDNI` FOREIGN KEY (`sancion_jugadorDNI`) REFERENCES `jugador` (`jugador_dni`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;

-- Volcando datos para la tabla fvfutsistem.sancion: ~0 rows (aproximadamente)

-- Volcando estructura para tabla fvfutsistem.transferencia
CREATE TABLE IF NOT EXISTS `transferencia` (
  `transferencia_id` int(11) NOT NULL AUTO_INCREMENT,
  `transferencia_dniJugador` int(11) NOT NULL DEFAULT 0,
  `transferencia_equipoAnterior` int(11) NOT NULL DEFAULT 0,
  `transferencia_equipoActual` int(11) NOT NULL DEFAULT 0,
  `transferencia_fecha` date NOT NULL,
  PRIMARY KEY (`transferencia_id`),
  KEY `dni_jugador_tr` (`transferencia_dniJugador`),
  KEY `equipoAnt_tr` (`transferencia_equipoAnterior`),
  KEY `equipoAct_tr` (`transferencia_equipoActual`),
  CONSTRAINT `dni_jugador_tr` FOREIGN KEY (`transferencia_dniJugador`) REFERENCES `jugador` (`jugador_dni`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `equipoAct_tr` FOREIGN KEY (`transferencia_equipoActual`) REFERENCES `equipo` (`equipo_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `equipoAnt_tr` FOREIGN KEY (`transferencia_equipoAnterior`) REFERENCES `equipo` (`equipo_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;

-- Volcando datos para la tabla fvfutsistem.transferencia: ~0 rows (aproximadamente)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
