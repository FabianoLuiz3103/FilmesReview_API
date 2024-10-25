package br.com.fabianoLuiz3103.filmesReview.dto.genero;

import br.com.fabianoLuiz3103.filmesReview.model.Genero;

public record ReadGeneroDTO(

        Long id,
        String nome
) {

    public ReadGeneroDTO(Genero genero){
        this(
                genero.getId(),
                genero.getNome()
        );
    }
}
