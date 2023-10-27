package com.app.dto;

import com.app.validation.PasswordMatches;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDate;

//clase con los campos y restriciones para hacer comprobaciones previas antes de guardar el usuario en la BBDD
@PasswordMatches
public class RegistroUsuarioAplicacionDTO {

    @NotBlank
    private String nombreUsuario;
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellidos;
    @Email
    @NotEmpty(message = "El email es obligatorio")
    private String email;
    @NotEmpty(message = "La contraseña es obligatoria")
    private String password;
    @NotEmpty(message = "Es necesario confirmar la contraseña")
    private String passwordConfirmacion;
    @NotEmpty(message = "Debes seleccionar un país")
    private String codigoPais;
    @NotNull(message = "Debes indicar tu fecha de nacimiento")
    private LocalDate fechaNacimiento;

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

    public String getPasswordConfirmacion() {
        return passwordConfirmacion;
    }

    public void setPasswordConfirmacion(String passwordConfirmacion) {
        this.passwordConfirmacion = passwordConfirmacion;
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

    @Override
    public String toString() {
        return "RegistroUsuarioAplicacionDTO{" +
                "nombreUsuario='" + nombreUsuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", passwordConfirmacion='" + passwordConfirmacion + '\'' +
                ", codigoPais='" + codigoPais + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
