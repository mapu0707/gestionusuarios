package com.devsenior.gestionusuarios.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfiguration {

    //Para que springboot lo pueda gestionar
@Bean
public OpenAPI customOpenAPI(){
return new OpenAPI().info(new Info()
                            .title("API de gestion de usuarios")
                            .version("1.0.0")
                            .description(
                                """
                                API resta para la gestion de usuarios de un sistema generico y educativo
                            **Funcionalidades principales como:**
                            -CRUD completo de usuarios(crear, leer, actualiza, eliminar)
                            -gestion de roles
                            -validaciones basadas en permisos dependiendo el rol de usuario
                            - filtrado para consultar informacion especifica de un usuario

                            **Roles disponibles**
                            - ADMINISTRADOR -> Acceso completo a todas las operaciones 
                            - ESTANDAR -> Acceso parcioañ a operaciones de su propio perfil

                            **NOTA** proyecto educativo que se va a ir construyendo con el paso de los modulos en la academia dev senior

                            """)
                        .contact(new Contact().name("Estudiante dev senior")
                        .email("estudiante.devseniorcode.com")
                        .url("https://github.com")).license(new License().name("Proyecto de devsenior.com"))
                    );                     
}    
}
