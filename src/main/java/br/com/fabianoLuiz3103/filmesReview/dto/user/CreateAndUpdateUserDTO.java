package br.com.fabianoLuiz3103.filmesReview.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateAndUpdateUserDTO(

        @NotBlank(message = "Nome é obrigatório! ")
        @Size(min = 5, message = "Nome deve ter no mínimo 5 caracteres! ")
        String name,
        @NotBlank(message = "E-mail é obrigatório! ")
        @Email(message = "Formato de e-mail inválido! ")
        String email,
        @NotBlank(message = "Senha é obrigatório! ")
        @Size(min = 12, message = "Senha deve ter no mínimo 12 caracteres! ")
        String password
) {
}
