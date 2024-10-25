package br.com.fabianoLuiz3103.filmesReview.repository;

import br.com.fabianoLuiz3103.filmesReview.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
}
