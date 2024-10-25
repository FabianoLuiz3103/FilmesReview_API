package br.com.fabianoLuiz3103.filmesReview.controller;

import br.com.fabianoLuiz3103.filmesReview.dto.genero.CreateAndUpdateGeneroDTO;
import br.com.fabianoLuiz3103.filmesReview.dto.genero.ReadGeneroDTO;
import br.com.fabianoLuiz3103.filmesReview.service.GeneroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/generos")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    //Create
    @PostMapping
    public ResponseEntity<ReadGeneroDTO> create(@RequestBody @Valid CreateAndUpdateGeneroDTO generoDTO,
                                                UriComponentsBuilder uriBuilder){
        var genero = generoService.insert(generoDTO);
        var uri = uriBuilder.path("/generos/{id}").buildAndExpand(genero.id()).toUri();
        return ResponseEntity.created(uri).body(genero);
    }

    //Read - all
    @GetMapping
    public ResponseEntity<List<ReadGeneroDTO>> findAll(){
        var generos = generoService.findAll();
        return ResponseEntity.ok().body(generos);
    }

    //Read - by id
    @GetMapping("/{id}")
    public ResponseEntity<ReadGeneroDTO> findById(@PathVariable Long id){
        var genero = generoService.findById(id);
        return ResponseEntity.ok().body(genero);
    }

    //Update
    @PutMapping("/{id}")
    public ResponseEntity<ReadGeneroDTO> update(@RequestBody @Valid CreateAndUpdateGeneroDTO generoDTO,
                                                @PathVariable Long id){
        var genero = generoService.update(generoDTO, id);
        return ResponseEntity.ok().body(genero);
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        generoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
