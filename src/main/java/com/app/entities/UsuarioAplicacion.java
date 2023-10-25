package com.app.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

@Entity
public class UsuarioAplicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreUsuario;
    private String nombre;
    private String apellidos;
    @Email
    @NotEmpty(message = "El email es obligatorio")
    private String email;
    @NotEmpty(message = "La password es obligatoria")
    private String password;
    private String codigoPais;
    private LocalDate fechaNacimiento;
    private LocalDate creado = LocalDate.now();
    private Boolean admin = false;
    /*añadir relacion perfiles seguidos
    @JoinTable(name = "Seguidor",
               joinColumns = @JoinColumn(name = "seguidorId"),
               inverseJoinColumns = @JoinColumn(name = "seguidoId")
    )
    @ManyToMany
    private Set<Perfil> perfilesSeguidos;*/

    public UsuarioAplicacion() {
    }

    public UsuarioAplicacion(Long id, String nombreusuario, String nombre, String apellidos, String email, String password, String codigoPais, LocalDate fechaNacimiento, LocalDate creado, Boolean admin) {
        this.id = id;
        this.nombreUsuario = nombreusuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
        this.codigoPais = codigoPais;
        this.fechaNacimiento = fechaNacimiento;
        this.creado = creado;
        this.admin = admin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getCreado() {
        return creado;
    }

    public void setCreado(LocalDate creado) {
        this.creado = creado;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
}
