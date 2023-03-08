package com.spring.mongo.demo.service.impl;

import com.spring.mongo.demo.dto.NoteDTO;
import com.spring.mongo.demo.model.Note;
import com.spring.mongo.demo.repository.NoteRepository;
import com.spring.mongo.demo.service.LikeService;
import com.spring.mongo.demo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
	

	@Autowired
	private NoteRepository repository;
	@Autowired
	private LikeService likeService;

	@Override
	public Note create(NoteDTO item) {
		Note note = new Note();
		note.setUserId(item.getUserId());
		note.setNote(item.getNote());
		return repository.save(note);
	}

	@Override
	public List<?> findAll() {
		return repository.findAll();
	}


	@Override
	public Page<Note> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Note findById(String id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Note save(Note note) {
		return repository.save(note);
	}

	@Override
	public Note update(Note note) {
		return repository.save(note);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(String id) {
		repository.findById(id).ifPresent(note -> {
			likeService.findAllByNoteId(id);
			repository.delete(note);
		});

	}
}
