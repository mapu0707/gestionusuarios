package com.devsenior.gestionusuarios.service;

import java.util.List;

import com.devsenior.gestionusuarios.model.Usuario;

public interface UsuarioService {
    //Actualizar usuarios solo lo puede hacer el rol admin
    Usuario actualizarUsuarios(Integer id, Usuario usuario, Usuario usuarioActual);

    //actualizar el mismo rol, estandar o un administrador
    Usuario actualizarMiUsuarios(Integer id, Usuario usuario, Usuario usuarioActual);

    //solo lo puede hacer el administrador
    void crearUsuario(Usuario usuario, Usuario usuarioActual);

    //solo el admin
    List<Usuario> verTodosLosUsuarios(Usuario usuarioActual);

    //eliminar un usuario solo el admin
    void eliminarUsuario(Integer id, Usuario usuarioActual);

    //ver usuarios por id
    Usuario verUsuariosPorId(Integer id, Usuario usuarioActual);


    
    
}
