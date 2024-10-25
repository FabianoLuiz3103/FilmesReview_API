package br.com.fabianoLuiz3103.filmesReview.dto.filme;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CreateAndUpdateFilmeDTO(

        @NotBlank(message = "Título é obrigatório! ")
        String titulo,
        @NotNull(message = "Ano é obrigatório! ")
        @Size(min = 4, max = 4, message = "Ano deve ter 4 caracteres! ")
        @Positive(message = "Ano deve ser um número positivo")
        Integer ano
) {
}
