package br.com.fabianoLuiz3103.filmesReview.controller;

import br.com.fabianoLuiz3103.filmesReview.dto.filme.CreateAndUpdateFilmeDTO;
import br.com.fabianoLuiz3103.filmesReview.dto.filme.ReadFilmeDTO;
import br.com.fabianoLuiz3103.filmesReview.service.FilmeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    //Create
    @PostMapping
    public ResponseEntity<ReadFilmeDTO> create(@RequestBody @Valid CreateAndUpdateFilmeDTO filmeDTO,
                                               UriComponentsBuilder uriBuilder){
        var filme = filmeService.insert(filmeDTO);
        var uri = uriBuilder.path("/filmes/{id}").buildAndExpand(filme.id()).toUri();
        return ResponseEntity.created(uri).body(filme);
    }

    //Read - all
    @GetMapping
    public ResponseEntity<List<ReadFilmeDTO>> findAll(){
        var filmes = filmeService.findAll();
        return ResponseEntity.ok().body(filmes);
    }

    //Read - by id
    @GetMapping("/{id}")
    public ResponseEntity<ReadFilmeDTO> findById(@PathVariable Long id){
        var filme = filmeService.findById(id);
        return ResponseEntity.ok().body(filme);
    }

    //Update
    @PutMapping("/{id}")
    public ResponseEntity<ReadFilmeDTO> update(@RequestBody @Valid CreateAndUpdateFilmeDTO filmeDTO,
                                               @PathVariable Long id){
        var filme = filmeService.update(filmeDTO, id);
        return ResponseEntity.ok().body(filme);
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        filmeService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
