package com.example.checkpoint3.controllers;


import com.example.checkpoint3.dao.Comment;
import com.example.checkpoint3.repositories.CommentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public Comment postComment(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

    @GetMapping
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Comment getComments(@PathVariable int id) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if(optionalComment.isPresent()) {
            return optionalComment.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun commentaire avec cet Id");
    }
}
