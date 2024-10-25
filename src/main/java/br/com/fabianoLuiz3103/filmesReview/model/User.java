package br.com.fabianoLuiz3103.filmesReview.model;


import br.com.fabianoLuiz3103.filmesReview.dto.user.CreateAndUpdateUserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of={"id"})

@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews = new ArrayList<>();


    public User(CreateAndUpdateUserDTO userDTO){
        if(userDTO.name() != null){
            this.name = userDTO.name();
        }
        if(userDTO.email() != null){
            this.email = userDTO.email();
        }
        if(userDTO.password() != null){
            this.password = userDTO.password();
        }
    }

    public void atualizar(CreateAndUpdateUserDTO userDTO){
        if(userDTO.name() != null){
            this.name = userDTO.name();
        }
        if(userDTO.email() != null){
            this.email = userDTO.email();
        }
        if(userDTO.password() != null){
            this.password = userDTO.password();
        }
    }
}
