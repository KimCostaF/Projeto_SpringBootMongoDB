package com.kimcosta.ProjetoSpringBoot_MongoDB.config;

import com.kimcosta.ProjetoSpringBoot_MongoDB.domain.User;
import com.kimcosta.ProjetoSpringBoot_MongoDB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
@Configuration
public class Instatiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();


        User maria = new User(null, "Maria Silva", "maria@gmail.com");
        User alex = new User(null, "Alex Souza", "alex@gmail.com");
        User bill = new User(null, "Bill Afonso ", "bill@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bill));
    }
}
