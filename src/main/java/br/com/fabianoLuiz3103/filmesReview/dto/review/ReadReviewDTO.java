package br.com.fabianoLuiz3103.filmesReview.dto.review;

import br.com.fabianoLuiz3103.filmesReview.model.Review;

public record ReadReviewDTO(

        Long id,
        String texto,
        String user,
        String filme
) {
    public ReadReviewDTO(Review review){
        this(
                review.getId(),
                review.getTexto(),
                review.getUser().getName(),
                review.getFilme().getTitulo()
        );
    }
}
