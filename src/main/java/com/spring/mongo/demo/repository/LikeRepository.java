package com.spring.mongo.demo.repository;

import com.spring.mongo.demo.model.Like;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LikeRepository extends MongoRepository<Like, String> {

    List<Like> findAllByUserId(String userId);

    List<Like> findAllByNoteId(String noteId);

    void deleteAllByUserId(String userId);

    void deleteAllByNoteId(String noteId);
}
