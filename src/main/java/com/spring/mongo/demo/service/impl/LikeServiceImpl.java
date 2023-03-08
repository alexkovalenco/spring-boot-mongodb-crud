package com.spring.mongo.demo.service.impl;

import com.spring.mongo.demo.dto.LikeDTO;
import com.spring.mongo.demo.model.Like;
import com.spring.mongo.demo.repository.LikeRepository;
import com.spring.mongo.demo.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {


	@Autowired
	private LikeRepository repository;

	@Override
	public Like create(LikeDTO item) {
		if(item.getUserId() != null){
			Like like = new Like();
			like.setNoteId(item.getNoteId());
			like.setUserId(item.getUserId());
			repository.save(like);
		}
		return null;
	}

	@Override
	public void delete(String id) {
		repository.findById(id).ifPresent(like -> repository.delete(like));
	}

	@Override
	public void deleteByIds(List<String> ids) {
		repository.deleteAll(repository.findAllById(ids));
	}


	@Override
	public List<Like> findAllByUserId(String userId) {
		return repository.findAllByUserId(userId);
	}

	@Override
	public List<Like> findAllByNoteId(String noteId) {
		return repository.findAllByNoteId(noteId);
	}

	@Override
	public void deleteAllByUserId(String userId) {
		repository.deleteAllByUserId(userId);
	}

	@Override
	public void deleteAllByNoteId(String noteId) {
		repository.deleteAllByNoteId(noteId);
	}
}
