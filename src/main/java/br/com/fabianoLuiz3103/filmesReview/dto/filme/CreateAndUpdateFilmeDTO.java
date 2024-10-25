package br.com.fabianoLuiz3103.filmesReview.dto.filme;

import jakarta.validation.constraints.*;

public record CreateAndUpdateFilmeDTO(

        @NotBlank(message = "Título é obrigatório! ")
        String titulo,
        @NotNull(message = "Ano é obrigatório! ")
        @Min(value = 1900, message = "Ano deve ser pelo menos 1900")
        @Max(value = 2100, message = "Ano deve ser no máximo 2100")
        @Positive(message = "Ano deve ser um número positivo")
        Integer ano
) {
}
