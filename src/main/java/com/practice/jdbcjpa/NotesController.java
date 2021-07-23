package com.practice.jdbcjpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/note_taking_app")
public class NotesController {
	
	@Autowired
	NotesRepository notesRepository;
	
	@Autowired
	UsersRepository usersRepository;
	
	@GetMapping("/notes")	
	public List<Notes> getAllNotes()
	{
		return notesRepository.findAll();
	}
	
	@PostMapping("/notes")
	public Notes createNewLabel(@RequestBody Notes note)
	{
		return notesRepository.save(note);
	}
	
	
	
	// Assign note to a user 
	@PutMapping("/users/{userId}/notes/{noteId}")
	public Notes assignNoteLabel(@PathVariable Long noteId,@PathVariable Long userId)
	{
		Notes note=notesRepository.findById(noteId).get();
		Users user=usersRepository.findById(userId).get();
		note.assignUser(user);
		return notesRepository.save(note);
	}
	
	
}
