package com.kimcosta.ProjetoSpringBoot_MongoDB.repository;

import com.kimcosta.ProjetoSpringBoot_MongoDB.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {


}
