package com.kimcosta.ProjetoSpringBoot_MongoDB.resources;


import com.kimcosta.ProjetoSpringBoot_MongoDB.domain.User;
import com.kimcosta.ProjetoSpringBoot_MongoDB.dto.UserDTO;
import com.kimcosta.ProjetoSpringBoot_MongoDB.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/users")
public class UserResource {
    @Autowired
    private UserService service;
    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity <List<UserDTO>> findAll(){
        List<User> list = service.findAll();
        List<UserDTO> listdto = list.stream().map(x->new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listdto);
    }
}
