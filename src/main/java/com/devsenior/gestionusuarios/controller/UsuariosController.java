package com.devsenior.gestionusuarios.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.gestionusuarios.model.Usuario;
import com.devsenior.gestionusuarios.service.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {
    private  final UsuarioService usuarioService;

    public UsuariosController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    //crear un usuario (solo admin)
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {

        Usuario usuarioActual = null;
        usuarioService.crearUsuario(usuario, usuarioActual);
        return usuario;
    }

    //ver todos los usuarios (solo admin)
    @GetMapping
    public List<Usuario> verTodosLUsuarios() {
        Usuario usuarioActual = null;
        return usuarioService.verTodosLosUsuarios(usuarioActual);
    }

    // ver un usuaio por Id
    @GetMapping("/{id}")
    public Usuario verUsuarioPorId(@PathVariable Integer id) {
        Usuario usuarioActual =null;
        return usuarioService.verUsuariosPorId(id, usuarioActual);
    }
     
    //actualiza usuarios por id
    @PostMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        Usuario usuarioActual = null;
        return usuarioService.actualizarMiUsuarios(id, usuario, usuarioActual);
    }

    //actualizar mi perfil
    @PutMapping("mi-perfil/{id}")
    public Usuario actualizarMiPerfil(@PathVariable String id, @RequestBody Usuario usuario) {
        Usuario usuarioActual = null;
        return usuarioService.actualizarMiUsuarios(null, usuario, usuarioActual);
    }

    //eliminar un usuario
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Integer id){
        Usuario usuarioActual = null;
        usuarioService.eliminarUsuario(id, usuarioActual);
    }
    

}
