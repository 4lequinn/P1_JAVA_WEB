-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-09-2021 a las 04:24:22
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 7.3.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `liga_videojuegos`
--
CREATE DATABASE IF NOT EXISTS `liga_videojuegos` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `liga_videojuegos`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_equipo`
--

CREATE TABLE `detalle_equipo` (
  `id` int(11) NOT NULL,
  `id_inscripcion` int(11) NOT NULL,
  `id_equipo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

CREATE TABLE `equipo` (
  `id` int(11) NOT NULL,
  `nombre` varchar(80) NOT NULL,
  `cantidad_jugador` int(11) NOT NULL,
  `id_liga` int(11) NOT NULL,
  `id_perfil` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_solicitud`
--

CREATE TABLE `estado_solicitud` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `incripcion`
--

CREATE TABLE `incripcion` (
  `id` int(11) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp(),
  `id_estado` int(11) NOT NULL,
  `id_jugador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `liga`
--

CREATE TABLE `liga` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `cantidad_equipo` int(11) NOT NULL,
  `id_juego` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfil_jugador`
--

CREATE TABLE `perfil_jugador` (
  `id` int(11) NOT NULL,
  `nombre` varchar(80) NOT NULL,
  `correo` varchar(80) NOT NULL,
  `habilidad` varchar(80) NOT NULL,
  `id_tipo_jugador` int(11) NOT NULL,
  `id_usuario` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_jugador`
--

CREATE TABLE `tipo_jugador` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_usuario`
--

CREATE TABLE `tipo_usuario` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `usuario` varchar(50) NOT NULL,
  `contrasenia` varchar(50) NOT NULL,
  `id_tipo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `video_juego`
--

CREATE TABLE `video_juego` (
  `id` int(11) NOT NULL,
  `nombre` varchar(80) NOT NULL,
  `tipo_juego` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `detalle_equipo`
--
ALTER TABLE `detalle_equipo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_equipo` (`id_equipo`),
  ADD KEY `id_inscripcion` (`id_inscripcion`);

--
-- Indices de la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_liga` (`id_liga`),
  ADD KEY `id_perfil` (`id_perfil`);

--
-- Indices de la tabla `estado_solicitud`
--
ALTER TABLE `estado_solicitud`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `incripcion`
--
ALTER TABLE `incripcion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_jugador` (`id_jugador`),
  ADD KEY `id_estado` (`id_estado`);

--
-- Indices de la tabla `liga`
--
ALTER TABLE `liga`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_juego` (`id_juego`);

--
-- Indices de la tabla `perfil_jugador`
--
ALTER TABLE `perfil_jugador`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_tipo_jugador` (`id_tipo_jugador`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `tipo_jugador`
--
ALTER TABLE `tipo_jugador`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`usuario`),
  ADD KEY `id_tipo` (`id_tipo`);

--
-- Indices de la tabla `video_juego`
--
ALTER TABLE `video_juego`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `detalle_equipo`
--
ALTER TABLE `detalle_equipo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `equipo`
--
ALTER TABLE `equipo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `estado_solicitud`
--
ALTER TABLE `estado_solicitud`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `incripcion`
--
ALTER TABLE `incripcion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `liga`
--
ALTER TABLE `liga`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `perfil_jugador`
--
ALTER TABLE `perfil_jugador`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_jugador`
--
ALTER TABLE `tipo_jugador`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `video_juego`
--
ALTER TABLE `video_juego`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_equipo`
--
ALTER TABLE `detalle_equipo`
  ADD CONSTRAINT `detalle_equipo_ibfk_1` FOREIGN KEY (`id_equipo`) REFERENCES `equipo` (`id`),
  ADD CONSTRAINT `detalle_equipo_ibfk_2` FOREIGN KEY (`id_inscripcion`) REFERENCES `incripcion` (`id`);

--
-- Filtros para la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD CONSTRAINT `equipo_ibfk_2` FOREIGN KEY (`id_liga`) REFERENCES `liga` (`id`),
  ADD CONSTRAINT `equipo_ibfk_3` FOREIGN KEY (`id_perfil`) REFERENCES `perfil_jugador` (`id`);

--
-- Filtros para la tabla `incripcion`
--
ALTER TABLE `incripcion`
  ADD CONSTRAINT `incripcion_ibfk_1` FOREIGN KEY (`id_jugador`) REFERENCES `perfil_jugador` (`id`),
  ADD CONSTRAINT `incripcion_ibfk_2` FOREIGN KEY (`id_estado`) REFERENCES `estado_solicitud` (`id`);

--
-- Filtros para la tabla `liga`
--
ALTER TABLE `liga`
  ADD CONSTRAINT `liga_ibfk_1` FOREIGN KEY (`id_juego`) REFERENCES `video_juego` (`id`);

--
-- Filtros para la tabla `perfil_jugador`
--
ALTER TABLE `perfil_jugador`
  ADD CONSTRAINT `perfil_jugador_ibfk_2` FOREIGN KEY (`id_tipo_jugador`) REFERENCES `tipo_jugador` (`id`),
  ADD CONSTRAINT `perfil_jugador_ibfk_3` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`usuario`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_tipo`) REFERENCES `tipo_usuario` (`id`);


--
-- TIPOS DE USUARIO
--

INSERT INTO TIPO_USUARIO VALUES (1,'ADMINISTRADOR');
INSERT INTO TIPO_USUARIO VALUES (2,'USUARIO');

--
-- TIPOS DE JUGADOR 
--
INSERT INTO TIPO_JUGADOR VALUES (1, 'ESTRATEGA');
INSERT INTO TIPO_JUGADOR VALUES (2, 'SHOOTER');

--
-- ESTADOS DE SOLICITUD
--
INSERT INTO ESTADO_SOLICITUD VALUES (1,'PENDIENTE');
INSERT INTO ESTADO_SOLICITUD VALUES (2,'ACEPTADA');
INSERT INTO ESTADO_SOLICITUD VALUES (3,'RECHAZADA');

--
-- VIDEO JUEGOS
--
INSERT INTO VIDEO_JUEGO VALUES (1, 'LEAGUE OF LEGENDS','MOBA BATTLE ARENA');
INSERT INTO VIDEO_JUEGO VALUES (2, 'APEX LEGENDS','BATTLE ROYALE');
INSERT INTO VIDEO_JUEGO VALUES (3, 'COUNTER STRIKE GLOBAL OFFENSIVE','SHOOTER');
INSERT INTO VIDEO_JUEGO VALUES (4, 'FIFA 22','EA SPORTS');

--
-- LIGAS
--
INSERT INTO LIGA VALUES (1, 'LIGA DE LOS MUCAS', 0, 1);


COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
