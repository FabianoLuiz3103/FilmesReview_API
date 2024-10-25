package br.com.fabianoLuiz3103.filmesReview.repository;

import br.com.fabianoLuiz3103.filmesReview.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
