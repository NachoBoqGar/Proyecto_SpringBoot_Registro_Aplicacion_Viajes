package com.app.controller;

import com.app.entities.UsuarioAplicacion;
import com.app.service.RegistroService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistroController {

    private final RegistroService registroService;

    public RegistroController(RegistroService registroService) {
        this.registroService = registroService;
    }

    @GetMapping("/registro")
    public String registro(@ModelAttribute("usuarioAplicacion") final UsuarioAplicacion usuarioAplicacion){
        return "registro";
    }

    @PostMapping("/registro")
    public String registroUsuario(@Valid @ModelAttribute("usuarioAplicacion") final UsuarioAplicacion usuarioAplicacion){
        registroService.registroUsuario(usuarioAplicacion);
        return "redirect:/login?";
    }


}
