package br.com.fabianoLuiz3103.filmesReview.service;

import br.com.fabianoLuiz3103.filmesReview.dto.review.CreateAndUpdateReviewDTO;
import br.com.fabianoLuiz3103.filmesReview.dto.review.ReadReviewDTO;
import br.com.fabianoLuiz3103.filmesReview.model.Review;
import br.com.fabianoLuiz3103.filmesReview.repository.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    //Insert
    public ReadReviewDTO insert(CreateAndUpdateReviewDTO reviewDTO){
        var review = new Review(reviewDTO);
        review = reviewRepository.save(review);
        return new ReadReviewDTO(review);
    }

    //Read - all
    public List<ReadReviewDTO> findAll(){
        var reviews = reviewRepository.findAll();
        return reviews.stream().map(ReadReviewDTO::new).collect(Collectors.toList());
    }

    //Read - by id
    public ReadReviewDTO findById(Long id){
        var review = reviewRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Recurso não encontrado com id: " + id)
        );
        return new ReadReviewDTO(review);
    }

    //Update
    public ReadReviewDTO update(CreateAndUpdateReviewDTO reviewDTO, Long id){
        var review = reviewRepository.getReferenceById(id);
        review.atualizar(reviewDTO);
        review = reviewRepository.save(review);
        return new ReadReviewDTO(review);
    }

    //Delete
    public void delete(Long id){
        if(!reviewRepository.existsById(id)){
            throw new EntityNotFoundException("Recurso não encontrado com id: " + id);
        }
        try {
            reviewRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Erro ao excluir o registro.", e);
        }
    }
}
