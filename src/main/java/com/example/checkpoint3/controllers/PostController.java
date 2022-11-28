package com.example.checkpoint3.controllers;


import com.example.checkpoint3.dao.Post;
import com.example.checkpoint3.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostRepository postRepository;

    @PostMapping
    public Post postPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @GetMapping
    public List<Post> getPosts() {
        return postRepository.findAll();
    }
}
