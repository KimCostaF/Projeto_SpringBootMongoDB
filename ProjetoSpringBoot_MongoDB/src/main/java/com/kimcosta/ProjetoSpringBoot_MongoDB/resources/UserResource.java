package com.kimcosta.ProjetoSpringBoot_MongoDB.resources;


import com.kimcosta.ProjetoSpringBoot_MongoDB.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {
    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity <List<User>> findAll(){
        User maria = new User("1","Maria Silva","maria@gmail.com");
        User joao = new User("2","João Silva","jo@gmail.com");
        List<User> list = new ArrayList<>(Arrays.asList(maria, joao));
        return ResponseEntity.ok().body(list);
    }
}
