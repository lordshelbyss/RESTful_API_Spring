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
@RequestMapping("/note_taking_app/labels")
public class LabelsController {
	
	@Autowired
	LabelsRepository labelsRepository;
	
	@Autowired
	NotesRepository notesRepository;
	
	
	@GetMapping
	public List<Labels> getAllLabels()
	{
		return labelsRepository.findAll();
	}
	
	@PostMapping
	public Labels createNewLabel(@RequestBody Labels label)
	{
		return labelsRepository.save(label);
	}
	
	
	// Assigning label to a note 
	@PutMapping("/{labelId}/notes/{noteId}")
	public Labels assignNoteLabel(@PathVariable Long labelId,@PathVariable Long noteId)
	{
		Labels label=labelsRepository.findById(labelId).get();
		Notes note=notesRepository.findById(noteId).get();
		label.assignNote(note);
		return labelsRepository.save(label);
	}
}
