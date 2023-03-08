package com.spring.mongo.demo.controller;


import com.spring.mongo.demo.dto.LikeDTO;
import com.spring.mongo.demo.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    private LikeService likeService;


    @PostMapping()
    public ResponseEntity<?> create(@RequestBody LikeDTO likeDTO) {
        return new ResponseEntity(likeService.create(likeDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        likeService.delete(id);
        return ResponseEntity.ok().body("Deleted successfully...!");
    }
}
