package com.devsenior.gestionusuarios.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Roles disponibles para los usuarios del sistema")
public enum RolUsuario {

@Schema(description = "Usuarios con permisos totales")
ADMINISTRADOR,

@Schema(description = "Usuarios con permisos limitados")
ESTANDAR
}
