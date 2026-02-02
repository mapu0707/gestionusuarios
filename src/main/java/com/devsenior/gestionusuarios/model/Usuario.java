package com.devsenior.gestionusuarios.model;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Schema(description = "Modelo que representa un usuario en el sistema")
public class Usuario {
    @Schema(description = "Nombre de usuario unico para el login", example = "jperez", requiredMode = RequiredMode.REQUIRED)
    @NotBlank(message = "El nombre de usuario no puede ser nulo, ni vacio o que solo contenga espacios")
    private String nombreUsuario;

    @Schema(description = "Identificador unico del usurio", example = "1", requiredMode = RequiredMode.REQUIRED)
    @NotNull(message = "El id es obligatorio")
    @Positive(message = "El id debe ser un numero positivo")
    private Integer id;

    @Schema(description = "El nombre completo del usuario", example = "jperez", requiredMode = RequiredMode.REQUIRED)
    @NotBlank(message = "El nombre completo del usuario no puede ser nulo, ni vacio o que solo tenga espacios.")
    private String nombreCompleto;

    @Schema(description = "La contraseña del usuario debe tener minimo 10 caracteres usando #,$@", example = "jperez###", requiredMode = RequiredMode.REQUIRED)
    @NotBlank(message = "La contraseña del usuario no puede ser nula, ni vacia o que tenga espacios en blanco")
    private String contraseña;

    @Schema(description = "El rol del usuario del usuario del sistema", example = "ADMINISTRADOR", requiredMode = RequiredMode.REQUIRED)
    private RolUsuario rol;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, Integer id, String nombreCompleto, String contraseña, RolUsuario rol) {
        this.nombreUsuario = nombreUsuario;
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public RolUsuario getRol() {
        return rol;
    }

    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }
    
    //hashcode
    public int hashCode(){
        return id != null ? id.hashCode() : 0;
    }

    //equals
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() !=obj.getClass()) {
            return false;
        }
        Usuario usuario = (Usuario) obj;
        return id != null ? id.equals(usuario.id) : usuario.id == null;
    }
    
}
