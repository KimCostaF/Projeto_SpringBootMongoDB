package com.kimcosta.ProjetoSpringBoot_MongoDB.services.servicesException;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException(String msg){
        super(msg);
    }
}
