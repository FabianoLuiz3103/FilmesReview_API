package br.com.fabianoLuiz3103.filmesReview.repository;

import br.com.fabianoLuiz3103.filmesReview.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
