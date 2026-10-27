-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-10-2026 a las 22:28:12
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `flecha_flash`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `colectivos`
--

CREATE TABLE `colectivos` (
  `ID_Colectivo` int(11) NOT NULL,
  `Matricula` varchar(20) NOT NULL,
  `Marca` varchar(50) NOT NULL,
  `Modelo` varchar(50) NOT NULL,
  `Capacidad` int(11) NOT NULL,
  `Chofer` varchar(100) NOT NULL,
  `Estado` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `colectivos`
--

INSERT INTO `colectivos` (`ID_Colectivo`, `Matricula`, `Marca`, `Modelo`, `Capacidad`, `Chofer`, `Estado`) VALUES
(1, 'AE789GH', 'Volvo', '9700', 45, 'Luis Fernandez', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lugares`
--

CREATE TABLE `lugares` (
  `ID_Lugar` int(11) NOT NULL,
  `ID_Ruta` int(11) NOT NULL,
  `NumeroAsiento` int(11) NOT NULL,
  `Estado` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasajeros`
--

CREATE TABLE `pasajeros` (
  `ID_Pasajero` int(11) NOT NULL,
  `DNI` varchar(20) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Apellido` varchar(50) NOT NULL,
  `Correo` varchar(100) DEFAULT NULL,
  `Telefono` varchar(20) DEFAULT NULL,
  `Estado` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pasajeros`
--

INSERT INTO `pasajeros` (`ID_Pasajero`, `DNI`, `Nombre`, `Apellido`, `Correo`, `Telefono`, `Estado`) VALUES
(1, '40777888', 'Maria', 'Lopez', 'maria@gmail.com', '2664777888', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasajes`
--

CREATE TABLE `pasajes` (
  `ID_Pasaje` int(11) NOT NULL,
  `ID_Pasajero` int(11) NOT NULL,
  `ID_Lugar` int(11) NOT NULL,
  `FechaVenta` date NOT NULL,
  `HoraVenta` time NOT NULL,
  `Precio` decimal(10,2) NOT NULL,
  `Estado` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutas`
--

CREATE TABLE `rutas` (
  `ID_Ruta` int(11) NOT NULL,
  `Origen` varchar(100) NOT NULL,
  `Destino` varchar(100) NOT NULL,
  `HoraSalida` time NOT NULL,
  `HoraLlegada` time NOT NULL,
  `ID_Colectivo` int(11) NOT NULL,
  `Precio` decimal(10,2) NOT NULL,
  `Estado` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `rutas`
--

INSERT INTO `rutas` (`ID_Ruta`, `Origen`, `Destino`, `HoraSalida`, `HoraLlegada`, `ID_Colectivo`, `Precio`, `Estado`) VALUES
(1, 'San Luis', 'Cordoba', '08:00:00', '12:30:00', 1, 15000.00, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `colectivos`
--
ALTER TABLE `colectivos`
  ADD PRIMARY KEY (`ID_Colectivo`),
  ADD UNIQUE KEY `Matricula` (`Matricula`);

--
-- Indices de la tabla `lugares`
--
ALTER TABLE `lugares`
  ADD PRIMARY KEY (`ID_Lugar`),
  ADD KEY `ID_Ruta` (`ID_Ruta`);

--
-- Indices de la tabla `pasajeros`
--
ALTER TABLE `pasajeros`
  ADD PRIMARY KEY (`ID_Pasajero`),
  ADD UNIQUE KEY `DNI` (`DNI`),
  ADD UNIQUE KEY `Correo` (`Correo`);

--
-- Indices de la tabla `pasajes`
--
ALTER TABLE `pasajes`
  ADD PRIMARY KEY (`ID_Pasaje`),
  ADD KEY `ID_Pasajero` (`ID_Pasajero`),
  ADD KEY `ID_Lugar` (`ID_Lugar`);

--
-- Indices de la tabla `rutas`
--
ALTER TABLE `rutas`
  ADD PRIMARY KEY (`ID_Ruta`),
  ADD KEY `ID_Colectivo` (`ID_Colectivo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `colectivos`
--
ALTER TABLE `colectivos`
  MODIFY `ID_Colectivo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `lugares`
--
ALTER TABLE `lugares`
  MODIFY `ID_Lugar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `pasajeros`
--
ALTER TABLE `pasajeros`
  MODIFY `ID_Pasajero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `pasajes`
--
ALTER TABLE `pasajes`
  MODIFY `ID_Pasaje` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `rutas`
--
ALTER TABLE `rutas`
  MODIFY `ID_Ruta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `lugares`
--
ALTER TABLE `lugares`
  ADD CONSTRAINT `lugares_ibfk_1` FOREIGN KEY (`ID_Ruta`) REFERENCES `rutas` (`ID_Ruta`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pasajes`
--
ALTER TABLE `pasajes`
  ADD CONSTRAINT `pasajes_ibfk_1` FOREIGN KEY (`ID_Pasajero`) REFERENCES `pasajeros` (`ID_Pasajero`) ON UPDATE CASCADE,
  ADD CONSTRAINT `pasajes_ibfk_2` FOREIGN KEY (`ID_Lugar`) REFERENCES `lugares` (`ID_Lugar`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `rutas`
--
ALTER TABLE `rutas`
  ADD CONSTRAINT `rutas_ibfk_1` FOREIGN KEY (`ID_Colectivo`) REFERENCES `colectivos` (`ID_Colectivo`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
