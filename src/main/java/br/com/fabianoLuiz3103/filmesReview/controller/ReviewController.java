package br.com.fabianoLuiz3103.filmesReview.controller;

import br.com.fabianoLuiz3103.filmesReview.dto.review.CreateAndUpdateReviewDTO;
import br.com.fabianoLuiz3103.filmesReview.dto.review.ReadReviewDTO;
import br.com.fabianoLuiz3103.filmesReview.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    //Create
    @PostMapping
    public ResponseEntity<ReadReviewDTO> create(@RequestBody @Valid CreateAndUpdateReviewDTO reviewDTO,
                                                UriComponentsBuilder uriBuilder){
        var review = reviewService.insert(reviewDTO);
        var uri = uriBuilder.path("/reviews/{id}").buildAndExpand(review.id()).toUri();
        return ResponseEntity.created(uri).body(review);
    }

    //Read - all
    @GetMapping
    public ResponseEntity<List<ReadReviewDTO>> findAll(){
        var reviews = reviewService.findAll();
        return ResponseEntity.ok().body(reviews);
    }

    //Read - by id
    @GetMapping("/{id}")
    public ResponseEntity<ReadReviewDTO> findById(@PathVariable Long id){
        var review = reviewService.findById(id);
        return ResponseEntity.ok().body(review);
    }

    //Update
    @PutMapping("/{id}")
    public ResponseEntity<ReadReviewDTO> update(@RequestBody @Valid CreateAndUpdateReviewDTO reviewDTO,
                                                @PathVariable Long id){
        var review = reviewService.update(reviewDTO, id);
        return ResponseEntity.ok().body(review);
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        reviewService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
