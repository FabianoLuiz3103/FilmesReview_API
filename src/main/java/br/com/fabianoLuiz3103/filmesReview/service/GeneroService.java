package br.com.fabianoLuiz3103.filmesReview.service;

import br.com.fabianoLuiz3103.filmesReview.dto.genero.CreateAndUpdateGeneroDTO;
import br.com.fabianoLuiz3103.filmesReview.dto.genero.ReadGeneroDTO;
import br.com.fabianoLuiz3103.filmesReview.model.Genero;
import br.com.fabianoLuiz3103.filmesReview.repository.GeneroRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    //Insert
    public ReadGeneroDTO insert(CreateAndUpdateGeneroDTO generoDTO){
        var genero = new Genero(generoDTO);
        genero = generoRepository.save(genero);
        return new ReadGeneroDTO(genero);
    }

    //Read - all
    public List<ReadGeneroDTO> findAll(){
        var generos = generoRepository.findAll();
        return generos.stream().map(ReadGeneroDTO::new).collect(Collectors.toList());
    }

    //Read - by id
    public ReadGeneroDTO findById(Long id){
        var genero = generoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Recurso não encontrado com id: " + id)
        );
        return new ReadGeneroDTO(genero);
    }

    public ReadGeneroDTO update(CreateAndUpdateGeneroDTO generoDTO, Long id){
        var genero = generoRepository.getReferenceById(id);
        genero.atualizar(generoDTO);
        genero = generoRepository.save(genero);
        return new ReadGeneroDTO(genero);
    }

    public void delete(Long id){
        if(!generoRepository.existsById(id)){
            throw new EntityNotFoundException("Recurso não encontrado com id: " + id);
        }
        try{
            generoRepository.deleteById(id);
        }catch (Exception e) {
            if (e.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
                throw new ConstraintViolationException("Não foi possível excluir o registro pois ele está associado a outros dados.", null);
            } else {
                throw new RuntimeException("Erro ao excluir o registro.", e);
            }
        }
    }
}
