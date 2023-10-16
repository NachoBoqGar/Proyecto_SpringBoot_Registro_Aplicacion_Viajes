package com.app.login;

import com.app.entities.UsuarioAplicacion;
import com.app.repository.UsuarioAplicacionRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetails implements UserDetailsService {

    private final UsuarioAplicacionRepository usuarioAplicacionRepository;

    public UserDetails(UsuarioAplicacionRepository usuarioAplicacionRepository) {
        this.usuarioAplicacionRepository = usuarioAplicacionRepository;
    }


    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioAplicacion usuario = usuarioAplicacionRepository.findByNombreusuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(usuario.getAdmin()){
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }else{
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return new org.springframework.security.core.userdetails.User(usuario.getNombreusuario(),usuario.getPassword(),authorities);
    }
}
