package com.devsenior.gestionusuarios.model;

public class Usuario {
    private String nombreUsuario;
    private Integer id;
    private String nombreCompleto;
    private String contraseña;
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
