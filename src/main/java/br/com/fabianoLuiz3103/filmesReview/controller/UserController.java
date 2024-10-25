package br.com.fabianoLuiz3103.filmesReview.controller;

import br.com.fabianoLuiz3103.filmesReview.dto.user.CreateAndUpdateUserDTO;
import br.com.fabianoLuiz3103.filmesReview.dto.user.ReadUserDTO;
import br.com.fabianoLuiz3103.filmesReview.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //Create
    @PostMapping
    public ResponseEntity<ReadUserDTO> create(@RequestBody @Valid CreateAndUpdateUserDTO userDTO,
                                              UriComponentsBuilder uriBuilder){
        var user = userService.insert(userDTO);
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.id()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    //Read - all
    @GetMapping
    public ResponseEntity<List<ReadUserDTO>> findAll(){
        var users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }

    //Read - by id
    @GetMapping("/{id}")
    public ResponseEntity<ReadUserDTO> findById(@PathVariable Long id){
        var user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    //Update
    @PutMapping("/{id}")
    public ResponseEntity<ReadUserDTO> update(@RequestBody @Valid CreateAndUpdateUserDTO userDTO, @PathVariable Long id){
        var user = userService.update(userDTO, id);
        return ResponseEntity.ok().body(user);
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
