package com.kimcosta.ProjetoSpringBoot_MongoDB.services;

import com.kimcosta.ProjetoSpringBoot_MongoDB.domain.Post;
import com.kimcosta.ProjetoSpringBoot_MongoDB.domain.User;
import com.kimcosta.ProjetoSpringBoot_MongoDB.dto.UserDTO;
import com.kimcosta.ProjetoSpringBoot_MongoDB.repository.PostRepository;
import com.kimcosta.ProjetoSpringBoot_MongoDB.repository.UserRepository;
import com.kimcosta.ProjetoSpringBoot_MongoDB.services.servicesException.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PostService {
    @Autowired
    private PostRepository repo;
    public Post findById(String id){
        Optional<Post> post = repo.findById(id);
        return post.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
    }


}
