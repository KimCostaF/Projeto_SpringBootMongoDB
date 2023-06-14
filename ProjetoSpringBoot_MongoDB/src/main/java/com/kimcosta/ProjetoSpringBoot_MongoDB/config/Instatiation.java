package com.kimcosta.ProjetoSpringBoot_MongoDB.config;

import com.kimcosta.ProjetoSpringBoot_MongoDB.domain.Post;
import com.kimcosta.ProjetoSpringBoot_MongoDB.domain.User;
import com.kimcosta.ProjetoSpringBoot_MongoDB.dto.AuthorDTO;
import com.kimcosta.ProjetoSpringBoot_MongoDB.dto.CommentDTO;
import com.kimcosta.ProjetoSpringBoot_MongoDB.repository.PostRepository;
import com.kimcosta.ProjetoSpringBoot_MongoDB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instatiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        userRepository.deleteAll();
        postRepository.deleteAll();


        User carlos = new User(null, "Carlos Silva", "carlos@gmail.com");
        User alex = new User(null, "Alex Souza", "alex@gmail.com");
        User maria = new User(null,"Maria Souza","maria@gmail.com");

        userRepository.saveAll(Arrays.asList(carlos,alex,maria));

        Post post1 = new Post(null,sdf.parse("21/03/2023"),"Partiu viagem","Vou viajar flws",new AuthorDTO(carlos));
        Post post2 = new Post(null,sdf.parse("23/03/2023"),"Bom dia","Acordei bem hoje",new AuthorDTO(carlos));

        CommentDTO c1 = new CommentDTO("boa viagem!",sdf.parse("21/03/2018"),new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("vai na fe filhao!",sdf.parse("21/03/2018"),new AuthorDTO(alex));
        CommentDTO c3 = new CommentDTO("Tenha uma otima viagem corno!!!",sdf.parse("22/03/2018"),new AuthorDTO(maria));

        post1.getComments().addAll(Arrays.asList(c1,c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1,post2));

        carlos.getPosts().addAll(Arrays.asList(post1,post2));
        userRepository.save(carlos);
    }
}
