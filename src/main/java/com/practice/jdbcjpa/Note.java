package com.practice.jdbcjpa;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Notes")
public class Note implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6013063132226107374L;


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long noteId;
	
	
	@Column(columnDefinition="varchar(1000)",nullable=false)
	private String noteContent;
	
	

	@Column(columnDefinition="varchar(255)",nullable=false)
	private String noteTitle;
	
	// Write in documentation 
	@JsonIgnore
	@ManyToMany(mappedBy = "notes")
	private Set<Label> labels=new HashSet<>();
	
	// Explore 
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id",referencedColumnName = "userId")
	private User user;
	

	public Note() {};
	
	
	// Getters and Setters 
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	public Long getNoteId() {
		return noteId;
	}

	public void setNoteId(long noteId) {
		this.noteId = noteId;
	}

	
	public String getNoteTitle() {
		return noteTitle;
	}

	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}

	public String getNoteContent() {
		return noteContent;
	}

	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("NotedID=%d,NoteTitle=%s, NoteContent=%s",noteId,noteTitle,noteContent);
	}


	public void assignUser(User user) {
		// TODO Auto-generated method stub
		this.user=user;
	}
	
	
}
