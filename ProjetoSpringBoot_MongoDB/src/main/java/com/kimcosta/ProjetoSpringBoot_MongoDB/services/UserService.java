package com.kimcosta.ProjetoSpringBoot_MongoDB.services;

import com.kimcosta.ProjetoSpringBoot_MongoDB.domain.User;
import com.kimcosta.ProjetoSpringBoot_MongoDB.dto.UserDTO;
import com.kimcosta.ProjetoSpringBoot_MongoDB.repository.UserRepository;
import com.kimcosta.ProjetoSpringBoot_MongoDB.services.servicesException.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{

    @Autowired
    private UserRepository repo;
    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        Optional<User> user = repo.findById(id);
        return user.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert (User obj){
        return repo.insert(obj);
    }

    public void delete (String id){
            findById(id);
            repo.deleteById(id);
    }

    public User update(User obj) {
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(),objDTO.getNome(),objDTO.getEmail());
    }


}
