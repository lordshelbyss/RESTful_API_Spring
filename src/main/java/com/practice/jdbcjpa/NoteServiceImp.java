package com.practice.jdbcjpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImp implements NoteService {
	
	@Autowired
	NotesRepository notesRepository;
	
	@Autowired
	UsersRepository usersRepository;
	
	@Override
	public Note addNote(Note note) {
		// TODO Auto-generated method stub
		return notesRepository.save(note);
	}

	@Override
	public Note updateNote(Note note) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@CacheEvict(value="notes",key="#id")
	public void deleteNote(Long id) {
		// TODO Auto-generated method stub
		notesRepository.deleteById(id);
	}

	@Override
	@Cacheable(value="notes",key="#id")
	public Note getNote(Long id) {
		// TODO Auto-generated method stub
		System.out.println("In get method");
		Optional<Note> note = notesRepository.findById(id);
        if (note.isPresent()) {
            return note.get();
        }
        else {
            return new Note();
        }
	}

	@Override
	@CachePut(value="notes",key="#noteId")
	public Note assignNoteLabel(Long noteId, Long userId) {
		// TODO Auto-generated method stub
		System.out.println("In put method");
		Note note=notesRepository.findById(noteId).get();
		User user=usersRepository.findById(userId).get();
		note.assignUser(user);
		return notesRepository.save(note);
	}

}
