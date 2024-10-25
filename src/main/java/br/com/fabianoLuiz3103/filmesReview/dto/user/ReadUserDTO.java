package br.com.fabianoLuiz3103.filmesReview.dto.user;

import br.com.fabianoLuiz3103.filmesReview.model.User;

public record ReadUserDTO(

        Long id,
        String name,
        String email,
        String passworld
) {

    public ReadUserDTO(User user){
        this(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword()
        );
    }
}
