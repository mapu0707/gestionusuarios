package com.devsenior.gestionusuarios.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.devsenior.gestionusuarios.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    Set<Usuario> usuarios;

    

    public UsuarioServiceImpl(Set<Usuario> usuarios) {
        this.usuarios = new HashSet<>();
    }

    @Override
    public Usuario actualizarUsuarios(Integer id, Usuario usuario, Usuario usuarioActual) {
        validarEsAdmin(usuarioActual, "Actualizar usuario");
        Usuario usuarioExistente = buscarUsuarioPorId(id);
        usuarios.remove(usuarioExistente);
        usuarios.add(usuario);
        return usuario;
    }

    @Override
    public Usuario actualizarMiUsuarios(Integer id, Usuario usuario, Usuario usuarioActual) {
        validarEsMismoUsuario(usuarioActual, id);
        Usuario usuarioExistente = buscarUsuarioPorId(id);
        usuarios.remove(usuarioExistente);
        usuarios.add(usuario);
        return usuario;
    }

    @Override
    public void crearUsuario(Usuario usuario, Usuario usuarioActual) {
       validarEsAdmin(usuarioActual, "crear usuarios");
       usuarios.add(usuario);
    }

    @Override
    public List<Usuario> verTodosLosUsuarios(Usuario usuarioActual) {
        validarEsAdmin(usuarioActual,"ver todos los usuaios");
        return new ArrayList<>(usuarios);
    }

    @Override
    public void eliminarUsuario(Integer id, Usuario usuarioActual) {
        validarEsAdmin(usuarioActual, "eliminar usuario");
        Usuario usuarioEliminado = buscarUsuarioPorId(id);
        usuarios.remove(usuarioEliminado);
    }

    @Override
    public Usuario verUsuariosPorId(Integer id, Usuario usuarioActual) {
        validarEsAdmin(usuarioActual, "ver usuario por id");
        return buscarUsuarioPorId(id);
    }

    //Opreaciones de logica de negocio
    
    
    //metodos para validar segun los roles
    private void validarEsAdmin(Usuario usuario, String operacion){

    }

    //metodo para validar si es mismmo usuario
    private void validarEsMismoUsuario(Usuario usuarioActual, Integer idObjetivo){

    }

    //metodo buscar por id
    private Usuario buscarUsuarioPorId(Integer id){
        return usuarios.stream()
        .filter( usuario -> usuario.getId().equals(id))
        .findFirst()
        .orElseThrow(()-> new RuntimeException("el usuario con id " + id + " no fue encontrado"));
    }

   
}
