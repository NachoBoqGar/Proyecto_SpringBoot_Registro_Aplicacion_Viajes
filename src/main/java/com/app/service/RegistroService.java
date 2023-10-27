package com.app.service;

import com.app.dto.RegistroUsuarioAplicacionDTO;
import com.app.entities.UsuarioAplicacion;
import com.app.exceptions.UserException;
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

    public void registroUsuario (RegistroUsuarioAplicacionDTO usuarioAplicacionDTO) throws UserException {
        if (emailExiste(usuarioAplicacionDTO)) {
            throw new UserException(UserException.ErrorType.EMAIL_EXIST);
        }
        if (nombreusuarioExiste(usuarioAplicacionDTO)) {
            throw new UserException(UserException.ErrorType.USER_EXIST);
        }

        UsuarioAplicacion usuarioAplicacion = adaptarUsuario(usuarioAplicacionDTO);
        usuarioAplicacion.setPassword(passwordEncoder.encode(usuarioAplicacionDTO.getPassword()));
        usuarioAplicacionRepository.save(usuarioAplicacion);
    }

    private boolean nombreusuarioExiste(RegistroUsuarioAplicacionDTO usuarioAplicacionDTO) {
        return usuarioAplicacionRepository.findByNombreUsuario(usuarioAplicacionDTO.getNombreUsuario()).isPresent();
    }

    private boolean emailExiste(RegistroUsuarioAplicacionDTO usuarioAplicacionDTO) {
        return usuarioAplicacionRepository.findByEmail(usuarioAplicacionDTO.getEmail()).isPresent();
    }

    //metodo para guardar el usuario con los campos prsentes en la BBDD
    public UsuarioAplicacion adaptarUsuario(RegistroUsuarioAplicacionDTO usuarioAplicacionDTO){
        UsuarioAplicacion usuarioAplicacion = new UsuarioAplicacion();
        usuarioAplicacion.setNombreUsuario(usuarioAplicacionDTO.getNombreUsuario());
        usuarioAplicacion.setNombre(usuarioAplicacionDTO.getNombre());
        usuarioAplicacion.setApellidos(usuarioAplicacionDTO.getApellidos());
        usuarioAplicacion.setCodigoPais(usuarioAplicacionDTO.getCodigoPais());
        usuarioAplicacion.setFechaNacimiento(usuarioAplicacionDTO.getFechaNacimiento());
        usuarioAplicacion.setEmail(usuarioAplicacionDTO.getEmail());
        usuarioAplicacion.setPassword(usuarioAplicacionDTO.getPassword());
        usuarioAplicacion.setAdmin(false);
        return usuarioAplicacion;
    }
}
