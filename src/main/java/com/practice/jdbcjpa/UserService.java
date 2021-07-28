package com.practice.jdbcjpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
    private UsersRepository repo;
     
    public void processOAuthPostLogin(String username) {
        Optional<Users> existUser = repo.findByUserName(username);
         
        if (existUser == null) {
            Users newUser = new Users();
            newUser.setUserName(username);
            newUser.setProvider(Provider.GOOGLE);
             
            repo.save(newUser);        
        }
         
    }
}
