package com.spring.mongo.demo.controller;

import com.spring.mongo.demo.dto.NoteDTO;
import com.spring.mongo.demo.model.Note;
import com.spring.mongo.demo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {
	
	@Autowired
	private NoteService noteService;

	@PostMapping()
	public ResponseEntity<?> create(@RequestBody NoteDTO noteDTO) {
		return new ResponseEntity(noteService.create(noteDTO), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable String id) {
		Note note = noteService.findById(id);
		return ResponseEntity.ok().body(note);
	}

	@GetMapping(path = "/notes")
	public ResponseEntity<?> finsNotes(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
	                                         @RequestParam(value = "size", required = false, defaultValue = "15") Integer size,
	                                         @RequestParam() Sort sort) {
		Pageable pageable = PageRequest.of(page, size, sort);
		List<Note> content = noteService.findAll(pageable).getContent();
		if(content.isEmpty()){
			return new ResponseEntity<>(content, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(content, HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<List<?>> findAll() {
		List<?> list = noteService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody Note note) {
		Note updatedNote = noteService.update(note);
		return ResponseEntity.ok().body(updatedNote);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		noteService.delete(id);
		return ResponseEntity.ok().body("Deleted successfully...!");
	}
}




