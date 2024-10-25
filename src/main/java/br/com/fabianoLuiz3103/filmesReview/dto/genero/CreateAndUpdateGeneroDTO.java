package br.com.fabianoLuiz3103.filmesReview.dto.genero;

import jakarta.validation.constraints.NotBlank;

public record CreateAndUpdateGeneroDTO(

        @NotBlank(message = "Nome é obrigatório! ")
        String nome
) {
}
