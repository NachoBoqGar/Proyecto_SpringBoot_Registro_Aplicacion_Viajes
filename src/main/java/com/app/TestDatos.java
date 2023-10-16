package com.app;



import com.app.entities.UsuarioAplicacion;
import com.app.repository.UsuarioAplicacionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TestDatos implements CommandLineRunner {
    private final PasswordEncoder passwordEncoder;
    private final UsuarioAplicacionRepository usuarioAplicacionRepository;

    public TestDatos(PasswordEncoder passwordEncoder, UsuarioAplicacionRepository usuarioAplicacionRepository) {
        this.passwordEncoder = passwordEncoder;
        this.usuarioAplicacionRepository = usuarioAplicacionRepository;
    }

    @Override
    public void run(String... args) {
        // Crea y guarda usuarios de prueba

        UsuarioAplicacion admin1 = new UsuarioAplicacion(1L,"admin","admin","admin","admin@admin",passwordEncoder.encode("admin"),"1", LocalDate.now(),LocalDate.now(),true);

        usuarioAplicacionRepository.save(admin1);

    }
}

