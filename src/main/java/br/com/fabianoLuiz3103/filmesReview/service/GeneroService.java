package br.com.fabianoLuiz3103.filmesReview.service;

import br.com.fabianoLuiz3103.filmesReview.dto.genero.CreateAndUpdateGeneroDTO;
import br.com.fabianoLuiz3103.filmesReview.dto.genero.ReadGeneroDTO;
import br.com.fabianoLuiz3103.filmesReview.model.Genero;
import br.com.fabianoLuiz3103.filmesReview.repository.GeneroRepository;
import br.com.fabianoLuiz3103.filmesReview.service.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    //Insert
    @Transactional
    public ReadGeneroDTO insert(CreateAndUpdateGeneroDTO generoDTO){
        var genero = new Genero(generoDTO);
        genero = generoRepository.save(genero);
        return new ReadGeneroDTO(genero);
    }

    //Read - all
    @Transactional(readOnly = true)
    public List<ReadGeneroDTO> findAll(){
        var generos = generoRepository.findAll();
        return generos.stream().map(ReadGeneroDTO::new).collect(Collectors.toList());
    }

    //Read - by id
    @Transactional(readOnly = true)
    public ReadGeneroDTO findById(Long id){
        var genero = generoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado com id: " + id)
        );
        return new ReadGeneroDTO(genero);
    }

    //Update
    @Transactional
    public ReadGeneroDTO update(CreateAndUpdateGeneroDTO generoDTO, Long id){
        var genero = generoRepository.getReferenceById(id);
        genero.atualizar(generoDTO);
        genero = generoRepository.save(genero);
        return new ReadGeneroDTO(genero);
    }

    //Delete
    @Transactional
    public void delete(Long id){
        if(!generoRepository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado com id: " + id);
        }
        try{
            generoRepository.deleteById(id);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }
}
