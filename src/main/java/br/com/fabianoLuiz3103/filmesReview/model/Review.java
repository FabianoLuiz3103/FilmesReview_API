package br.com.fabianoLuiz3103.filmesReview.model;

import br.com.fabianoLuiz3103.filmesReview.dto.review.CreateAndUpdateReviewDTO;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})

@Entity
@Table(name = "tbl_review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String texto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_filme", nullable = false)
    private Filme filme;

    public Review(CreateAndUpdateReviewDTO reviewDTO){
        if(reviewDTO.texto() != null){
            this.texto = reviewDTO.texto();
        }
    }

    public void atualizar(CreateAndUpdateReviewDTO reviewDTO){
        if(reviewDTO.texto() != null){
            this.texto = reviewDTO.texto();
        }
    }
}
