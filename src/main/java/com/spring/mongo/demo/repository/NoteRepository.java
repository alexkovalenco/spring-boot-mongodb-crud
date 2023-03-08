package com.spring.mongo.demo.repository;

import com.spring.mongo.demo.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository extends MongoRepository<Note, String> {




}
