package com.app.validation;

import com.app.dto.RegistroUsuarioAplicacionDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, RegistroUsuarioAplicacionDTO> {
    @Override
    public boolean isValid(RegistroUsuarioAplicacionDTO registroUsuarioAplicacionDTO, ConstraintValidatorContext constraintValidatorContext) {

        String password = registroUsuarioAplicacionDTO.getPassword();
        String passwordConfirmation = registroUsuarioAplicacionDTO.getPasswordConfirmacion();

        return password.equals(passwordConfirmation);
    }
}
