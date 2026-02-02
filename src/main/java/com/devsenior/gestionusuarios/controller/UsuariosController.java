package com.devsenior.gestionusuarios.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.gestionusuarios.model.Usuario;
import com.devsenior.gestionusuarios.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Tag(name = "Usuarios", description = "api para la gestion de usuarios de un programa educativo")
@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {
    private final UsuarioService usuarioService;

    public UsuariosController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // crear un usuario (solo admin)
    @Operation(summary = "Crear un nuevo usuario", description = "permite crear un usuario nuevo en el sistema, solo lo pueden hacer las personas con rol de administrador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario creado exitosamente", content = @Content(mediaType = "aplication/json", schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "400", description = "Datos de entrada invalidos ( Validacion fallida)", content = @Content),
            @ApiResponse(responseCode = "403", description = "Acceso denegado - Solo ADMINISTRADORES pueden crear usuarios ", content = @Content)
    })
    @PostMapping
    public Usuario crearUsuario(@Valid @RequestBody Usuario usuario) {

        Usuario usuarioActual = null;
        usuarioService.crearUsuario(usuario, usuarioActual);
        return usuario;
    }

    // ver todos los usuarios (solo admin)
    @Operation(summary = "Ver todos los usuarios del sistema, solo lo puede hace el rol ADMINISTRADOR", description = "Retorna una lista de todos los usuarios que hay en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de usuarios obtenidos exitosamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class)))
    })
    @GetMapping
    public List<Usuario> verTodosLUsuarios() {
        Usuario usuarioActual = null;
        return usuarioService.verTodosLosUsuarios(usuarioActual);
    }

    // ver un usuaio por Id
    @Operation(summary = "Ve usuario por Id", description = "Permite ver un usuario en especifico que tiene ese mismo campo en atributo Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista del usuario con ese Id exitosamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class)))
    })
    @GetMapping("/{id}")
    public Usuario verUsuarioPorId(@PathVariable Integer id) {
        Usuario usuarioActual = null;
        return usuarioService.verUsuariosPorId(id, usuarioActual);
    }

    // actualiza usuarios por id, solo por el admin
    @Operation(summary = "Actualiza un usuario", description = "Permite actualizar completamente un usuario en especifico segun su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Actualiza el usuario en todos sus campos exitosamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class)))
    })
    @PostMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable Integer id, @Valid @RequestBody Usuario usuario) {
        Usuario usuarioActual = null;
        return usuarioService.actualizarMiUsuarios(id, usuario, usuarioActual);
    }

    // actualizar mi perfil
    @Operation(summary = "Actualizacion de pefil", description = "Permite actualizar el mismo perfil del usuario, lo pueden hacer personas con rol estandar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Actualiza el perfil del usuario exitosamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class)))
    })
    @PutMapping("mi-perfil/{id}")
    public Usuario actualizarMiPerfil(@PathVariable String id, @Valid @RequestBody Usuario usuario) {
        Usuario usuarioActual = null;
        return usuarioService.actualizarMiUsuarios(null, usuario, usuarioActual);
    }

    // eliminar un usuario
    @Operation(summary = "Eliminar un usuario", description = "Permite eliminar completamente los datos de un usario en especifico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario eliminado exitosamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class)))
    })
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Integer id) {
        Usuario usuarioActual = null;
        usuarioService.eliminarUsuario(id, usuarioActual);
    }

}
