package com.app.service;

import com.app.entities.UsuarioAplicacion;
import com.app.repository.UsuarioAplicacionRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistroService {

    private final PasswordEncoder passwordEncoder;
    private final UsuarioAplicacionRepository usuarioAplicacionRepository;

    private RegistroService(final PasswordEncoder passwordEncoder, UsuarioAplicacionRepository usuarioAplicacionRepository){

        this.passwordEncoder = passwordEncoder;
        this.usuarioAplicacionRepository = usuarioAplicacionRepository;
    }

    public void registroUsuario (UsuarioAplicacion usuarioAplicacion){
        usuarioAplicacion.setPassword(passwordEncoder.encode(usuarioAplicacion.getPassword()));
        System.out.println(usuarioAplicacion.getCodigoPais());
        usuarioAplicacionRepository.save(usuarioAplicacion);
    }
}
