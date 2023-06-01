package com.kimcosta.ProjetoSpringBoot_MongoDB.config;

import com.kimcosta.ProjetoSpringBoot_MongoDB.domain.Post;
import com.kimcosta.ProjetoSpringBoot_MongoDB.domain.User;
import com.kimcosta.ProjetoSpringBoot_MongoDB.repository.PostRepository;
import com.kimcosta.ProjetoSpringBoot_MongoDB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
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

        Post post1 = new Post(null,sdf.parse("21/03/2023"),"Partiu viagem","Vou viajar flws",carlos);
        Post post2 = new Post(null,sdf.parse("23/03/2023"),"Bom dia","Acordei bem hoje",carlos);

        userRepository.saveAll(Arrays.asList(carlos,alex,maria));
        postRepository.saveAll(Arrays.asList(post1,post2));
    }
}
