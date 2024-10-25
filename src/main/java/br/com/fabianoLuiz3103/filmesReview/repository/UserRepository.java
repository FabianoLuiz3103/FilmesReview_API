package br.com.fabianoLuiz3103.filmesReview.repository;

import br.com.fabianoLuiz3103.filmesReview.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
