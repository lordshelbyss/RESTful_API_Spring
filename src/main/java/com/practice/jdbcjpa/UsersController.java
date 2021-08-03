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
@RequestMapping("/note_taking_app/users")
public class UsersController {
	@Autowired
    private UsersRepository usersRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    @PostMapping
    public User createNewUser(@RequestBody User user) {
        return usersRepository.save(user);
    }

    
    
    @PutMapping("/{userId}")
    public User updatePost(@PathVariable(value = "userId") Long userId,@RequestBody User userDetails) {
    	User user = usersRepository.findById(userId).get();
	    
	    
	    user.setUserName(userDetails.getUserName());
	  	    
	    User updatedUser = usersRepository.save(user);
	    return updatedUser;
    }
    
    
}
