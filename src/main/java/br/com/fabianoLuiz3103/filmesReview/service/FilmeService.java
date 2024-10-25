package br.com.fabianoLuiz3103.filmesReview.service;

import br.com.fabianoLuiz3103.filmesReview.dto.filme.CreateAndUpdateFilmeDTO;
import br.com.fabianoLuiz3103.filmesReview.dto.filme.ReadFilmeDTO;
import br.com.fabianoLuiz3103.filmesReview.model.Filme;
import br.com.fabianoLuiz3103.filmesReview.repository.FilmeRepository;
import br.com.fabianoLuiz3103.filmesReview.repository.GeneroRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private GeneroRepository generoRepository;

    //Insert
    @Transactional
    public ReadFilmeDTO insert(CreateAndUpdateFilmeDTO filmeDTO){
        var genero = generoRepository.findById(filmeDTO.idGenero()).orElseThrow(
                () -> new EntityNotFoundException("Gênero não encontrado com id: " + filmeDTO.idGenero())
        );
        var filme = new Filme(filmeDTO, genero);
        filme = filmeRepository.save(filme);
        return new ReadFilmeDTO(filme);
    }

    //Read - all
    @Transactional(readOnly = true)
    public List<ReadFilmeDTO> findAll(){
        var filmes = filmeRepository.findAll();
        return filmes.stream().map(ReadFilmeDTO::new).collect(Collectors.toList());
    }

    //Read - by id
    @Transactional(readOnly = true)
    public ReadFilmeDTO findById(Long id){
        var filme = filmeRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Recurso não encontrado com id: " + id)
        );
        return new ReadFilmeDTO(filme);
    }

    //Update
    @Transactional
    public ReadFilmeDTO update(CreateAndUpdateFilmeDTO filmeDTO, Long id){
        var filme = filmeRepository.getReferenceById(id);
        filme.atualizar(filmeDTO);
        filme = filmeRepository.save(filme);
        return new ReadFilmeDTO(filme);
    }

    //Delete
    @Transactional
    public void delete(Long id){
        if(!filmeRepository.existsById(id)){
            throw new EntityNotFoundException("Recurso não encontrado com id: " + id);
        }
        try{
            filmeRepository.deleteById(id);
        }catch (Exception e) {
            if (e.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
                throw new ConstraintViolationException("Não foi possível excluir o registro pois ele está associado a outros dados.", null);
            } else {
                throw new RuntimeException("Erro ao excluir o registro.", e);
            }
        }
    }
}
