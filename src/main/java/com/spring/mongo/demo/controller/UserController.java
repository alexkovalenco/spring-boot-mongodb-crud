package com.spring.mongo.demo.controller;


import com.spring.mongo.demo.dto.UserDTO;
import com.spring.mongo.demo.model.User;
import com.spring.mongo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody UserDTO userDTO) {
        return new ResponseEntity(userService.create(userDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<?>> findAll() {
        List<?> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody User user) {
        User updatedUser = userService.update(user);
        return ResponseEntity.ok().body(updatedUser);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.ok().body("Deleted successfully...!");
    }
}
