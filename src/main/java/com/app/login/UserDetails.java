package com.app.login;

import com.app.entities.UsuarioAplicacion;
import com.app.repository.UsuarioAplicacionRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetails implements UserDetailsService {

    private static final String ROLE_USER = "ROLE_USER" ;
    private static final String ROLE_ADMIN = "ROLE_ADMIN" ;
    private final UsuarioAplicacionRepository usuarioAplicacionRepository;

    public UserDetails(UsuarioAplicacionRepository usuarioAplicacionRepository) {
        this.usuarioAplicacionRepository = usuarioAplicacionRepository;
    }


    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //buscamos al usuario, en caso de que el username tenga una @ se busca por email
        Optional<UsuarioAplicacion> usuario = username.contains("@") ? usuarioAplicacionRepository.findByEmail(username) : usuarioAplicacionRepository.findByNombreUsuario(username);
        //Lanzamos excepción si el usuario no se encuentra
        UsuarioAplicacion usuarioAplicacion = usuario.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        //añadimos ROLE_USER y además ROLE_ADMIN en caso de que lo sea
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(ROLE_USER));
        if (usuario.get().getAdmin()) {
            authorities.add(new SimpleGrantedAuthority(ROLE_ADMIN));
        }

        return new User(usuario.get().getNombreUsuario(), usuario.get().getPassword(), authorities);

    }
}
