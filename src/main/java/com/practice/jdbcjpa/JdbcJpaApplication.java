package com.practice.jdbcjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// This is an implementation without spring web dependency 
//@SpringBootApplication
//public class JdbcJpaApplication implements CommandLineRunner{
//	
//	@Autowired
//	private NotesRepository notesRepository;
//	public static void main(String[] args) {
//		SpringApplication.run(JdbcJpaApplication.class, args);
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		notesRepository.save(new Notes(1,"Tasks for today","Do work"));
//		notesRepository.save(new Notes(3,"Workout","Leg day"));
//		
//		// Prints all the notes records 
//		for(Notes notes:notesRepository.findAll())
//			System.out.println(notes.toString());
//		
//		// This method is custom to the notes interface
//		// Prints all records with the id specified
//		Notes testNote=notesRepository.findById(2L);
//		System.out.println(testNote.toString());
//		
//		
//		
//	}
	
	@SpringBootApplication
	public class JdbcJpaApplication{
		
		@Autowired
		private NotesRepository notesRepository;
		public static void main(String[] args) {
			SpringApplication.run(JdbcJpaApplication.class, args);
		}

		

}
