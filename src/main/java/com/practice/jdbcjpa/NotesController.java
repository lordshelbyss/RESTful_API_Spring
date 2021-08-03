package com.practice.jdbcjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	@Autowired
	NoteService noteService;
	
//	@GetMapping("/notes")	
//	public List<Note> getAllNotes()
//	{
//		return notesRepository.findAll();
//	}
	
	@GetMapping("/notes/{id}")	
	public Note getNote(@PathVariable Long id)
	{
		return noteService.getNote(id);
	}
	
	@PostMapping("/notes")
	public Note addNote(@RequestBody Note note)
	{
		return noteService.addNote(note);
	}
	
	@DeleteMapping("/notes/{id}")
    public void deleteNote(@PathVariable long id) {
		noteService.deleteNote(id);
		return;
    }
	
	// Assign note to a user 
	@PutMapping("/users/{userId}/notes/{noteId}")
	public Note assignNoteLabel(@PathVariable Long noteId,@PathVariable Long userId)
	{	
		return noteService.assignNoteLabel(noteId,userId);
	}
	
	
}
