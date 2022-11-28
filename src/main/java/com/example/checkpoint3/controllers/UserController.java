package com.example.checkpoint3.controllers;

import com.example.checkpoint3.repositories.UserRepository;
import com.example.checkpoint3.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public User postUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUsers(@PathVariable int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) {
            return optionalUser.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun utilisateur avec cet Id");
    }

    @PutMapping("/{id}")
    public User update(@PathVariable int id, @RequestBody User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        userRepository.deleteById(id);
    }
}
