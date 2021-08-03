package com.practice.jdbcjpa;

public interface NoteService {
	Note addNote(Note note);
	
	Note updateNote(Note note);
	
	Note assignNoteLabel(Long noteId,Long userId);
	
	void deleteNote(Long id);
	
	Note getNote(Long id);
}
