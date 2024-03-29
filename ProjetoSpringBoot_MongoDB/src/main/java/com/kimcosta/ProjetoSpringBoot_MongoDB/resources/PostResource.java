package com.kimcosta.ProjetoSpringBoot_MongoDB.resources;

import com.kimcosta.ProjetoSpringBoot_MongoDB.domain.Post;
import com.kimcosta.ProjetoSpringBoot_MongoDB.services.PostService;
import com.kimcosta.ProjetoSpringBoot_MongoDB.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
    @Autowired
    private PostService service;
    @RequestMapping(value ="/{id}",method=RequestMethod.GET)
    public ResponseEntity <Post> findById(@PathVariable String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value ="/titlesearch",method=RequestMethod.GET)
    public ResponseEntity <List<Post>> findByTitle(@RequestParam(value = "text",defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }





}
