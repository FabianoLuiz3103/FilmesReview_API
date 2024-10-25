package br.com.fabianoLuiz3103.filmesReview.model;

import br.com.fabianoLuiz3103.filmesReview.dto.genero.CreateAndUpdateGeneroDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})

@Entity
@Table(name = "tbl_genero")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "genero")
    private List<Filme> filmes = new ArrayList<>();

    public Genero(CreateAndUpdateGeneroDTO generoDTO){
        if(generoDTO.nome() != null){
            this.nome = generoDTO.nome();
        }
    }

    public void atualizar(CreateAndUpdateGeneroDTO generoDTO){
        if(generoDTO.nome() != null){
            this.nome = generoDTO.nome();
        }
    }
}
