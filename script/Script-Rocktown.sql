CREATE DATABASE `rocktown`
-- rocktown.actividad definition

CREATE TABLE `actividad` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `empleado_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5yc1riadb90t7hojty57qpctv` (`empleado_id`),
  CONSTRAINT `FK5yc1riadb90t7hojty57qpctv` FOREIGN KEY (`empleado_id`) REFERENCES `empleado` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- rocktown.cliente definition

CREATE TABLE `cliente` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(255) DEFAULT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `fecha_bono` date DEFAULT NULL,
  `menor_edad` bit(1) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `pie_gato` bit(1) NOT NULL,
  `sesiones_gastadas` int NOT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- rocktown.empleado definition

CREATE TABLE `empleado` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(255) DEFAULT NULL,
  `contrasena_hash` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `nombre_usuario` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- rocktown.entrada definition

CREATE TABLE `entrada` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `cliente_id` bigint DEFAULT NULL,
  `tipo_entrada_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgfasx2tg2dokk47bm05kboo82` (`cliente_id`),
  KEY `FKanqpsesmkjdx303yh5pvy4gdh` (`tipo_entrada_id`),
  CONSTRAINT `FKanqpsesmkjdx303yh5pvy4gdh` FOREIGN KEY (`tipo_entrada_id`) REFERENCES `tipo_entrada` (`id`),
  CONSTRAINT `FKgfasx2tg2dokk47bm05kboo82` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- rocktown.horario_disponible definition

CREATE TABLE `horario_disponible` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dia_semana` tinyint DEFAULT NULL,
  `hora_fin` time(6) DEFAULT NULL,
  `hora_inicio` time(6) DEFAULT NULL,
  `actividad_id` bigint DEFAULT NULL,
  `sala_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj8ybsuvp0mu57kjfgoyotvwxc` (`actividad_id`),
  KEY `FKdg4xd9l0o5io4yc2fbkelofb1` (`sala_id`),
  CONSTRAINT `FKdg4xd9l0o5io4yc2fbkelofb1` FOREIGN KEY (`sala_id`) REFERENCES `sala` (`id`),
  CONSTRAINT `FKj8ybsuvp0mu57kjfgoyotvwxc` FOREIGN KEY (`actividad_id`) REFERENCES `actividad` (`id`),
  CONSTRAINT `horario_disponible_chk_1` CHECK ((`dia_semana` between 0 and 6))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- rocktown.recordatorio definition

CREATE TABLE `recordatorio` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `texto` varchar(255) DEFAULT NULL,
  `empleado_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3api72suk8q1t9qtyb5mg3uje` (`empleado_id`),
  CONSTRAINT `FK3api72suk8q1t9qtyb5mg3uje` FOREIGN KEY (`empleado_id`) REFERENCES `empleado` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- rocktown.reserva definition

CREATE TABLE `reserva` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `hora` time(6) DEFAULT NULL,
  `actividad_id` bigint DEFAULT NULL,
  `cliente_id` bigint DEFAULT NULL,
  `sala_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnldy4amxkkptwno1saohc0sgo` (`actividad_id`),
  KEY `FK7cg2jiyn5cf6f6elccvb6963k` (`cliente_id`),
  KEY `FKrb7m5fot7vm8u2d83p0im7ekw` (`sala_id`),
  CONSTRAINT `FK7cg2jiyn5cf6f6elccvb6963k` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  CONSTRAINT `FKnldy4amxkkptwno1saohc0sgo` FOREIGN KEY (`actividad_id`) REFERENCES `actividad` (`id`),
  CONSTRAINT `FKrb7m5fot7vm8u2d83p0im7ekw` FOREIGN KEY (`sala_id`) REFERENCES `sala` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- rocktown.sala definition

CREATE TABLE `sala` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- rocktown.tipo_entrada definition

CREATE TABLE `tipo_entrada` (
  `dtype` varchar(31) NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `frecuencia` varchar(255) DEFAULT NULL,
  `notas` varchar(255) DEFAULT NULL,
  `precio` double NOT NULL,
  `publico_destino` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `bebida_incluida` bit(1) DEFAULT NULL,
  `comida_incluida` bit(1) DEFAULT NULL,
  `max_ninyos` int DEFAULT NULL,
  `notas_especificas` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

