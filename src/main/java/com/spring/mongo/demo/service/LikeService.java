package com.spring.mongo.demo.service;


import com.spring.mongo.demo.dto.LikeDTO;
import com.spring.mongo.demo.model.Like;

import java.util.List;

public interface LikeService {

	Like create(LikeDTO item);

	void delete(String id);

	void deleteByIds(List<String> ids);

	List<Like> findAllByUserId(String userId);

	List<Like> findAllByNoteId(String noteId);

	void deleteAllByUserId(String userId);

	void deleteAllByNoteId(String noteId);
}
