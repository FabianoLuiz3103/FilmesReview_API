package br.com.fabianoLuiz3103.filmesReview.model;

import br.com.fabianoLuiz3103.filmesReview.dto.filme.CreateAndUpdateFilmeDTO;
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
@Table(name = "tbl_filme")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private Integer ano;

    @OneToMany(mappedBy = "filme")
    private List<Review> reviews = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_genero", nullable = false)
    private Genero genero;

    public Filme(CreateAndUpdateFilmeDTO filmeDTO, Genero genero){
        if(filmeDTO.titulo() != null){
            this.titulo = filmeDTO.titulo();
        }
        if(filmeDTO.ano() != null){
            this.ano = filmeDTO.ano();
        }
        if (genero != null){
            this.genero = genero;
        }
    }

    public void atualizar(CreateAndUpdateFilmeDTO filmeDTO){
        if(filmeDTO.titulo() != null){
            this.titulo = filmeDTO.titulo();
        }
        if(filmeDTO.ano() != null){
            this.ano = filmeDTO.ano();
        }
    }
}
