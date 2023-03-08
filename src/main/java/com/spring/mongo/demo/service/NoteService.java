package com.spring.mongo.demo.service;


import com.spring.mongo.demo.dto.NoteDTO;
import com.spring.mongo.demo.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NoteService {

	Note create(NoteDTO item);

	List<?> findAll();

	Page<Note> findAll(Pageable pageable);

	Note findById(String id);

	Note save(Note note);

	Note update(Note superHero);

	void delete(String id);
}
