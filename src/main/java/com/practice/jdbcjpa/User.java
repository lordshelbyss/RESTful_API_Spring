package com.practice.jdbcjpa;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Users")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4877245408781108645L;


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userId;
	
	
	@Column(columnDefinition="varchar(1000)",nullable=false)
	private String userName;
	
	@Column(columnDefinition="varchar(255)",nullable=false)
	private String userPassword;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private Set<Note> userNotes=new HashSet<>();
	
	

	public User() {}
	

	// Getters and setters 	
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	};
	
	public Set<Note> getUserNotes() {
		return userNotes;
	}



	public void setUserNotes(Set<Note> userNotes) {
		this.userNotes = userNotes;
	}
	
	
}
