package br.com.fabianoLuiz3103.filmesReview.dto.review;

import br.com.fabianoLuiz3103.filmesReview.dto.filme.CreateAndUpdateFilmeDTO;
import br.com.fabianoLuiz3103.filmesReview.dto.user.CreateAndUpdateUserDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateAndUpdateReviewDTO(

        @NotBlank(message = "Texto é obrigatório! ")
        @Size(min = 12, message = "Texto deve ter no mínimo 12 caracteres! ")
        String texto,
        Long idUser,
        Long idFilme
) {
}
