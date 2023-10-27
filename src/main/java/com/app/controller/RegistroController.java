package com.app.controller;

import com.app.dto.RegistroUsuarioAplicacionDTO;
import com.app.exceptions.UserException;
import com.app.service.RegistroService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String registro(@ModelAttribute("registroUsuarioAplicacion") final RegistroUsuarioAplicacionDTO registroUsuarioAplicacion){
        return "registro";
    }

    @PostMapping("/registro")
    public String registroUsuario(@Valid @ModelAttribute("registroUsuarioAplicacion") final RegistroUsuarioAplicacionDTO registroUsuarioAplicacion, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {

            return "registro";
        }
        try {
            registroService.registroUsuario(registroUsuarioAplicacion);

        } catch (UserException ex) {
            if (ex.getErrorType() == UserException.ErrorType.USER_EXIST)
                model.addAttribute("error", "El usuario ya existe");
            if (ex.getErrorType() == UserException.ErrorType.EMAIL_EXIST)
                model.addAttribute("error", "Ya hay un usuario registrado con ese email");

            // Redirigir de nuevo a la página de registro con el mensaje de error
            return "registro";
        }

        return "redirect:/login?registered";
    }


}
