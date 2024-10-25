package br.com.fabianoLuiz3103.filmesReview.service;

import br.com.fabianoLuiz3103.filmesReview.dto.user.CreateAndUpdateUserDTO;
import br.com.fabianoLuiz3103.filmesReview.dto.user.ReadUserDTO;
import br.com.fabianoLuiz3103.filmesReview.model.User;
import br.com.fabianoLuiz3103.filmesReview.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Insert
    @Transactional
    public ReadUserDTO insert(CreateAndUpdateUserDTO userDTO){
        var user = new User(userDTO);
        user = userRepository.save(user);
        return new ReadUserDTO(user);
    }

    //Read - all
    @Transactional(readOnly = true)
    public List<ReadUserDTO> findAll(){
        var users = userRepository.findAll();
        return users.stream().map(ReadUserDTO::new).collect(Collectors.toList());
    }

    //Read - by id
    @Transactional(readOnly = true)
    public ReadUserDTO findById(Long id){
        var user = userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Recurso não encontrado com id: " + id)
        );
        return new ReadUserDTO(user);
    }

    //Update
    @Transactional
    public ReadUserDTO update(CreateAndUpdateUserDTO userDTO ,Long id){
        var user = userRepository.getReferenceById(id);
        user.atualizar(userDTO);
        user = userRepository.save(user);
        return new ReadUserDTO(user);
    }

    //Delete
    @Transactional
    public void delete(Long id){
        if(!userRepository.existsById(id)){
            throw new EntityNotFoundException("Recurso não encontrado com id: " + id);
        }
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            if (e.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
                throw new ConstraintViolationException("Não foi possível excluir o registro pois ele está associado a outros dados.", null);
            } else {
                throw new RuntimeException("Erro ao excluir o registro.", e);
            }
        }
    }
}
