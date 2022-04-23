package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "*") para el cors del front
public class UsuarioController {

    @GetMapping("/")
    public String home(){
        return "<h2> Bienvenidos! </h2>";
    }

    @GetMapping("/usuario")
    public String usuario(){
        return "<h2> Bienvenido Usuario! </h2>";
    }

    @GetMapping("/admin")
    public String admin(){
        return "<h2> Bienvenido Admin! </h2>";
    }

}
