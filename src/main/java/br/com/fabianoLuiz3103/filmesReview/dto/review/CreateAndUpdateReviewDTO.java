package br.com.fabianoLuiz3103.filmesReview.dto.review;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateAndUpdateReviewDTO(

        @NotBlank(message = "Texto é obrigatório! ")
        @Size(min = 12, message = "Texto deve ter no mínimo 12 caracteres! ")
        String texto
) {
}
