package com.kimcosta.ProjetoSpringBoot_MongoDB.services;

import com.kimcosta.ProjetoSpringBoot_MongoDB.domain.User;
import com.kimcosta.ProjetoSpringBoot_MongoDB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{

    @Autowired
    private UserRepository repo;
    public List<User> findAll(){
        return repo.findAll();
    }


}
