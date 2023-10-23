package com.app.controller;

import com.app.entities.UsuarioAplicacion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistroController {

    @GetMapping("/registro")
    public String registro(@ModelAttribute("usuarioAplicacion") final UsuarioAplicacion usuarioAplicacion){
        return "registro";
    }



}
