package com.kimcosta.ProjetoSpringBoot_MongoDB.dto;

import com.kimcosta.ProjetoSpringBoot_MongoDB.domain.User;

public class AuthorDTO {
    private String id;
    private String nome;

    public AuthorDTO() {
    }

    public AuthorDTO(User obj){
    id = obj.getId();
    nome = obj.getNome();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
