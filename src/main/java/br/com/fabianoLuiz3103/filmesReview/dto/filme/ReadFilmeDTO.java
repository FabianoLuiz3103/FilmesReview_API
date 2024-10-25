package br.com.fabianoLuiz3103.filmesReview.dto.filme;

import br.com.fabianoLuiz3103.filmesReview.model.Filme;

public record ReadFilmeDTO(

        Long id,
        String titulo,
        Integer ano
) {

    public ReadFilmeDTO(Filme filme){
        this(
                filme.getId(),
                filme.getTitulo(),
                filme.getAno()
        );
    }
}
