package com.practice.jdbcjpa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="Labels")
public class Label {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long labelId;
	

	@Column(columnDefinition="varchar(1000)",nullable=false)
	private String labelTitle;
	
		
	@ManyToMany
	@JoinTable(name="labels_notes",joinColumns=@JoinColumn(name="label_id"),inverseJoinColumns=@JoinColumn(name="note_id"))
	private Set<Note> notes=new HashSet<>();
	

	public Set<Note> getNotes() {
		return notes;
	}


	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}

	
	public Long getLabelId() {
		return labelId;
	}


	public void setLabelId(Long labelId) {
		this.labelId = labelId;
	}
	
	public String getLabelTitle() {
		return labelTitle;
	}


	public void setLabelTitle(String labelTitle) {
		this.labelTitle = labelTitle;
	}


	public void assignNote(Note note) {
		// TODO Auto-generated method stub
		notes.add(note);
	}
	
	
}
